package com.mafv.springprojects.exament4.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mafv.springprojects.exament4.model.Permiso;
import com.mafv.springprojects.exament4.repository.PermisoRepository;
import com.mafv.springprojects.exament4.services.PermisosService;

@Service
public class PermisosServiceImpl implements PermisosService{


    @Autowired
    PermisoRepository repository;

    @Override
    public Permiso findByID(int codigo) {
        Optional<Permiso> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public void insert(Permiso permiso) {
        repository.save(permiso);
        
    }

    @Override
    public void update(Permiso permiso) {
        repository.save(permiso);
        
    }

    @Override
    public void delete(int codigo) {
        repository.deleteById(codigo);
        
    }
    
}
