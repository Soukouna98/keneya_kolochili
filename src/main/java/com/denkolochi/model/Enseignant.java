package com.denkolochi.model;

import com.denkolochi.enumeration.RoleEnum;

public class Enseignant extends Utilisateur {
	public Enseignant(int id, String nom, String prenom, String tel, String mail, String password, RoleEnum role) {
		super(id, nom, prenom, tel, mail, password, role);
	}

}
