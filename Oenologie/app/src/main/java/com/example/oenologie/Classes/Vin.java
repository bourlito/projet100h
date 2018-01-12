package com.example.oenologie.Classes;

/**
 * Created by etienne on 05/12/2017.
 */

public class Vin {
    private int Id_vin;
    private String Appellation;
    private String Libelle;
    private String Informations;

    public Vin(int id_vin, String appellation, String libelle, String informations) {
        this.Id_vin = id_vin;
        this.Appellation = appellation;
        this.Libelle = libelle;
        this.Informations = informations;
    }

    public int getId_vin() {
        return Id_vin;
    }

    public void setId_vin(int id_vin) {
        Id_vin = id_vin;
    }

    public String getAppellation() {
        return Appellation;
    }

    public void setAppellation(String appellation) {
        Appellation = appellation;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }

    public String getInformations() {
        return Informations;
    }

    public void setInformations(String informations) {
        Informations = informations;
    }
}
