package com.denkolochi.model;

import com.denkolochi.enumeration.RoleEnum;

public class Specialiste extends Utilisateur {
	private String specialite;

	public Specialiste(int id, String nom, String prenom, String tel, String mail, String password, RoleEnum role,
			String specialite) {
		super(id, nom, prenom, tel, mail, password, role);
		this.specialite = specialite;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public void creerUtilisateur(Utilisateur moh) {
		//
	}

	public void modifierUtilisateur(Utilisateur utilisateur) {

	}

	public void seConnecter(String mail, String password) {

	}

	public void seDeconnecter() {

	}
}
