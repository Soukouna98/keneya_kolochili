package com.keneya.kolochili.MODEL;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

	@OneToMany(mappedBy = "citoyen")
	private List<Rappel> rappels;

    private LocalDateTime date_naissance;
}
