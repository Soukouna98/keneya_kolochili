package com.denkolochi.model;

public class Questionquiz {
	private int id_question;
	private int id_quiz;

	public Questionquiz() {
	}

	public Questionquiz(int id_question, int id_quiz) {
		this.id_question = id_question;
		this.id_quiz = id_quiz;
	}

	public int getId_question() {
		return id_question;
	}

	public void setId_question(int id_question) {
		this.id_question = id_question;
	}

	public int getId_quiz() {
		return id_quiz;
	}

	public void setId_quiz(int id_quiz) {
		this.id_quiz = id_quiz;
	}

}
