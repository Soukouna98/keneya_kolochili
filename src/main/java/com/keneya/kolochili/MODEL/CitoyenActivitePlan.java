package com.keneya.kolochili.MODEL;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    private Long idCitoyenActivitePlan;

    @ManyToOne
    @JoinColumn(name = "idCitoyen", nullable = false)
    private Citoyen citoyen;

    @ManyToOne
    @JoinColumn(name = "idActivite", nullable = false)
    private Activites activite;

    @OneToMany(
        mappedBy = "citoyenActivitePlan",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
        private List<PlanningActivite> plannings;
}