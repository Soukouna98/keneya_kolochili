package com.keneya.kolochili.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Agent")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAgent")
    private int idAgent;

    @OneToOne
    @JoinColumn(name = "idUtilsateur", nullable = false, unique = true)
    private Utilisateur utilisateur;

    @Column(nullable = false, length = 50)
    private String specialite;
}