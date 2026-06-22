package com.keneya.kolochili.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Publication")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPublication")
    private int idPublication;

    @ManyToOne
    @JoinColumn(name = "idAgent", nullable = false)
    private Agent agent;

    @Column(name = "nom_maladie", nullable = false, length = 100)
    private String nomMaladie;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String symptome;

    @Column(name = "conseil_preventif", nullable = false, columnDefinition = "TEXT")
    private String conseilPreventif;

    @Column(name = "date_creation", nullable = false, updatable = false)
    private LocalDateTime dateCreation;

    @Column(nullable = false, length = 255)
    private String sources;

    @PrePersist
    protected void onCreate() {
        this.dateCreation = LocalDateTime.now();
    }
}