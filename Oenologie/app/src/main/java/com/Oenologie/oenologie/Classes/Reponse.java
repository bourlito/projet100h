package com.Oenologie.oenologie.Classes;

/**
 * Created by etienne on 05/12/2017.
 */

public class Reponse {
    private int Id_reponse;
    private String Libelle;
    private Boolean Correct;

    public Reponse(int id_reponse, String libelle, Boolean correct) {
        this.Id_reponse = id_reponse;
        this.Libelle = libelle;
        this.Correct = correct;
    }

    public int getId_reponse() {
        return Id_reponse;
    }

    public void setId_reponse(int id_reponse) {
        Id_reponse = id_reponse;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }

    public Boolean getCorrect() {
        return Correct;
    }

    public void setCorrect(Boolean correct) {
        Correct = correct;
    }
}
