package com.home.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.home.demo.dto.VentaDto;
import com.home.demo.service.VentaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    // Crear una nueva venta
    @PostMapping("/create")
    public ResponseEntity<VentaDto> create(@RequestBody VentaDto ventaDto) {
        VentaDto createdVenta = ventaService.save(ventaDto);
        return new ResponseEntity<>(createdVenta, HttpStatus.CREATED);
    }

    // Obtener todas las ventas
    @GetMapping("/all")
    public ResponseEntity<List<VentaDto>> getAllVentas() {
        List<VentaDto> ventasDto = ventaService.findAll();
        return new ResponseEntity<>(ventasDto, HttpStatus.OK);
    }

    // Obtener una venta por ID
    @GetMapping("/{id}")
    public ResponseEntity<VentaDto> getVentaById(@PathVariable int id) {
        Optional<VentaDto> ventaDtoOptional = ventaService.findById(id);
        if (ventaDtoOptional.isPresent()) {
            return new ResponseEntity<>(ventaDtoOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar una venta por ID
    @PutMapping("/update/{id}")
    public ResponseEntity<VentaDto> updateVenta(@PathVariable int id, @RequestBody VentaDto ventaDto) {
        Optional<VentaDto> ventaDtoOptional = ventaService.findById(id);
        if (ventaDtoOptional.isPresent()) {
            ventaDto.setIdVenta(id);
            VentaDto updatedVenta = ventaService.save(ventaDto);
            return new ResponseEntity<>(updatedVenta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una venta por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable int id) {
        Optional<VentaDto> ventaDtoOptional = ventaService.findById(id);
        if (ventaDtoOptional.isPresent()) {
            ventaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
