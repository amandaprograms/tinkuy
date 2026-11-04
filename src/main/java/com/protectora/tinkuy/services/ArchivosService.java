package com.protectora.tinkuy.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ArchivosService {

    String almacenarArchivo(MultipartFile file, Long id);

    void comprobarArchivoExiste(MultipartFile file);

    String comprobarArchivoCorrecto(MultipartFile file);

    Resource cargarArchivo(String filename);


}
