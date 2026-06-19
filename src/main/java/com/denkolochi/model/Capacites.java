package com.denkolochi.model;

public class Capacites {
	private int id_capacite;
	private String type_capacite;

	public Capacites() {
	}

	public Capacites(int id_capacite, String type_capacite) {
		this.id_capacite = id_capacite;
		this.type_capacite = type_capacite;
	}

	public int getId_capacite() {
		return id_capacite;
	}

	public void setId_capacite(int id_capacite) {
		this.id_capacite = id_capacite;
	}

	public String getType_capacite() {
		return type_capacite;
	}

	public void setType_capacite(String type_capacite) {
		this.type_capacite = type_capacite;
	}

}
