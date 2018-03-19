package managers;

import entities.Seance;
import impl.SeanceDao;
import impl.SeanceDaoImpl;

import java.util.Date;

public class SeanceLibrary {

    private static class SeanceLibraryHolder{
        final static SeanceLibrary instance = new SeanceLibrary();
    }

    public static SeanceLibrary getInstance(){
        return SeanceLibraryHolder.instance;
    }

    private SeanceDao seanceDao = new SeanceDaoImpl();

    private SeanceLibrary(){};

    public Seance getSeance (Integer id){
        return seanceDao.getSeance(id);
    }

    public Seance updateSeance (Integer id, String libelle, String date, String informations){
        return seanceDao.updateSeance(id,libelle,date,informations);
    }
}
