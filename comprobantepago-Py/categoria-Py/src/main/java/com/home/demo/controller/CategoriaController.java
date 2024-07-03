package com.home.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.home.demo.dto.CategoriaDto;
import com.home.demo.entity.CategoriaEntity;
import com.home.demo.service.CategoriaService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Crear una nueva categoría
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CategoriaDto categoriaDto) {
        CategoriaEntity categoria = new CategoriaEntity();
        categoria.setNombreCategoria(categoriaDto.getNombreCategoria());
        categoria.setDetalle_categoria(categoriaDto.getDetalleCategoria());

        categoriaService.save(categoria);
        return new ResponseEntity<>("Categoría creada exitosamente", HttpStatus.CREATED);
    }

    // Obtener todas las categorías
    @GetMapping("/all")
    public ResponseEntity<List<CategoriaDto>> getAllCategorias() {
        List<CategoriaEntity> categorias = categoriaService.findAll();
        List<CategoriaDto> categoriasDto = categorias.stream()
            .map(categoria -> new CategoriaDto(
                categoria.getIdCategoria(),
                categoria.getNombreCategoria(),
                categoria.getDetalle_categoria()))
            .collect(Collectors.toList());
        return new ResponseEntity<>(categoriasDto, HttpStatus.OK);
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoriaById(@PathVariable int id) {
        Optional<CategoriaEntity> categoriaOptional = categoriaService.findById(id);
        if (categoriaOptional.isPresent()) {
            CategoriaEntity categoria = categoriaOptional.get();
            CategoriaDto categoriaDto = new CategoriaDto(
                categoria.getIdCategoria(),
                categoria.getNombreCategoria(),
                categoria.getDetalle_categoria());
            return new ResponseEntity<>(categoriaDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Categoría no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar una categoría por ID
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategoria(@PathVariable int id, @RequestBody CategoriaDto categoriaDto) {
        Optional<CategoriaEntity> categoriaOptional = categoriaService.findById(id);
        if (categoriaOptional.isPresent()) {
            CategoriaEntity categoria = categoriaOptional.get();
            categoria.setNombreCategoria(categoriaDto.getNombreCategoria());
            categoria.setDetalle_categoria(categoriaDto.getDetalleCategoria());

            categoriaService.save(categoria);
            return new ResponseEntity<>("Categoría actualizada exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Categoría no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una categoría por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategoria(@PathVariable int id) {
        Optional<CategoriaEntity> categoriaOptional = categoriaService.findById(id);
        if (categoriaOptional.isPresent()) {
            categoriaService.deleteById(id);
            return new ResponseEntity<>("Categoría eliminada exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Categoría no encontrada", HttpStatus.NOT_FOUND);
        }
    }
}
