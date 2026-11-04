package com.protectora.tinkuy.controllers;

import com.protectora.tinkuy.services.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/animal")
@Controller
public class AnimalController {

    private final AnimalService animalService;

    private String rutaVista = "animales/";

//    @GetMapping("/")
//    public String listarAnimalesBase(Model model) {
//
//        List<Animal> animales = animalService.obtenerTodos();
//        model.addAttribute("animales", animales);
//
//        return rutaVista + "animalBaseListaView";
//    }
//
//    @GetMapping("/{id}")
//    public String mostrarAnimalBase(@PathVariable Long id, Model model) {
//
//        Animal animal = animalService.obtenerPorId(id);
//        List<ImagenAnimal> imagenes = animalService.obtenerImagenesPorAnimalId(id);
//
//        model.addAttribute("animal", animal);
//        model.addAttribute("imagenes", imagenes);
//
//        return rutaVista + "animalDetalleAdminView";
//    }
}