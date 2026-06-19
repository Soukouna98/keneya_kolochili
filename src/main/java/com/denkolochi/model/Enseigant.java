package com.denkolochi.model;

import com.denkolochi.enumeration.RoleEnum;

public class Enseigant extends Utilisateur {

	public Enseigant(int id, String nom, String prenom, String tel, String mail, String password, RoleEnum role) {
		super(id, nom, prenom, tel, mail, password, role);
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
