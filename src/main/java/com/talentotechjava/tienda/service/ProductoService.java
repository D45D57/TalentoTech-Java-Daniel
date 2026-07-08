package com.talentotechjava.tienda.service;

import com.talentotechjava.tienda.exception.ResourceNotFoundException;
import com.talentotechjava.tienda.model.Producto;
import com.talentotechjava.tienda.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Producto guardar(Producto producto) {
        if (producto.getEtiquetas() != null && producto.getEtiquetas().size() > 3) {
            throw new IllegalArgumentException("Regla de negocio: Un producto no puede tener más de 3 etiquetas.");
        }
        
        return productoRepository.save(producto);
    }

    public Producto obtenerPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con el ID: " + id));
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }

    public List<Producto> obtenerPorCategoria(Long categoriaId) {
        return productoRepository.findByCategoriaId(categoriaId);
    }
}