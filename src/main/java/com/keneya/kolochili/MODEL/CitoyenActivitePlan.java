package com.keneya.kolochili.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CitoyenActivitePlan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CitoyenActivitePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCitoyenActivitePlan")
    private int idCitoyenActivitePlan;

    @ManyToOne
    @JoinColumn(name = "idCitoyen", nullable = false)
    private Citoyen citoyen;

    @ManyToOne
    @JoinColumn(name = "idActivite", nullable = false)
    private Activite activite;

    @Column(nullable = false, length = 50)
    private String freqeunce;
}