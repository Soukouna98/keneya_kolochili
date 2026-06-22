package com.keneya.kolochili.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CategorieConseils")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategorieConseil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategorieConseil")
    private int idCategorieConseil;

    @Column(nullable = false, length = 50)
    private String nom;

    @Column(columnDefinition = "TEXT")
    private String description;
}