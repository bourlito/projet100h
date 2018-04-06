package com.Oenologie.oenologie.Classes;

/**
 * Created by etienne on 05/12/2017.
 */

public class Utilisateur {
    private String Pseudo;
    private int Highscore;

    public Utilisateur(String pseudo, int highscore) {
        this.Pseudo = pseudo;
        this.Highscore = highscore;
    }

    public String getPseudo() {
        return Pseudo;
    }

    public void setPseudo(String pseudo) {
        Pseudo = pseudo;
    }

    public int getHighscore() {
        return Highscore;
    }

    public void setHighscore() {
        Highscore++;
    }
}
