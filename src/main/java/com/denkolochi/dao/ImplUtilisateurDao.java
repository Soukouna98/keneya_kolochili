package com.denkolochi.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.denkolochi.configuration.ConnexionDB;
import com.denkolochi.model.Utilisateur;
import com.denkolochi.enumeration.RoleEnum;


public class ImplUtilisateurDao implements Repository<Utilisateur, Integer>{
    Connection con = ConnexionDB.getInstance().getconnection();
   

	@Override
	public void save(Utilisateur entity) {
		// entity.toString();
		String sql = "INSERT INTO utilisateurs VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement prepare = con.prepareStatement(sql);
			prepare.setNull(1, 0);
			prepare.setString(2, entity.getNom());
			prepare.setString(3, entity.getPrenom());
			prepare.setString(4, entity.getTel());
			prepare.setString(5, entity.getMail());
			prepare.setString(6, entity.getMotDePasse());
			prepare.setString(7, entity.getRole().toString());

			int test = prepare.executeUpdate();
			if (test > 0) {
				System.out.println("Utilisateur ajouter avec sucess!!!");
			}
		} catch (SQLException e) {
			System.err.println("Un probleme est survenu lors de l'insertion");
			System.err.println("Erreur sql: " + e.getSQLState());
			System.err.println("Erreur message: " + e.getMessage());

		}

	}

	@Override
	public Utilisateur findById(Integer id) {
		Utilisateur utilisateur = new Utilisateur();
		String sql = "SELECT * FROM utilisateurs WHERE id = " + id;
		try {
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery(sql);

			if (result.next()) {
				utilisateur.setId(result.getInt("id"));
				utilisateur.setNom(result.getString("nom"));
				utilisateur.setPrenom(result.getString("prenom"));
				utilisateur.setTel(result.getString("tel"));
				utilisateur.setMail(result.getString("mail"));
				utilisateur.setMotDePasse(result.getString("mot_de_passe"));
				utilisateur.setRole(RoleEnum.valueOf(result.getString("role")));

				return utilisateur;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public List<Utilisateur> findAll() {

		List<Utilisateur> utilisateurs = new ArrayList();
		Utilisateur utilisateur = new Utilisateur();
		String sql = "SELECT * FROM utilisateurs";
		try {
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery(sql);
			while (result.next()) {
				utilisateur.setId(result.getInt("id"));
				utilisateur.setNom(result.getString("nom"));
				utilisateur.setPrenom(result.getString("prenom"));
				utilisateur.setTel(result.getString("tel"));
				utilisateur.setMail(result.getString("mail"));
				utilisateur.setMotDePasse(result.getString("mot_de_passe"));
				utilisateur.setRole(RoleEnum.valueOf(result.getString("role")));

				utilisateurs.add(utilisateur);
				utilisateur = null;
			}
			return utilisateurs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(Integer integer) {
		String sql = "DELETE utilisateurs WHERE id = ?";
		try {
			PreparedStatement prepare = con.prepareStatement(sql);
			prepare.setInt(1, integer);

			int resultat = prepare.executeUpdate();
			if (resultat > 0) {
				System.out.println("Utilisateur supprimer");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(Integer id, Utilisateur entity) {
		String sql = "UPDATE utilisateurs " + "SET nom = ?, prenom = ?, tel = ?, mail = ?, mot_de_passe = ?, roles = ?"
				+ "WHERE id = ?";

		try {
			PreparedStatement prepare = con.prepareStatement(sql);
			prepare.setString(1, entity.getNom());
			prepare.setString(2, entity.getPrenom());
			prepare.setString(3, entity.getTel());
			prepare.setString(4, entity.getMail());
			prepare.setString(5, entity.getMotDePasse());
			prepare.setString(6, entity.getRole().toString());
			prepare.setInt(7, id);
			int resultat = prepare.executeUpdate();
			if (resultat > 0) {
				System.out.println("L'utilisateur modifier");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Utilisateur findByMail(String mail) {
		String sql = "SELECT * FROM utilisateurs WHERE mail = ?";
		try (PreparedStatement pont = con.prepareStatement(sql)) {
			pont.setString(1, mail);
			ResultSet rs = pont.executeQuery();
			if (rs.next()) {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setId(rs.getInt("id"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setRole(null);
				utilisateur.setMail(rs.getString("mail"));
				utilisateur.setTel(rs.getString("tel"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				return utilisateur;
			}
		} catch (SQLException e) {
			System.err.println("Probleme de recuperation d'utilisateur");
			System.err.println("Erreur sql: " + e.getSQLState());
			System.err.println("Erreur message: " + e.getMessage());
		}
		return null;
	}

 

	public boolean seConnecter(String mail, String motDePasse) {

		String sql = "SELECT * FROM utilisateurs WHERE mail = ? AND mot_de_passe = ?";
		try {
			PreparedStatement prepare = con.prepareStatement(sql);
			prepare.setString(1, mail);
			prepare.setString(2, motDePasse);

			ResultSet result = prepare.executeQuery();
			if (result.next()) {
				return true;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return false;
	}

}
