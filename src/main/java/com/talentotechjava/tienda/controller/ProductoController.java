package com.talentotechjava.tienda.controller;

import com.talentotechjava.tienda.model.Producto;
import com.talentotechjava.tienda.service.ProductoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/productos")

@CrossOrigin(origins = "*")

public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> obtenerTodos() {
        return productoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable Long id) {
        Producto producto = productoService.obtenerPorId(id);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public Producto guardar(@Valid @RequestBody Producto producto) {
        return productoService.guardar(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id, @RequestBody Producto productoDetalles) {
        Producto productoExistente = productoService.obtenerPorId(id);
        
        if (productoExistente == null) {
            return ResponseEntity.notFound().build();
        }

        productoExistente.setNombre(productoDetalles.getNombre());
        productoExistente.setPrecio(productoDetalles.getPrecio());
        productoExistente.setStock(productoDetalles.getStock());

        Producto productoActualizado = productoService.guardar(productoExistente);
        return ResponseEntity.ok(productoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Producto producto = productoService.obtenerPorId(id);
        
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }

        productoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/categoria/{categoriaId}")
    public List<Producto> obtenerProductosPorCategoria(@PathVariable Long categoriaId) {
        return productoService.obtenerPorCategoria(categoriaId);
    }
}