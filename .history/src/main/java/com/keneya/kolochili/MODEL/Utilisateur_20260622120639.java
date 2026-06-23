package com.keneya.kolochili.MODEL;

import com.keneya.kolochili.Enumeration.TypeRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "utilisateur")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy=InheritanceType.JOINED)
public class Utilisateur {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false ,length = 50)
    private String nom;
     @Column(nullable = false ,length = 50)
    private String prenom;
     @Column(nullable = false ,length = 50, unique = true)
    private String email;
     @Column(nullable = false ,length = 50)
    private String mdp;
     @Column(nullable = false ,length = 12)
    private String phone;
    @Enumerated(EnumType.STRING)
    private TypeRole role;
    private boolean archive;
}