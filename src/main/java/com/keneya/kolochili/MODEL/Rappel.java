package com.keneya.kolochili.MODEL;


import java.time.LocalDateTime;

import com.keneya.kolochili.Enumeration.TypeFrequence;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "rappels")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Rappel{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nom_medicament ;

	private LocalDateTime dateDebut;
	private LocalDateTime dateFin;
	private LocalDateTime dateRappel;
	private LocalDateTime dateCreation;
	private boolean archive;
	@Enumerated(EnumType.STRING)
	private TypeFrequence frequence;
	private int intervalle;

	@ManyToOne
	@JoinColumn(name = "id_citoyen", nullable = false)
	private Citoyen citoyen;

}
