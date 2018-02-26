package impl;

import entities.Seance;

import java.util.Date;

public interface SeanceDao {
    public Seance getSeance (Seance seance);
    public Seance updateSeance (Integer id, String libelle, Date date, String informations, Integer code_quizz);
}
