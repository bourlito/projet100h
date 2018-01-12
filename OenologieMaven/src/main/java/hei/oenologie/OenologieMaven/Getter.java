package hei.oenologie.OenologieMaven;

import java.util.List;

public interface Getter {
    Seance getSeance(int id_seance);
    List<Seance> getSeances();
}
