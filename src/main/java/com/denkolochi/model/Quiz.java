package com.denkolochi.model;

import com.denkolochi.enumeration.TypeActivitesEnum;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Quiz extends Activite {

	private int idQuiz;

	private int tempsLimitGlobal;

	private int scoreMax;

	
	private List<Question> questions;

	// =========================
	// Constructeur vide
	// =========================

	public Quiz() {
		super();
	}

	// =========================
	// Constructeur simple
	// =========================

	public Quiz(int tempsLimitGlobal, int scoreMax) {

		this.tempsLimitGlobal = tempsLimitGlobal;
		this.scoreMax = scoreMax;
	}

	// =========================
	// Constructeur complet
	// =========================

	public Quiz(int idQuiz, int tempsLimitGlobal, int scoreMax,

			int idActivite, String titre, String descriptions, int ageMin, int ageMax, LocalDateTime dateCreation,
			int idCapacite, TypeActivitesEnum typeActivites) {

		super(idActivite, titre, descriptions, ageMin, ageMax, dateCreation, idCapacite, typeActivites);

		this.idQuiz = idQuiz;
		this.tempsLimitGlobal = tempsLimitGlobal;
		this.scoreMax = scoreMax;
	}

	// =========================
	// GETTERS & SETTERS
	// =========================
	
	public void setQuestions(List<Question> questions) {
	    this.questions = questions;
	}

	public int getIdQuiz() {
		return idQuiz;
	}

	public void setIdQuiz(int idQuiz) {
		this.idQuiz = idQuiz;
	}

	public int getTempsLimitGlobal() {
		return tempsLimitGlobal;
	}

	public void setTempsLimitGlobal(int tempsLimitGlobal) {
		this.tempsLimitGlobal = tempsLimitGlobal;
	}

	public int getScoreMax() {
		return scoreMax;
	}

	public void setScoreMax(int scoreMax) {
		this.scoreMax = scoreMax;
	}

	// =========================
	// hashCode()
	// =========================

	@Override
	public int hashCode() {
		return Objects.hash(idQuiz, tempsLimitGlobal, scoreMax);
	}

	// =========================
	// equals()
	// =========================

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Quiz other = (Quiz) obj;

		return idQuiz == other.idQuiz && tempsLimitGlobal == other.tempsLimitGlobal && scoreMax == other.scoreMax;
	}

	// =========================
	// toString()
	// =========================

	@Override
	public String toString() {

		return "Quiz{" + "idQuiz=" + idQuiz + ", titre='" + getTitre() + '\'' + ", tempsLimitGlobal=" + tempsLimitGlobal
				+ ", scoreMax=" + scoreMax + ", ageMin=" + getAgeMin() + ", ageMax=" + getAgeMax() + ", typeActivites="
				+ getTypeActivites() + '}';
	}
}
