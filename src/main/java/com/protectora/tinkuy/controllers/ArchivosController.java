package com.protectora.tinkuy.controllers;

import com.protectora.tinkuy.services.ArchivosServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class ArchivosController {

    private final ArchivosServiceImpl archivosServiceImpl;

    @GetMapping("/archivos/{filename:.+}")
    public ResponseEntity<Resource> servirArchivo(@PathVariable String filename) {

        try {
            Resource file = archivosServiceImpl.cargarArchivo(filename);
            return ResponseEntity.ok().body(file);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
