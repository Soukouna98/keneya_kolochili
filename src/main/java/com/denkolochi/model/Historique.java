package com.denkolochi.model;

import java.sql.Date;

public class Historique {
	private int idHistorique;
	private String action;
	private String details;
	private Date dateAction;
	private int idEnfant;

	public Historique() {
	}

	public int getIdHistorique() {
		return idHistorique;
	}

	public void setIdHistorique(int idHistorique) {
		this.idHistorique = idHistorique;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getDateAction() {
		return dateAction;
	}

	public void setDateAction(Date dateAction) {
		this.dateAction = dateAction;
	}

	public int getIdEnfant() {
		return idEnfant;
	}

	public void setIdEnfant(int idEnfant) {
		this.idEnfant = idEnfant;
	}

}
