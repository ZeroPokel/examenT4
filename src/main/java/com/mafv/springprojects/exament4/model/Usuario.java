package com.mafv.springprojects.exament4.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {
    
    @Id
    @GeneratedValue
    private int codigo;

    @Column(unique = true)
    private String nombre;

    @Column(unique = true)
    private String email;
}
