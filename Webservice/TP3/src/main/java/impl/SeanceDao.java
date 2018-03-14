package impl;

import entities.Seance;

import java.util.Date;

public interface SeanceDao {
    public Seance getSeance (Seance seance);
    public void updateSeance (Integer id, Seance seance);
}
