package com.talentotechjava.tienda.controller;

import com.talentotechjava.tienda.model.Etiqueta;
import com.talentotechjava.tienda.repository.EtiquetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/etiquetas")
@CrossOrigin(origins = "*")
public class EtiquetaController {

    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @PostMapping
    public Etiqueta guardar(@RequestBody Etiqueta etiqueta) {
        return etiquetaRepository.save(etiqueta);
    }

    @GetMapping
    public List<Etiqueta> obtenerTodas() {
        return etiquetaRepository.findAll();
    }
}