package com.mafv.springprojects.exament4.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mafv.springprojects.exament4.model.Permiso;

public interface PermisosService {
    
    public Page<Permiso> findAll(Pageable page);
    public Permiso findByID(int codigo);
    public void insert(Permiso permiso);
    public void update(Permiso permiso);
    public void delete(int codigo);
}
