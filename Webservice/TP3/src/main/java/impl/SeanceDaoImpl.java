package impl;

import datasource.DatasourceProvider;
import entities.Seance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class SeanceDaoImpl implements SeanceDao {
    @Override
    public Seance getSeance(Seance seance) {
        String query = "SELECT * FROM `seance` WHERE Id_seance=1";
        try (Connection connection = DatasourceProvider.getDaraSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {


    } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateSeance(Integer id, Seance seance) {
        try (Connection connection = DatasourceProvider.getDaraSource().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "UPDATE seance SET Libelle=?, Date=?, Informations=? WHERE Id_seance=?")) {
                statement.setString(1, seance.getLibelle() );
                statement.setDate(2, (java.sql.Date) seance.getDate());
                statement.setString(3, seance.getInformtions());
                statement.setInt(4, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
