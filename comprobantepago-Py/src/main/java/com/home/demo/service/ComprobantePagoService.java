package com.home.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.home.demo.entity.ComprobantePagoEntity;
import com.home.demo.dto.ComprobantePagoDto;
import com.home.demo.repository.ComprobantePagoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComprobantePagoService {

    @Autowired
    private ComprobantePagoRepository comprobantePagoRepository;

    public ComprobantePagoDto save(ComprobantePagoDto comprobantePagoDto) {
        ComprobantePagoEntity entity = new ComprobantePagoEntity();
        entity.setFechaComprobantePago(comprobantePagoDto.getFechaComprobantePago());
        entity.setNombre_comprobante(comprobantePagoDto.getNombreComprobante());
        entity.setOp_gravada(comprobantePagoDto.getOpGravada());
        entity.setIgv(comprobantePagoDto.getIgv());
        ComprobantePagoEntity savedEntity = comprobantePagoRepository.save(entity);
        return new ComprobantePagoDto(savedEntity.getIdComprobantePago(), savedEntity.getFechaComprobantePago(),
                savedEntity.getNombre_comprobante(), savedEntity.getOp_gravada(), savedEntity.getIgv());
    }

    public List<ComprobantePagoDto> findAll() {
        return comprobantePagoRepository.findAll().stream()
                .map(entity -> new ComprobantePagoDto(entity.getIdComprobantePago(), entity.getFechaComprobantePago(),
                        entity.getNombre_comprobante(), entity.getOp_gravada(), entity.getIgv()))
                .collect(Collectors.toList());
    }

    public Optional<ComprobantePagoDto> findById(int id) {
        Optional<ComprobantePagoEntity> entityOptional = comprobantePagoRepository.findById(id);
        return entityOptional.map(entity -> new ComprobantePagoDto(entity.getIdComprobantePago(),
                entity.getFechaComprobantePago(), entity.getNombre_comprobante(), entity.getOp_gravada(),
                entity.getIgv()));
    }

    public void deleteById(int id) {
        comprobantePagoRepository.deleteById(id);
    }
}
