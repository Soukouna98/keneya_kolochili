package com.keneya.kolochili.MODEL;


import java.time.LocalDateTime;

import com.keneya.kolochili.Enumeration.TypeFrequence;

import jakarta.persistence.*;
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
	@Column( nullable = false )
	private boolean terminer ;
	@ManyToOne
	@JoinColumn(name = "id_citoyen", nullable = false)
	private Citoyen citoyen;

}
