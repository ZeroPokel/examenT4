package com.mafv.springprojects.exament4.services;

import com.mafv.springprojects.exament4.model.Usuario;

public interface UsuariosService {

    public Iterable<Usuario> findAll();
    public Usuario findByID(int codigo);
    public void insert(Usuario usuario);
    public void update(Usuario usuario);
    public void delete(int codigo);
}
