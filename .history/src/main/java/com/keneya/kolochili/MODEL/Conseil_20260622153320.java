package com.keneya.kolochili.MODEL;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import com.keneya.kolochili.Enumeration.TypeConseils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Conseils")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Conseil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idConseils")
    private Integer idConseils;

    @ManyToOne
    @JoinColumn(name = "idCategorieConseil", nullable = false)
    private CategorieConseil categorieConseil;

    @ManyToOne
    @JoinColumn(name = "idAgent", nullable = false)
    private Agent agent;

    @Column(nullable = false, length = 30)
    private String titre;

    @Enumerated(EnumType.STRING)
    private TypeConseils tag;

    @Column(nullable = false)
    private String contenu;
    @CreationTimestamp
    private LocalDate dateConseil;
    
    private boolean archive;
}