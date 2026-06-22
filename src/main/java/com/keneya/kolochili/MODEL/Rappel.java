package com.keneya.kolochili.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Rappels")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rappel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRappels")
    private int idRappels;

    @ManyToOne
    @JoinColumn(name = "idCitoyen", nullable = false)
    private Citoyen citoyen;

    @Column(name = "nom_medicament", length = 50)
    private String nomMedicament;

    private boolean repetition = false;

    @Column(name = "date_rappel")
    private LocalDateTime dateRappel;

    @Column(name = "INTERVALLE")
    private Integer intervalle;
}