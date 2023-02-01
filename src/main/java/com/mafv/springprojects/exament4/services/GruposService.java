package com.mafv.springprojects.exament4.services;

import com.mafv.springprojects.exament4.model.Grupo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GruposService {

    public Page<Grupo> findAll(Pageable page);
    public Grupo findByID(int codigo);
    public void insert(Grupo grupo);
    public void update(Grupo grupo);
    public void delete(int codigo);
}
