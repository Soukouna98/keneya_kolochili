package com.keneya.kolochili.Model;

import com.keneya.kolochili.Enumeration.NiveauActivite;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Activites")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Activite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idActivites")
    private int idActivites;

    @ManyToOne
    @JoinColumn(name = "idAgent", nullable = false)
    private Agent agent;


    @Column(name = "date_time", nullable = false, updatable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false, length = 50)
    private String nom;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('DEBUTANT','INTERMEDIAIRE','AVANCER')")
    private NiveauActivite niveau;

    @Column(nullable = false)
    private int duree;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @PrePersist
    protected void onCreate() {
        this.dateTime = LocalDateTime.now();
    }
}