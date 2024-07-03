package com.home.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.demo.dto.VentaDto;
import com.home.demo.entity.VentaEntity;
import com.home.demo.repository.VentaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public VentaDto save(VentaDto ventaDto) {
        VentaEntity ventaEntity = convertToEntity(ventaDto);
        VentaEntity savedVenta = ventaRepository.save(ventaEntity);
        return convertToDto(savedVenta);
    }

    public List<VentaDto> findAll() {
        return ventaRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public Optional<VentaDto> findById(int id) {
        Optional<VentaEntity> ventaEntity = ventaRepository.findById(id);
        return ventaEntity.map(this::convertToDto);
    }

    public void deleteById(int id) {
        ventaRepository.deleteById(id);
    }

    private VentaDto convertToDto(VentaEntity ventaEntity) {
        return new VentaDto(
                ventaEntity.getIdVenta(),
                ventaEntity.getFechaVenta(),
                ventaEntity.getTotalVenta()
        );
    }

    private VentaEntity convertToEntity(VentaDto ventaDto) {
        VentaEntity ventaEntity = new VentaEntity();
        ventaEntity.setIdVenta(ventaDto.getIdVenta());
        ventaEntity.setFechaVenta(ventaDto.getFechaVenta());
        ventaEntity.setTotalVenta(ventaDto.getTotalVenta());
        return ventaEntity;
    }
}
