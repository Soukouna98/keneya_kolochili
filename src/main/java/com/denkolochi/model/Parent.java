package com.denkolochi.model;

import com.denkolochi.enumeration.RoleEnum;

public class Parent extends Utilisateur {
	private int id_parent;
	private String genre;

	public Parent(String genre, int id_parent) {
		this.genre = genre;
		this.id_parent = id_parent;
	}

	public Parent(String genre, int id_parent, int id, String nom, String prenom, String tel, String mail,
			String motDePasse, RoleEnum role) {
		super(id, nom, prenom, tel, mail, motDePasse, role);
		this.genre = genre;
		this.id_parent = id_parent;
	}

	public Parent() {
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void sinscrir() {

	}

	public void creerProfilEnfant() {

	}

	public void consulterProfilEnfant() {

	}

	public void modifierProfilEnfant() {

	}

	public void supprimerProfilEnfant() {

	}

	public void voirRecommandation() {

	}

	public void consulterConseil() {

	}

	public void ajouterDonneesCorporelles() {

	}

	public void voirHistoriqueEnfant() {

	}

	public void voirSuggestionPedagogique() {

	}

	public int getId_parent() {
		return id_parent;
	}

	public void setId_parent(int id_parent) {
		this.id_parent = id_parent;
	}
}
