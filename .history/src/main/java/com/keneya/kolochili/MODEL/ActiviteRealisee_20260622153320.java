package com.keneya.kolochili.MODEL;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "activiteRealisee")
public class ActiviteRealisee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActiviteRealisee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false,name = "idCitoyenActivitePlan")
    private CitoyenActivitePlan citoyenActivitePlan;

    @CreationTimestamp
    private LocalDateTime date;

    @Column(length = 50)
    private String frequence;

}