package com.denkolochi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.denkolochi.configuration.ConnexionDB;
import com.denkolochi.model.Activite;
import com.denkolochi.model.Quiz;
import com.denkolochi.enumeration.TypeActivitesEnum;


public class ImplQuizDao implements Repository<Quiz,Integer> {
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

	public Activite findActiviteById(Integer id) {
		String sql = "SELECT * FROM Activites WHERE id_activites = ?";
		try (PreparedStatement prepare = con.prepareStatement(sql)) {
			prepare.setInt(1, id);
			try (ResultSet rs = prepare.executeQuery()) {

				if (rs.next()) {

					Activite activite = new Activite();
					activite.setIdActivite(rs.getInt("id_activites"));
					activite.setTitre(rs.getString("titre"));
					activite.setDescriptions(rs.getString("descriptions"));
					activite.setAgeMin(rs.getInt("age_min"));
					activite.setAgeMax(rs.getInt("age_max"));
					activite.setIdCapacite(rs.getInt("id_capacite"));
					activite.setTypeActivites(TypeActivitesEnum.valueOf(rs.getString("type_activites").toUpperCase()));
					return activite;
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

	public List<Activite> findByAge(int age) {

		String sql = """
				        SELECT
				    q.id_quiz,
				    q.temps_limite,
				    q.score_max,
				    a.id_activites,
				    a.titre,
				    a.descriptions,
				    a.age_min,
				    a.age_max,
				    a.id_capacite,
				    a.type_activites
				FROM activites a
				INNER JOIN quiz q
				    ON q.id_quiz = a.id_activites
				WHERE a.age_min <= ?
				AND a.age_max >= ?;
				    """;

		List<Activite> quizs = new ArrayList<>();

		try (PreparedStatement prepare = con.prepareStatement(sql)) {

			prepare.setInt(1, age);
			prepare.setInt(2, age);

			try (ResultSet rs = prepare.executeQuery()) {

				while (rs.next()) {

					Quiz quiz = new Quiz();

					// =====================
					// Partie Activite
					// =====================

					quiz.setIdActivite(rs.getInt("id_activites"));

					quiz.setTitre(rs.getString("titre"));

					quiz.setDescriptions(rs.getString("descriptions"));

					quiz.setAgeMin(rs.getInt("age_min"));

					quiz.setAgeMax(rs.getInt("age_max"));

					quiz.setIdCapacite(rs.getInt("id_capacite"));

					quiz.setTypeActivites(TypeActivitesEnum.valueOf(rs.getString("type_activites").toUpperCase()));

					// =====================
					// Partie Quiz
					// =====================

					quiz.setIdQuiz(rs.getInt("id_quiz"));

					quiz.setTempsLimitGlobal(rs.getInt("temps_limite"));

					quiz.setScoreMax(rs.getInt("score_max"));

					quizs.add(quiz);
				}
			}

		} catch (SQLException e) {

			System.out.println("Erreur SQL : " + e.getMessage());
		}

		return quizs;
	}
}