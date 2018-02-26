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


    }

    @Override
    public Seance updateSeance(Integer id, String libelle, Date date, String informations, Integer code_quizz) {
        return null;
    }
}
