package com.mafv.springprojects.exament4.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mafv.springprojects.exament4.model.Usuario;

public interface UsuariosService {

    public Page<Usuario> findAll(Pageable page);
    public Usuario findByID(int codigo);
    public void insert(Usuario usuario);
    public void update(Usuario usuario);
    public void delete(int codigo);
}
