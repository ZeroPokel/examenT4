package com.mafv.springprojects.exament4.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mafv.springprojects.exament4.model.Grupo;
import com.mafv.springprojects.exament4.repository.GrupoRepository;
import com.mafv.springprojects.exament4.services.GruposService;

@Service
public class GruposServiceImpl implements GruposService{

    @Autowired
    GrupoRepository repository;

    @Override
    public Grupo findByID(int codigo) {
        Optional<Grupo> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public void insert(Grupo permiso) {
        repository.save(permiso);
        
    }

    @Override
    public void update(Grupo permiso) {
        repository.save(permiso);
        
    }

    @Override
    public void delete(int codigo) {
        repository.deleteById(codigo);
        
    }
    
}