package com.keneya.kolochili.MODEL;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "utilisateur")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(nullable = false, length = 50)
    protected String nom;
    @Column(nullable = false, length = 50)
    protected String prenom;
    @Column(nullable = false, length = 50, unique = true)
    protected String email;
    @Column(nullable = false, length = 50)
    protected String mdp;
    @Column(nullable = false, length = 12)
    protected String phone;

    @CreationTimestamp
    @Column(nullable=false,name="date_creation")
    private LocalDateTime dateCreation;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    protected Role role;
    protected boolean archive;
}
