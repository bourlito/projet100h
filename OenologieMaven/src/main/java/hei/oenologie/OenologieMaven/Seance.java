package hei.oenologie.OenologieMaven;

import java.util.Date;

/**
 * Created by etienne on 05/12/2017.
 */

public class Seance {
    private int Id_seance;
    private String Libelle;
    private java.util.Date Date;
    private String Informations;
    private int Code_quizz;

    public Seance(int id_seance, String libelle, Date date, String informations, int code_quizz){
    this.Id_seance=id_seance;
    this.Libelle=libelle;
    this.Date=date;
    this.Informations=informations;
    this.Code_quizz=code_quizz;
    }

    public int getId_seance() {
        return Id_seance;
    }

    public void setId_seance(int id_seance) {
        Id_seance = id_seance;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public String getInformations() {
        return Informations;
    }

    public void setInformations(String informations) {
        Informations = informations;
    }

    public int getCode_quizz() {
        return Code_quizz;
    }

    public void setCode_quizz(int code_quizz) {
        Code_quizz = code_quizz;
    }
}
