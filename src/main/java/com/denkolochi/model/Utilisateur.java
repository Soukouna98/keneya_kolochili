package com.denkolochi.model;

import com.denkolochi.enumeration.RoleEnum;

public class Utilisateur {

	// attributs
	protected int id;
	protected String nom;
	protected String prenom;
	protected String tel;
	protected String mail;
	protected String motDePasse;
	protected RoleEnum role;

	// constructeur
	public Utilisateur(int id, String nom, String prenom, String tel, String mail, String motDePasse, RoleEnum role) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.mail = mail;
		this.motDePasse = motDePasse;
		this.role = role;
	}

	public Utilisateur() {

	}

	@Override
	public String toString() {
		return "Utilisateur{" + "id=" + id + ", nom='" + nom + '\'' + ", prenom='" + prenom + '\'' + ", tel='" + tel
				+ '\'' + ", mail='" + mail + '\'' + ", motDePasse='" + motDePasse + '\'' + ", role='" + role + '\''
				+ '}';
	}

	// Setter and Getter
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String mot_de_passe) {
		this.motDePasse = mot_de_passe;
	}

	public RoleEnum getRole() {
		return this.role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}

}
