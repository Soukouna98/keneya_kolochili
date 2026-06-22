package com.keneya.kolochili.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Citoyen")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Citoyen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCitoyen")
    private int idCitoyen;

    @OneToOne
    @JoinColumn(name = "idUtilsateur", nullable = false, unique = true)
    private Utilisateur utilisateur;

    @Column(name = "date_naissance", nullable = false)
    private LocalDate dateNaissance;
}