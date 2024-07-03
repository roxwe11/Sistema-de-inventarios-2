package com.home.demo.controller;

import com.home.demo.dto.ComprobantePagoDto;
import com.home.demo.service.ComprobantePagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comprobantes")
public class ComprobantePagoController {

    @Autowired
    private ComprobantePagoService comprobantePagoService;

    // Crear un nuevo comprobante de pago
    @PostMapping("/create")
    public ResponseEntity<ComprobantePagoDto> create(@RequestBody ComprobantePagoDto comprobantePagoDto) {
        ComprobantePagoDto createdComprobante = comprobantePagoService.save(comprobantePagoDto);
        return new ResponseEntity<>(createdComprobante, HttpStatus.CREATED);
    }

    // Obtener todos los comprobantes de pago
    @GetMapping("/all")
    public ResponseEntity<List<ComprobantePagoDto>> getAllComprobantes() {
        List<ComprobantePagoDto> comprobantes = comprobantePagoService.findAll();
        return new ResponseEntity<>(comprobantes, HttpStatus.OK);
    }

    // Obtener un comprobante de pago por ID
    @GetMapping("/{id}")
    public ResponseEntity<ComprobantePagoDto> getComprobanteById(@PathVariable int id) {
        Optional<ComprobantePagoDto> comprobanteOptional = comprobantePagoService.findById(id);
        return comprobanteOptional.map(comprobante -> new ResponseEntity<>(comprobante, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Actualizar un comprobante de pago por ID
    @PutMapping("/update/{id}")
    public ResponseEntity<ComprobantePagoDto> updateComprobante(@PathVariable int id,
            @RequestBody ComprobantePagoDto comprobantePagoDto) {
        Optional<ComprobantePagoDto> comprobanteOptional = comprobantePagoService.findById(id);
        if (comprobanteOptional.isPresent()) {
            ComprobantePagoDto existingComprobante = comprobanteOptional.get();
            existingComprobante.setFechaComprobantePago(comprobantePagoDto.getFechaComprobantePago());
            existingComprobante.setNombreComprobante(comprobantePagoDto.getNombreComprobante());
            existingComprobante.setOpGravada(comprobantePagoDto.getOpGravada());
            existingComprobante.setIgv(comprobantePagoDto.getIgv());
            ComprobantePagoDto updatedComprobante = comprobantePagoService.save(existingComprobante);
            return new ResponseEntity<>(updatedComprobante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un comprobante de pago por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteComprobante(@PathVariable int id) {
        Optional<ComprobantePagoDto> comprobanteOptional = comprobantePagoService.findById(id);
        if (comprobanteOptional.isPresent()) {
            comprobantePagoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
