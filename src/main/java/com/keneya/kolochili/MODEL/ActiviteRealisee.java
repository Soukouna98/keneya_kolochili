package com.keneya.kolochili.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ActiviteRealisee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActiviteRealisee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idActiviteRealisee")
    private int idActiviteRealisee;

    @ManyToOne
    @JoinColumn(name = "idCitoyenActivitePlan", nullable = false)
    private CitoyenActivitePlan citoyenActivitePlan;

    @Column(nullable = false, updatable = false)
    private LocalDateTime date;

    @Column(length = 50)
    private String freqeunce;

    @PrePersist
    protected void onCreate() {
        this.date = LocalDateTime.now();
    }
}