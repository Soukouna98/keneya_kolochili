package com.denkolochi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.denkolochi.configuration.ConnexionDB;
import com.denkolochi.model.Quiz;


public class QuizDao implements Repository<Quiz,Integer> {
    Connection con = ConnexionDB.getInstance().getconnection();

	@Override
	public void save(Quiz entity) {
		String sql = "INSERT INTO quiz(temps_limite,score_max) VALUES (?,?)";
		try (PreparedStatement prepare = con.prepareStatement(sql)) {
			prepare.setInt(1, entity.getTempsLimitGlobal());
			prepare.setInt(2, entity.getScoreMax());

			int row = prepare.executeUpdate();
			if (row == 1) {
				System.out.println("Insertions reussie");
			} else {
				System.out.println("Il y'a un probleme");
			}

		} catch (SQLException e) {
			System.out.println("Erreur au niveau de SQL " + e.getMessage());
		}

	}

	@Override
	public Quiz findById(Integer id) {
		String sql = "SELECT * FROM quiz WHERE id_quiz = ?";
		try (PreparedStatement prepare = con.prepareStatement(sql)) {
			prepare.setInt(1, id);
			try (ResultSet rs = prepare.executeQuery()) {

				if (rs.next()) {

					Quiz quiz = new Quiz();
					quiz.setTempsLimitGlobal(rs.getInt("temps_limite"));
					quiz.setScoreMax(rs.getInt("score_max"));
					return quiz;
				} else {
					System.out.println("Aucun quiz trouvé avec l'id " + id);
					return null;
				}
			}
		} catch (SQLException e) {
			System.out.println("Erreur au niveau de SQL " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<Quiz> findAll() {
		String sql = "SELECT * FROM quiz ";
		List<Quiz> Quizs = new ArrayList<Quiz>();
		try (PreparedStatement prepare = con.prepareStatement(sql)) {
			ResultSet rs = prepare.executeQuery();
			while (rs.next()) {
				Quiz quiz = new Quiz();
				quiz.setIdQuiz(rs.getInt("id_quiz"));
				quiz.setTempsLimitGlobal(rs.getInt("temps_limite"));
				quiz.setScoreMax(rs.getInt("score_max"));
				Quizs.add(quiz);
			}

		} catch (SQLException e) {
			System.out.println("Erreur au niveau de SQL " + e.getMessage());
			return null;
		}
		return Quizs;
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM QUIZ WHERE id_quiz = ?";
		try (PreparedStatement prepare = con.prepareStatement(sql)) {
			prepare.setInt(1, id);

			int row = prepare.executeUpdate();
			if (row == 1) {
				System.out.println("Suppresion reussie");
			} else {
				System.out.println("Il y'a un probleme");
			}

		} catch (SQLException e) {
			System.out.println("Erreur au niveau de SQL " + e.getMessage());
		}
	}

	@Override
	public void update(Integer id, Quiz entity) {
		String sql = "Update QUIZ SET temps_limite = ?,score_max = ?  WHERE id_quiz = ?";
		try (PreparedStatement prepare = con.prepareStatement(sql)) {
			prepare.setInt(1, entity.getTempsLimitGlobal());
			prepare.setInt(2, entity.getScoreMax());
			prepare.setInt(3, id);

			int row = prepare.executeUpdate();
			if (row == 1) {
				System.out.println("Modification reussie");
			} else {

				System.out.println("Il y'a un probleme");

			}

		} catch (SQLException e) {
			System.out.println("Erreur au niveau de SQL " + e.getMessage());
		}
	}

}
