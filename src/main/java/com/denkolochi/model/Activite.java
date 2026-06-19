package com.denkolochi.model;

import com.denkolochi.enumeration.TypeActivitesEnum;

import java.time.LocalDateTime;

public class Activite {

	private int idActivite;
	private String titre;
	private String descriptions;

	private int ageMin;
	private int ageMax;

	private LocalDateTime dateCreation;

	private int idCapacite;

	private TypeActivitesEnum typeActivites;

	// =========================
	// =========================

	public Activite() {
	}

	// =========================
	// =========================

	public Activite(int idActivite, String titre, String descriptions, int ageMin, int ageMax,
			LocalDateTime dateCreation, int idCapacite, TypeActivitesEnum typeActivites) {

		this.idActivite = idActivite;
		this.titre = titre;
		this.descriptions = descriptions;
		this.ageMin = ageMin;
		this.ageMax = ageMax;
		this.dateCreation = dateCreation;
		this.idCapacite = idCapacite;
		this.typeActivites = typeActivites;
	}

	// =========================
	// GETTERS & SETTERS
	// =========================

	public int getIdActivite() {
		return idActivite;
	}

	public void setIdActivite(int idActivite) {
		this.idActivite = idActivite;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public int getAgeMin() {
		return ageMin;
	}

	public void setAgeMin(int ageMin) {
		this.ageMin = ageMin;
	}

	public int getAgeMax() {
		return ageMax;
	}

	public void setAgeMax(int ageMax) {
		this.ageMax = ageMax;
	}

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public int getIdCapacite() {
		return idCapacite;
	}

	public void setIdCapacite(int idCapacite) {
		this.idCapacite = idCapacite;
	}

	public TypeActivitesEnum getTypeActivites() {
		return typeActivites;
	}

	public void setTypeActivites(TypeActivitesEnum typeActivites) {
		this.typeActivites = typeActivites;
	}

	// =========================
	// toString()
	// =========================

	@Override
	public String toString() {

		return "Activite{" + "idActivite=" + idActivite + ", titre='" + titre + '\'' + ", descriptions='" + descriptions
				+ '\'' + ", ageMin=" + ageMin + ", ageMax=" + ageMax + ", dateCreation=" + dateCreation
				+ ", idCapacite=" + idCapacite + ", typeActivites=" + typeActivites + '}';
	}
}