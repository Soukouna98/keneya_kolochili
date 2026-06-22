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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "publications")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id", nullable = false)
    private Agent agent;
    @Column(name = "maladie", nullable = false, length = 100)
    private String nom_maladie;
    @Column(name = "symptome", nullable = false, columnDefinition = "Text")
    private String symptome;
    @Column(name = "conseil_preventif", nullable = false, columnDefinition = "Text")
    private String conseilPreventif;
    @CreationTimestamp
    @Column(name = "date", nullable = false)
    private LocalDateTime dateCreation;
    @Column(nullable = false)
    private String sources;
    private boolean archive;
}
