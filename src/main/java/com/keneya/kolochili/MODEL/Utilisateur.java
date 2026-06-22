package com.keneya.kolochili.Model;

import com.keneya.kolochili.Enumeration.TypeRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Utilisateur")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUtilisateur")
    private int idUtilisateur;

    @Column(nullable = false, length = 50)
    private String nom;

    @Column(nullable = false, length = 50)
    private String prenom;

    @Column(length = 50, unique = true)
    private String email;

    @Column(nullable = false, length = 255)
    private String mdp;

    @Column(nullable = false, length = 12)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('CITOYEN','AGENT','ADMIN') DEFAULT 'CITOYEN'")
    private TypeRole role = TypeRole.CITOYEN;

    private boolean archive = false;
}