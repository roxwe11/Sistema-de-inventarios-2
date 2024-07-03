package com.home.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.home.demo.entity.CategoriaEntity;
import com.home.demo.repository.CategoriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void save(CategoriaEntity categoria) {
        categoriaRepository.save(categoria);
    }

    public List<CategoriaEntity> findAll() {
        return categoriaRepository.findAll();
    }

    public Optional<CategoriaEntity> findById(int id) {
        return categoriaRepository.findById(id);
    }

    public void deleteById(int id) {
        categoriaRepository.deleteById(id);
    }
}
