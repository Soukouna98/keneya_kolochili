package com.denkolochi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import com.denkolochi.configuration.ConnexionDB;
import com.denkolochi.model.Recommandation;

public class ImplRecommandationDao implements Repository<Recommandation, Integer> {
	Connection con = ConnexionDB.getInstance().getconnection();

	@Override
	public void save(Recommandation entity) {

		String sql = "INSERT INTO recommandation(description, date_recomm, idEvaluation, idCapacite) VALUES (?,?,?,?,?)";
		try (PreparedStatement pont = con.prepareStatement(sql)) {


			pont.setNull(1, Types.INTEGER);
			pont.setString(2, entity.getDescription());
			pont.setDate(3, (Date) entity.getDate_Recomm());
			pont.setInt(4, entity.getId_evaluation());
			pont.setInt(5, entity.getId_capacite());

			int b = pont.executeUpdate();
			if (b > 0) {
				System.out.println("Recommandation ajouter avec succès");
			}
			con.close();

		} catch (SQLException e) {
			System.out.println("Il y'a un problème avec l'insertion");
			e.printStackTrace();
		}
	}

	public ImplRecommandationDao() {
	}

	@Override
	public Recommandation findById(Integer id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findById'");
	}

	@Override
	public List<Recommandation> findAll() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findAll'");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}

	@Override
	public void update(Integer id, Recommandation entity) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}