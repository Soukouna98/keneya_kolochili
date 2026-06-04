package com.denkolochi.model;

import java.util.Date;

public class ReponseEnfant {
	private int id_reponse;
	private int id_enfant;
	private int id_question;
	private int id_option;
	private Date Date_reponse;

	public ReponseEnfant(int id_reponse, int id_enfant, int id_question, int id_option, Date date_reponse) {
		this.id_reponse = id_reponse;
		this.id_enfant = id_enfant;
		this.id_question = id_question;
		this.id_option = id_option;
		Date_reponse = date_reponse;
	}

	public ReponseEnfant() {
	}

	public int getId_reponse() {
		return id_reponse;
	}

	public void setId_reponse(int id_reponse) {
		this.id_reponse = id_reponse;
	}

	public int getId_enfant() {
		return id_enfant;
	}

	public void setId_enfant(int id_enfant) {
		this.id_enfant = id_enfant;
	}

	public int getId_question() {
		return id_question;
	}

	public void setId_question(int id_question) {
		this.id_question = id_question;
	}

	public int getId_option() {
		return id_option;
	}

	public void setId_option(int id_option) {
		this.id_option = id_option;
	}

	public Date getDate_reponse() {
		return Date_reponse;
	}

	public void setDate_reponse(Date Date_reponse) {
		this.Date_reponse = Date_reponse;
	}

	@Override
	public String toString() {
		return "ReponseEnfant {id_reponse=" + id_reponse + ", id_enfant=" + id_enfant + ", id_question=" + id_question
				+ ", id_option=" + id_option + ", Date_reponse=" + Date_reponse + "}";
	}

}
