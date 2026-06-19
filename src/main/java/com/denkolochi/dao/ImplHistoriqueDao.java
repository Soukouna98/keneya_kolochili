package com.denkolochi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.denkolochi.configuration.ConnexionDB;
import com.denkolochi.model.Historique;

public class ImplHistoriqueDao {

	// IMPORTANT : On ne stocke plus la Connection ici au démarrage !

	public void save(Historique h) {
		String sql = "INSERT INTO historique(action, details, id_enfants) VALUES(?, ?, ?)";

		// On récupère la connexion valide JUSTE ICI
		try (Connection con = ConnexionDB.getInstance().getconnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, h.getAction());
			ps.setString(2, h.getDetails());
			ps.setInt(3, h.getIdEnfant());

			ps.executeUpdate();
			System.out.println("Historique sauvegardé avec succès.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Historique> findByEnfant(int idEnfant) {
		List<Historique> liste = new ArrayList<>();
		String sql = "SELECT * FROM historique WHERE id_enfants=? ORDER BY dateAction DESC";

		System.out.println("[DAO DEBUG] Exécution de la requête pour id_enfants = " + idEnfant);

		try (Connection con = ConnexionDB.getInstance().getconnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, idEnfant);

			try (ResultSet rs = ps.executeQuery()) {
				int compteur = 0;
				while (rs.next()) {
					compteur++;
					System.out.println("[DAO DEBUG] Ligne trouvée dans le ResultSet ! ID Historique: "
							+ rs.getInt("id_historique"));

					Historique h = new Historique();
					h.setIdHistorique(rs.getInt("id_historique"));
					h.setAction(rs.getString("action"));
					h.setDetails(rs.getString("details"));
					h.setDateAction(rs.getDate("dateAction"));
					h.setIdEnfant(rs.getInt("id_enfants"));

					liste.add(h);
				}
				System.out.println("[DAO DEBUG] Total de lignes lues dans le ResultSet : " + compteur);
			}

		} catch (Exception e) {
			System.err.println("[DAO ERROR] Quelque chose a planté dans le DAO !");
			e.printStackTrace(); // Regardez TRÈS attentivement si cette ligne s'affiche
		}

		return liste;
	}
}