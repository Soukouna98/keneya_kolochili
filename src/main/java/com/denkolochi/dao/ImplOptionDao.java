package com.denkolochi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.denkolochi.configuration.ConnexionDB;
import com.denkolochi.model.Option;

public class ImplOptionDao implements Repository<Option, Integer> {
	Connection con = ConnexionDB.getInstance().getconnection();


@Override
public void save(Option entity) {
    String sql = "INSERT INTO option (id, texte, estCorrecte) VALUES (?,?,?,?)";
    try (PreparedStatement pont = con.prepareStatement(sql)) {
        pont.setInt(1, entity.getId());
        pont.setString(2, entity.getTexte());
        pont.setBoolean(3, entity.isEstCorrecte());
        pont.setInt(4, entity.getId_question());

        int rows = pont.executeUpdate();
        if (rows > 0) {
            System.out.println("Option insérée avec succès");
        }
        con.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    @Override
    public void update(Integer id, Option entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updtae'");
    }

   

	@Override
	public Option findById(Integer id) {

		String sql = "SELECT * FROM options WHERE id_options = ?";
		try (PreparedStatement pont = con.prepareStatement(sql)) {
			pont.setInt(1, id);
			ResultSet rs = pont.executeQuery();
			if (rs.next()) {
				Option option = new Option();
				option.setId(rs.getInt("id_options"));
				option.setTexte(rs.getString("texte"));
				option.setEstCorrecte(rs.getBoolean("est_correct"));
				return option;
			}
		} catch (SQLException e) {
			System.out.println("Erreur lors de la récupération de l'option : " + e.getMessage());
		}
		return null;
	}


	@Override
	public List<Option> findAll() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findAll'");
	}


	public List<Option> findByIdQuestion(int id_question) {

		String sql = "SELECT * FROM options WHERE id_question = ?";

		List<Option> options = new ArrayList<>();

		try (PreparedStatement pont = con.prepareStatement(sql)) {

			pont.setInt(1, id_question);

			ResultSet rs = pont.executeQuery();

			while (rs.next()) {

				Option option = new Option();

				option.setId(rs.getInt("id_options"));
				option.setTexte(rs.getString("texte"));
				option.setEstCorrecte(rs.getBoolean("est_correct"));

				options.add(option);
			}

		} catch (SQLException e) {

			System.out.println("Erreur lors de la récupération des options : " + e.getMessage());
		}

		return options;
	}
}