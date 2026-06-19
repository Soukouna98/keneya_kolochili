package com.denkolochi.model;

import com.denkolochi.enumeration.RoleEnum;

public class Admins extends Utilisateur {
	private int idAdmin;

	public Admins() {
		super();
	}

	public Admins(int id, String nom, String prenom, String tel, String mail, String mot_de_passe, RoleEnum role,
			int idAdmin) {
		super(id, nom, prenom, tel, mail, mot_de_passe, role);
		this.idAdmin = idAdmin;
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
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
