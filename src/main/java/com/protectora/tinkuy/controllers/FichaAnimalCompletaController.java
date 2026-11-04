package com.protectora.tinkuy.controllers;

import com.protectora.tinkuy.dto.AnimalesEstadisticasAdminDto;
import com.protectora.tinkuy.dto.AnimalesFiltrosAdminDto;
import com.protectora.tinkuy.dto.AnimalesListadoAdminDto;
import com.protectora.tinkuy.entities.FichaAnimalCompleta;
import com.protectora.tinkuy.entities.ImagenAnimal;
import com.protectora.tinkuy.enumerations.*;
import com.protectora.tinkuy.mappers.AnimalMapper;
import com.protectora.tinkuy.mappers.AnimalesFiltrosAdminMapper;
import com.protectora.tinkuy.models.AnimalesFiltrosAdmin;
import com.protectora.tinkuy.services.AnimalService;
import com.protectora.tinkuy.services.EspecieService;
import com.protectora.tinkuy.services.FichaAnimalCompletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/animales")
@Controller
public class FichaAnimalCompletaController {

    private final FichaAnimalCompletaService fichaAnimalCompletaService;
    private final AnimalService animalService;
    private final EspecieService especieService;

    private final AnimalMapper animalMapper;
    private final AnimalesFiltrosAdminMapper animalesFiltrosAdminMapper;

    private final String rutaVista = "animales/";

    @ModelAttribute
    public void cargarDatosComunes(Model model) {

        model.addAttribute("seccionActiva", "animales");

        model.addAttribute("situaciones", SituacionAnimalEnum.values());
        model.addAttribute("sexos", SexoAnimalEnum.values());
        model.addAttribute("tamanos", TamanoAnimalEnum.values());
        model.addAttribute("edades", CategoriaEdadEnum.values());

        model.addAttribute("especies", especieService.obtenerTodos());
        model.addAttribute("estados", EstadoAnimalEnum.values());

        model.addAttribute("estadisticas", new AnimalesEstadisticasAdminDto(
                fichaAnimalCompletaService.obtenerTotalAnimales(),
                fichaAnimalCompletaService.obtenerTotalUrgentes(),
                fichaAnimalCompletaService.obtenerTotalEnAdopcion(),
                fichaAnimalCompletaService.obtenerTotalAdoptados()
        ));
    }

    @GetMapping("/")
    public String showTablaAnimalAdminConFiltros(Model model) {

        AnimalesFiltrosAdminDto animalesFiltrosInicialesDto = new AnimalesFiltrosAdminDto();
        animalesFiltrosInicialesDto.setEstado("Activo");

        List<FichaAnimalCompleta> animalesConFichaFiltrados = obtenerAnimalesConFichaFiltrados(animalesFiltrosInicialesDto);

        cargarAnimalesConFichaConImagenEnTabla(model, animalesConFichaFiltrados, animalesFiltrosInicialesDto);

        return rutaVista + "animalListaAdminView";
    }

    @GetMapping("/sinfiltros")
    public String showTablaAnimalAdminSinFiltros(Model model) {

        List<FichaAnimalCompleta> animalesConFicha = fichaAnimalCompletaService.obtenerAnimalesConFicha();

        cargarAnimalesConFichaConImagenEnTabla(model, animalesConFicha, new AnimalesFiltrosAdminDto());

        return rutaVista + "animalListaAdminView";
    }

    @PostMapping("/filtros")
    public String procesarFiltros(AnimalesFiltrosAdminDto animalesFiltradosDto, Model model) {

        List<FichaAnimalCompleta> animalesConFichaFiltrados = obtenerAnimalesConFichaFiltrados(animalesFiltradosDto);

        cargarAnimalesConFichaConImagenEnTabla(model, animalesConFichaFiltrados, animalesFiltradosDto);

        return rutaVista + "animalListaAdminView";
    }

    @GetMapping("/{id}")
    public String showFichaAnimalCompleta(@PathVariable Long id, Model model) {

        FichaAnimalCompleta ficha = fichaAnimalCompletaService.obtenerPorId(id);

        String situacionActual = fichaAnimalCompletaService.obtenerSituacionAnimal(ficha);

        List<ImagenAnimal> imagenes = animalService.obtenerImagenesPorAnimalId(ficha.getAnimal().getId());

        model.addAttribute("ficha", ficha);
        model.addAttribute("situacionActual", situacionActual);
        model.addAttribute("imagenes", imagenes);

        return rutaVista + "animalDetalleAdminView";
    }

    private void cargarAnimalesConFichaConImagenEnTabla(Model model, List<FichaAnimalCompleta> animalesConFicha, AnimalesFiltrosAdminDto filtrosDto) {

        List<Long> animalesIds = new ArrayList<>();
        Map<Long, String> situacionesPorAnimal = new HashMap<>();

        if (animalesConFicha != null) {
            for (FichaAnimalCompleta ficha : animalesConFicha) {

                if (ficha != null && ficha.getAnimal() != null && ficha.getAnimal().getId() != null) {

                    Long animalId = ficha.getAnimal().getId();
                    animalesIds.add(animalId);

                    String situacion = fichaAnimalCompletaService.obtenerSituacionAnimal(ficha);

                    situacionesPorAnimal.put(animalId, situacion);
                }
            }
        }

        List<ImagenAnimal> imagenesAnimal = animalService.obtenerImagenesPrincipalesPorAnimalIds(animalesIds);

        List<AnimalesListadoAdminDto> animalesTablaDto = animalMapper.toListadoDtoList(animalesConFicha, imagenesAnimal, situacionesPorAnimal);

        model.addAttribute("animalesTablaDto", animalesTablaDto);
        model.addAttribute("animalesFiltroDto", filtrosDto);
    }

    private List<FichaAnimalCompleta> obtenerAnimalesConFichaFiltrados(AnimalesFiltrosAdminDto filtrosDto) {

        AnimalesFiltrosAdmin filtros = animalesFiltrosAdminMapper.toModel(filtrosDto);

        return fichaAnimalCompletaService.obtenerResultFiltros(filtros);
    }
}