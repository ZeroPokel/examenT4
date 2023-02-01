package com.mafv.springprojects.exament4.services.impl;

import org.springframework.stereotype.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mafv.springprojects.exament4.model.Usuario;
import com.mafv.springprojects.exament4.repository.UsuarioRepository;
import com.mafv.springprojects.exament4.services.UsuariosService;



@Service
public class UsuariosServiceImpl implements UsuariosService{
    @Autowired
    UsuarioRepository repository;

    @Override
    public Iterable<Usuario> findAll() {
        return repository.findAll();
    }

    @Override
    public Usuario findByID(int codigo) {
        Optional<Usuario> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public void insert(Usuario usuario) {
        repository.save(usuario);
        
    }

    @Override
    public void update(Usuario usuario) {
        repository.save(usuario);
        
    }

    @Override
    public void delete(int codigo) {
        repository.deleteById(codigo);
        
    }
}
