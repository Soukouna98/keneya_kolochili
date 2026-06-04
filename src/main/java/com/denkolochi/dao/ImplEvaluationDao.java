package com.denkolochi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import com.denkolochi.configuration.ConnexionDB;
import com.denkolochi.model.Evaluation;

public class ImplEvaluationDao implements Repository<Evaluation, Integer> {
	Connection con = ConnexionDB.getInstance().getconnection();


	@Override
	public void save(Evaluation entity) {
		String sql = "INSERT INTO evaluation VALUES (?,?,?,?,?,?)";
		try (PreparedStatement pont = con.prepareStatement(sql)) {
			pont.setNull(1, 0);
			pont.setInt(2, entity.getScore());
			pont.setInt(3, entity.getScoreglobal());
			pont.setDate(4, (Date) entity.getDateEval());
			pont.setInt(5, entity.getIdEnfant());
			pont.setInt(6, entity.getIdActivite());

			int b = pont.executeUpdate();
			if (b > 0) {
				System.err.println("Evaluation inserer avec succès");
			}
			con.close();
		} catch (SQLException e) {
			System.err.println("Probleme d'insertion d'evaluation");
			System.err.println("Erreur sql: " + e.getSQLState());
			System.err.println("Erreur message: " + e.getMessage());
		}
	}

	@Override
	public Evaluation findById(Integer id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findById'");
	}

	@Override
	public List<Evaluation> findAll() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findAll'");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}

	@Override
	public void update(Integer id, Evaluation entity) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
