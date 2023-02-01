package com.mafv.springprojects.exament4.services;

import com.mafv.springprojects.exament4.model.Grupo;

public interface GruposService {
    
    public Grupo findByID(int codigo);
    public void insert(Grupo grupo);
    public void update(Grupo grupo);
    public void delete(int codigo);
}
