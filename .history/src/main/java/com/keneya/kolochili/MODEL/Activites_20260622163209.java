package com.keneya.kolochili.MODEL;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;

import com.keneya.kolochili.Enumeration.TypeNiveau;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="activites")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Activites{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActivites;
    
    @ManyToOne
    @JoinColumn(name = "idAgent", nullable = false)
    private Agent agent;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCategorieActivite", nullable = false)
    private CategorieActivite categorieActivite;


    @Column(nullable = false )
    private LocalDateTime date;
   
   
    @Column(nullable = false ,length = 50)
    private String nom;

    @Enumerated(EnumType.STRING)
    private TypeNiveau niveau;

    @Column(nullable = false)
    private LocalTime duree;

    @Column(nullable = false ,length = 50)
    private String description;  

}
