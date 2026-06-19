package com.denkolochi.model;

import java.util.Date;

public class Evaluation {
	private int id;
	private String typeActivite;
	private int score;
	private int scoreGlobal;
	private Date dateEval;
	private int idEnfant;
	private int idActivite;

	// constructeur//

	public int getId() {
		return id;
	}

	public Evaluation(int id, String typeActivite, int score, int scoreGlobal, Date dateEval, int idEnfant,
			int idActivite) {
		this.id = id;
		this.typeActivite = typeActivite;
		this.score = score;
		this.scoreGlobal = scoreGlobal;
		this.dateEval = dateEval;
		this.idEnfant = idEnfant;
		this.idActivite = idActivite;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String gettypeActivite() {
		return typeActivite;
	}

	public void settypeActivite(String typeActivite) {
		this.typeActivite = typeActivite;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScoreglobal() {
		return scoreGlobal;
	}

	public void setScoreglobal(int scoreGlobal) {
		this.scoreGlobal = scoreGlobal;
	}

	public Date getDateEval() {
		return dateEval;
	}

	public void setDateEval(Date date_Eval) {
		this.dateEval = date_Eval;
	}

	public int getIdEnfant() {
		return idEnfant;
	}

	public void setIdEnfant(int idEnfant) {
		this.idEnfant = idEnfant;
	}

	public int getIdActivite() {
		return idActivite;
	}

	public void setIdActivite(int idActivité) {
		this.idActivite = idActivité;
	}

}