package com.denkolochi.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionDB {

	private static ConnexionDB instance = null;
	private Connection connection = null;



	public ConnexionDB() {
		try {
			this.connection = DriverManager.getConnection(DbConstConfig.url, DbConstConfig.utilisateur,
					DbConstConfig.mot_de_passe);
			System.out.println("Connexion MySQL établie avec succès.");
		} catch (SQLException e) {
			System.err.println("Erreur de connexion à la base de données.");
			System.err.println("Code SQL  : " + e.getErrorCode());
			System.err.println("Message   : " + e.getMessage());
		}
	}

	public static ConnexionDB getInstance() {
		try {
			if (instance == null) {
				instance = new ConnexionDB();
			}
		} catch (Exception e) {
			System.err.println("probleme de connection : " + e.getMessage());
		}

		return instance;
	}

	public Connection getconnection() {
		try {
			if (instance == null || connection.isClosed()) {
				System.out.println("Reconnexion en cours...");
				instance = new ConnexionDB();
			}
		} catch (SQLException e) {
			System.err.println("Erreur lors de la vérification de la connexion : " + e.getMessage());
		}

		return connection;
	}

	public void fermer() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
				instance = null;
				System.out.println("Connexion fermée.");
			}
		} catch (SQLException e) {
			System.err.println("Erreur lors de la fermeture : " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		try {
			Connection con = ConnexionDB.getInstance().getconnection();
			if (con != null) {
				Statement pont = con.createStatement();
				String sql = "INSERT INTO capacites VALUES (NULL, 'Emotionnelle')";
				int lignesAffectees = pont.executeUpdate(sql);

				System.out.println("Insertion réussie, lignes modifiées : " + lignesAffectees);
				pont.close();
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
