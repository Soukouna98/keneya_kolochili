package com.keneya.kolochili.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Admin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAdmin")
    private int idAdmin;

    @OneToOne
    @JoinColumn(name = "idUtilsateur", nullable = false, unique = true)
    private Utilisateur utilisateur;
}