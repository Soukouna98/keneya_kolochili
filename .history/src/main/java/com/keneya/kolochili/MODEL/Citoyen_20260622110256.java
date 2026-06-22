package com.keneya.kolochili.MODEL;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "citoyens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Citoyen extends Utilisateur{

    private LocalDateTime date_naissance;
}
