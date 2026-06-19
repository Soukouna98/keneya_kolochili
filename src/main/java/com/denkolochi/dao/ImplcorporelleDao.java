package com.denkolochi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import com.denkolochi.configuration.ConnexionDB;
import com.denkolochi.model.Corporelle;

public class ImplcorporelleDao implements Repository<Corporelle, Integer> {
	Connection con = ConnexionDB.getInstance().getconnection();



    @Override
    public void save( Corporelle entity) {
 

		String sql = "INSERT INTO corporelles VALUES (?,?,?,?,?,?)";
		try (PreparedStatement pont = con.prepareStatement(sql)) {
			pont.setNull(1, java.sql.Types.INTEGER);
			pont.setInt(2, entity.getId_enfant());
			pont.setDouble(3, entity.getPoids());
			pont.setDouble(4, entity.getTaille());
			pont.setDouble(5, entity.getImc());
			pont.setDate(6,
					entity.getDate_mesure() != null ? new java.sql.Date(entity.getDate_mesure().getTime()) : null);

			int b = pont.executeUpdate();
			if (b > 0) {
				System.out.println("Capacite corporelle inserer avec succès");
			}

			con.close();

		} catch (SQLException e) {
			System.err.println("Problème d'insertion de corporelle");
			System.err.println("Erreur sql: " + e.getSQLState());
			System.err.println("Erreur message: " + e.getMessage());
		}
	}

	@Override
	public Corporelle findById(Integer id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findById'");
	}

	@Override
	public List<Corporelle> findAll() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findAll'");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}

	@Override
	public void update(Integer id, Corporelle entity) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}