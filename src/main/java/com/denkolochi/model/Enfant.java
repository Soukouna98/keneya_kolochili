package com.denkolochi.model;

import java.time.LocalDate;

public class Enfant {

	private int id;
	private String nom;
	private String prenom;
	private LocalDate date_naissance;
	private String sexe;
	private int id_parent;

	public Enfant(int id, String nom, String prenom, LocalDate date_naissance, String sexe, int id_parent) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
		this.sexe = sexe;
		this.id_parent = id_parent;
	}

	public Enfant() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(LocalDate date_naissance2) {
		this.date_naissance = date_naissance2;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public int getid_parent() {
		return id_parent;
	}

	public void setParent(int id_parent) {
		this.id_parent = id_parent;

	}

}
