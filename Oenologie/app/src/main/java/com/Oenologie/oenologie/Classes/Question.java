package com.Oenologie.oenologie.Classes;

import java.util.List;

/**
 * Created by etienne on 05/12/2017.
 */

public class Question {
    private int Id_question;
    private String Libelle;
    private List<Reponse> Reponses;

    public Question(int id_question, String libelle) {
        this.Id_question = id_question;
        this.Libelle = libelle;
    }

    public int getId_question() {
        return Id_question;
    }

    public void setId_question(int id_question) {
        Id_question = id_question;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }

    public List<Reponse> getReponses() {
        return Reponses;
    }

    public void setReponses(List<Reponse> reponses) {
        Reponses = reponses;
    }
}
