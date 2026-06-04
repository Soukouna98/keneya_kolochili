package com.denkolochi.model;

import java.util.Date;

public class Recommandation {
	private int id;
	private String description;
	private Date date_Recomm;
	private int id_evaluation;
	private int id_capacite;

	// constructeur//

	public Recommandation(int id, String description, Date date_Recomm, int id_evaluation, int id_capacite) {
		this.id = id;
		this.description = description;
		this.date_Recomm = date_Recomm;
		this.id_evaluation = id_evaluation;
		this.id_capacite = id_capacite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate_Recomm() {
		return date_Recomm;
	}

	public void setDateRecomm(Date date_Recomm) {
		this.date_Recomm = date_Recomm;
	}

	public int getId_evaluation() {
		return id_evaluation;
	}

	public void setId_evaluation(int id_evaluation) {
		this.id_evaluation = id_evaluation;
	}

	public int getId_capacite() {
		return id_capacite;
	}

	public void setId_capacite(int id_capacite) {
		this.id_capacite = id_capacite;
	}

}