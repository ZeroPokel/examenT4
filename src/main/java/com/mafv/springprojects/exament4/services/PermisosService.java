package com.mafv.springprojects.exament4.services;


import com.mafv.springprojects.exament4.model.Permiso;

public interface PermisosService {
    
    public Iterable<Permiso> findAll();
    public Permiso findByID(int codigo);
    public void insert(Permiso permiso);
    public void update(Permiso permiso);
    public void delete(int codigo);
}
