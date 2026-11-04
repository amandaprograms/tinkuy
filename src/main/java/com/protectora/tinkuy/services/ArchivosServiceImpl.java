package com.protectora.tinkuy.services;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

@Service
public class ArchivosServiceImpl implements ArchivosService {

    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmssSSS");
    private static final Map<String, String> TIPOS_PERMITIDOS = Map.of("jpg", "image/jpeg", "jpeg", "image/jpeg", "png", "image/png", "webp", "image/webp");
    private final Path rootLocation = Paths.get("uploadFiles", "animales").toAbsolutePath().normalize();

    public ArchivosServiceImpl() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo inicializar la carpeta de almacenamiento", e);
        }
    }

    @Override
    public String almacenarArchivo(MultipartFile file, Long id) {

        comprobarArchivoExiste(file);
        String filename = comprobarArchivoCorrecto(file);
        String extension = StringUtils.getFilenameExtension(filename).toLowerCase(Locale.ROOT);
        comprobarExtension(extension);
        comprobarTipoContenido(file, extension);
        comprobarContenidoImagen(file, extension);
        try (InputStream inputStream = file.getInputStream()) {
            String nombreBase = "animal-" + id + "-" + LocalDateTime.now().format(FORMATO_FECHA);
            Path destination;
            String storedFilename;
            Integer contador = 0;
            do {
                String sufijo = contador == 0 ? "" : "-" + contador;
                storedFilename = nombreBase + sufijo + "." + extension;
                destination = rootLocation.resolve(storedFilename).normalize();
                contador++;
            } while (Files.exists(destination));

            if (!destination.startsWith(rootLocation)) {

                throw new RuntimeException("Ruta de archivo no válida");
            }
            Files.copy(inputStream, destination);
            return storedFilename;
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar el archivo", e);
        }
    }

    @Override
    public void comprobarArchivoExiste(MultipartFile file) {

        if (file == null || file.isEmpty()) {
            throw new RuntimeException("El archivo está vacío");
        }
    }

    @Override
    public String comprobarArchivoCorrecto(MultipartFile file) {

        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        if (filename.contains("..")) {
            throw new RuntimeException("Archivo incorrecto");
        }
        return filename;
    }

    private void comprobarExtension(String extension) {

        if (!TIPOS_PERMITIDOS.containsKey(extension)) {
            throw new RuntimeException("Formato no permitido. Utiliza JPG, JPEG, PNG o WebP");
        }
    }

    private void comprobarTipoContenido(MultipartFile file, String extension) {

        String tipoEsperado = TIPOS_PERMITIDOS.get(extension);
        String tipoRecibido = file.getContentType();

        if (tipoRecibido == null || !tipoEsperado.equalsIgnoreCase(tipoRecibido)) {
            throw new RuntimeException("El tipo de archivo no coincide con su extensión");
        }
    }

    private void comprobarContenidoImagen(MultipartFile file, String extension) {

        try (InputStream inputStream = file.getInputStream()) {
            if (extension.equals("webp")) {
                byte[] cabecera = inputStream.readNBytes(12);
                boolean esWebp = cabecera.length == 12 && cabecera[0] == 'R' && cabecera[1] == 'I' && cabecera[2] == 'F' && cabecera[3] == 'F' && cabecera[8] == 'W' && cabecera[9] == 'E' && cabecera[10] == 'B' && cabecera[11] == 'P';
                if (!esWebp) {
                    throw new RuntimeException("El contenido del archivo no es una imagen WebP válida");
                }
            } else {
                BufferedImage imagen = ImageIO.read(inputStream);
                if (imagen == null) {
                    throw new RuntimeException("El contenido del archivo no es una imagen válida");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("No se pudo comprobar el contenido de la imagen", e);
        }
    }

    @Override
    public Resource cargarArchivo(String filename) {

        try {
            Path file = rootLocation.resolve(filename).normalize();
            if (!file.startsWith(rootLocation)) {
                throw new RuntimeException("Ruta de archivo no válida");
            }
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() && resource.isReadable()) {
                return resource;
            }
            throw new RuntimeException("El archivo no existe o no se puede leer");
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar el archivo", e);
        }
    }
}