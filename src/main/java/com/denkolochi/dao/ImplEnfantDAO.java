package com.denkolochi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.denkolochi.configuration.ConnexionDB;
import com.denkolochi.model.Enfant;

public class ImplEnfantDAO implements Repository<Enfant, Integer> {
	Connection con = ConnexionDB.getInstance().getconnection();


    @Override
    public void save(Enfant entity) {
        try {
            String sql = "INSERT INTO enfants (nom, prenom, date_naissance, sexe, id_parent) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, entity.getNom());
            stm.setString(2, entity.getPrenom());
            stm.setDate(3, java.sql.Date.valueOf(entity.getDate_naissance()));
            stm.setString(4, entity.getSexe());
            stm.setInt(5, entity.getid_parent());
            stm.execute();
            System.out.println("Enfant ajouté avec succès !");
        } catch (SQLException e) {
            System.err.println("Problème d'insertion d'enfant");
            System.err.println("Erreur sql: " + e.getSQLState());
            System.err.println("Erreur message: " + e.getMessage());
        }
    }

   


    @Override
    public List<Enfant> findAll() {
        List<Enfant> enfants = new ArrayList<>();
        try {
            String sql = "SELECT * FROM enfants";  // ✅ nom correct
            java.sql.Statement stm = con.createStatement();
            ResultSet result = stm.executeQuery(sql);

			if (result.next()) {
				Enfant en = new Enfant();
				en.setId(result.getInt("id_enfants"));
				en.setNom(result.getString("nom"));
				en.setPrenom(result.getString("prenom"));
				en.setDate_naissance(LocalDate.parse(result.getDate("date_naissance").toString()));
				en.setSexe(result.getString("sexe"));
				en.setParent(result.getInt("id_parent"));
				enfants.add(en);
				return enfants;
			}
		} catch (SQLException e) {
			System.err.println("Enfant non trouvé : " + e.getMessage());
		}
		return null;
	}


    @Override
    public void delete(Integer id) {
        try {
            String sql = "DELETE FROM enfants WHERE id_enfants = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
            System.out.println("Enfant supprimé avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur suppression : " + e.getMessage());
        }
    }

    @Override
    public void update(Integer id, Enfant entity) {
        try {
            // ✅ "UPDATE" sans "table", nom de table correct
            String sql = "UPDATE enfants SET nom = ?, prenom = ?, date_naissance = ?, id_parent = ? WHERE id_enfants = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, entity.getNom());
            stm.setString(2, entity.getPrenom());
            stm.setDate(3, java.sql.Date.valueOf(entity.getDate_naissance()));
            stm.setInt(4, entity.getid_parent());
            stm.setInt(5, id); // ✅ paramètre "id" reçu en argument
            int result = stm.executeUpdate();
            if (result > 0) {
                System.out.println("Enfant modifié avec succès !");
            }
        } catch (SQLException e) {
            System.err.println("Erreur modification : " + e.getMessage());
        }
    }






	public List<Enfant> findAllByIdParent(int id_parent) {
		List<Enfant> enfants = new ArrayList<>();
		try {

			String sql = "SELECT * FROM enfants WHERE id_parent = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id_parent);
			ResultSet resultat = stm.executeQuery();
			while (resultat.next()) {
				Enfant en = new Enfant();
				en.setId(resultat.getInt("id_enfants"));
				en.setNom(resultat.getString("nom"));
				en.setPrenom(resultat.getString("prenom"));
				en.setDate_naissance(LocalDate.parse(resultat.getDate("date_naissance").toString()));
				en.setSexe(resultat.getString("sexe"));
				en.setParent(resultat.getInt("id_parent")); // ✅ plus d'id_activite
				enfants.add(en);
			}
		} catch (SQLException e) {
			System.err.println("Erreur lors de la récupération des enfants : " + e.getMessage());
		}
		return enfants;
	}

	public Enfant saveEnfant(Enfant entity) {
		try {

			String sql = "INSERT INTO enfants (nom, prenom, date_naissance, sexe, id_parent) VALUES (?, ?, ?, ?, ?)";

			PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stm.setString(1, entity.getNom());
			stm.setString(2, entity.getPrenom());
			stm.setDate(3, java.sql.Date.valueOf(entity.getDate_naissance()));
			stm.setString(4, entity.getSexe());
			stm.setInt(5, entity.getid_parent());
			int row = stm.executeUpdate();
			if (row > 0) {

				// Recuperer l'id généré
				ResultSet rs = stm.getGeneratedKeys();

				if (rs.next()) {
					int idGenere = rs.getInt(1);

					// mettre l'id dans l'objet
					entity.setId(idGenere);
				}

				System.out.println("Enfant ajouté avec succès !");
				return entity;
			}

		} catch (SQLException e) {
			System.err.println("Problème d'insertion d'enfant");
			System.err.println("Erreur sql: " + e.getSQLState());
			System.err.println("Erreur message: " + e.getMessage());
		}

		return null;
	}




	@Override
	public Enfant findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}