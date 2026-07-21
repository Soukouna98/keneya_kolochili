package com.keneya.kolochili.DTO.Request;

import java.time.LocalDateTime;

import com.keneya.kolochili.Enumeration.TypeFrequence;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RappelDTO {
	@NotBlank(message = "Le nom du medicament est obligatoire")
	private String nom_medicament;

	@NotNull(message = "La date de debut est obligatoire")
	private LocalDateTime dateDebut;

	@NotNull(message = "La date de fin est obligatoire")
	private LocalDateTime dateFin;

	@NotNull(message = "La frequence est obligatoire")
	private TypeFrequence frequence;

	@NotNull(message = "L'intervalle est obligatoire")
	private Integer intervalle;
}
