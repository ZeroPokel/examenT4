package com.mafv.springprojects.exament4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mafv.springprojects.exament4.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
