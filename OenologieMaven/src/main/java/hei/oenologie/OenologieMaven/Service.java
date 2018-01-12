package hei.oenologie.OenologieMaven;

import java.util.List;

public class Service implements Getter{
    private static Service instance;

    private Dao dao;

    public static Service getInstance(){
        return instance;
    }

    private Service(){}

    public List<Seance> getSeances(){return dao.getSeances();}

    public Seance getSeance(int id_seance){return null;}

    public Seance createNewSeance(Seance seance){return null;}
}
