package com.home.demo.service;

import com.home.demo.dto.ProductoDto;
import com.home.demo.dto.CategoriaDto;
import com.home.demo.dto.TipoDto;
import com.home.demo.dto.UbicacionDto;
import com.home.demo.entity.CategoriaEntity;
import com.home.demo.entity.ProductoEntity;
import com.home.demo.entity.TipoEntity;
import com.home.demo.entity.UbicacionEntity;
import com.home.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<ProductoDto> getAllProductos() {
        return productoRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public ProductoDto getProductoById(int id) {
        return productoRepository.findById(id).map(this::convertToDto).orElse(null);
    }

    public ProductoDto createProducto(ProductoDto dto) {
        ProductoEntity producto = convertToEntity(dto);
        ProductoEntity savedProducto = productoRepository.save(producto);
        return convertToDto(savedProducto);
    }

    public ProductoDto updateProducto(int id, ProductoDto dto) {
        if (productoRepository.existsById(id)) {
            ProductoEntity producto = convertToEntity(dto);
            producto.setIdProducto(id);
            ProductoEntity updatedProducto = productoRepository.save(producto);
            return convertToDto(updatedProducto);
        } else {
            return null;
        }
    }

    public boolean deleteProducto(int id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private ProductoDto convertToDto(ProductoEntity producto) {
        ProductoDto dto = new ProductoDto();
        dto.setIdProducto(producto.getIdProducto());
        dto.setNombreProducto(producto.getNombreProducto());
        dto.setPrecioCompra(producto.getPrecioCompra());
        dto.setPrecioVenta(producto.getPrecioVenta());
        dto.setStock(producto.getStock());
        dto.setFechaVencimiento(producto.getFechaVencimiento());

        if (producto.getCategoriaEntity() != null) {
            CategoriaDto categoriaDto = new CategoriaDto();
            categoriaDto.setIdCategoria(producto.getCategoriaEntity().getIdCategoria());
            categoriaDto.setNombreCategoria(producto.getCategoriaEntity().getNombreCategoria());
            categoriaDto.setDetalleCategoria(producto.getCategoriaEntity().getDetalleCategoria());
            dto.setCategoria(categoriaDto);
        }

        if (producto.getTipoEntity() != null) {
            TipoDto tipoDto = new TipoDto();
            tipoDto.setIdTipo(producto.getTipoEntity().getIdTipo());
            tipoDto.setNombreTipo(producto.getTipoEntity().getNombreTipo());
            tipoDto.setDetalleTipo(producto.getTipoEntity().getDetalleTipo());
            dto.setTipo(tipoDto);
        }

        if (producto.getUbicacionEntity() != null) {
            UbicacionDto ubicacionDto = new UbicacionDto();
            ubicacionDto.setIdUbicacion(producto.getUbicacionEntity().getIdUbicacion());
            ubicacionDto.setNombreUbicacion(producto.getUbicacionEntity().getNombreUbicacion());
            dto.setUbicacion(ubicacionDto);
        }

        return dto;
    }

    private ProductoEntity convertToEntity(ProductoDto dto) {
        ProductoEntity producto = new ProductoEntity();
        producto.setIdProducto(dto.getIdProducto());
        producto.setNombreProducto(dto.getNombreProducto());
        producto.setPrecioCompra(dto.getPrecioCompra());
        producto.setPrecioVenta(dto.getPrecioVenta());
        producto.setStock(dto.getStock());
        producto.setFechaVencimiento(dto.getFechaVencimiento());

        if (dto.getCategoria() != null) {
            CategoriaEntity categoria = new CategoriaEntity();
            categoria.setIdCategoria(dto.getCategoria().getIdCategoria());
            categoria.setNombreCategoria(dto.getCategoria().getNombreCategoria());
            categoria.setDetalleCategoria(dto.getCategoria().getDetalleCategoria());
            producto.setCategoriaEntity(categoria);
        }

        if (dto.getTipo() != null) {
            TipoEntity tipo = new TipoEntity();
            tipo.setIdTipo(dto.getTipo().getIdTipo());
            tipo.setNombreTipo(dto.getTipo().getNombreTipo());
            tipo.setDetalleTipo(dto.getTipo().getDetalleTipo());
            producto.setTipoEntity(tipo);
        }

        if (dto.getUbicacion() != null) {
            UbicacionEntity ubicacion = new UbicacionEntity();
            ubicacion.setIdUbicacion(dto.getUbicacion().getIdUbicacion());
            ubicacion.setNombreUbicacion(dto.getUbicacion().getNombreUbicacion());
            producto.setUbicacionEntity(ubicacion);
        }

        return producto;
    }
}
