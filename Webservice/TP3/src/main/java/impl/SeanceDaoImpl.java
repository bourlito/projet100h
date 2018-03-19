package impl;

import datasource.DatasourceProvider;
import entities.Seance;

import java.sql.*;

public class SeanceDaoImpl implements SeanceDao {

    @Override
    public Seance getSeance1 (Integer Id) {
        String query = "SELECT * FROM `seance` WHERE Id_seance=1";
        try(
                Connection connection = DatasourceProvider.getDaraSource().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)
        ) {
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return null;
    }

    public Seance getSeance2 (Integer Id) {
        String query = "SELECT * FROM `seance` WHERE Id_seance=2";
        try(
                Connection connection = DatasourceProvider.getDaraSource().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)
        ) {
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return null;
    }

    public Seance getSeance3 (Integer Id) {
        String query = "SELECT * FROM `seance` WHERE Id_seance=3";
        try(
                Connection connection = DatasourceProvider.getDaraSource().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)
        ) {
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return null;
    }

    @Override
    public Seance updateSeance(Integer id, String libelle, String date, String informations) {
        try (Connection connection = DatasourceProvider.getDaraSource().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "UPDATE seance SET Libelle=?, Date=?, Informations=? WHERE Id_seance=?")) {
                statement.setString(1, libelle );
                statement.setDate(2, Date.valueOf(date));
                statement.setString(3,informations);
                statement.setInt(4, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
