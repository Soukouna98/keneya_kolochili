package com.denkolochi.model;

import java.util.Date;

public class EnfantActivite {
	private int id_enfant;
	private int id_activite;
	private Date date_participation;

	public EnfantActivite(int id_enfant, int id_activite, Date date_participation) {
		this.id_enfant = id_enfant;
		this.id_activite = id_activite;
		this.date_participation = date_participation;
	}

	public EnfantActivite() {
	}

	public int getId_enfant() {
		return id_enfant;
	}

	public void setId_enfant(int id_enfant) {
		this.id_enfant = id_enfant;
	}

	public int getId_activite() {
		return id_activite;
	}

	public void setId_activite(int id_activite) {
		this.id_activite = id_activite;
	}

	public Date getDate_participation() {
		return date_participation;
	}

	public void setDate_participation(Date date_participation) {
		this.date_participation = date_participation;
	}

	@Override
	public String toString() {
		return "EnfantActivite {id_enfant=" + id_enfant + ", id_activite=" + id_activite + ", date_participation="
				+ date_participation + "}";
	}

}