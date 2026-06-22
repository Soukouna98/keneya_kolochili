package com.keneya.kolochili.MODEL;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rappels")
public class Rappels {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRappels ;
    @Column()
    private int idCitoyen;
    private String nomCommande;
    private boolean repetition ;
    private Date dateRappel;
    private int INTERVALLE;

}
