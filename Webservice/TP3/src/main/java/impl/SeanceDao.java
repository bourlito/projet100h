package impl;

import entities.Seance;

public interface SeanceDao {
    public Seance getSeance ( Integer Id);
    public Seance updateSeance (Integer id, String libelle, String date, String informations);
}
