package com.example.oenologie.Classes;

/**
 * Created by etienne on 05/12/2017.
 */

public class Stock {
    private int Id_stock;
    private String Type;
    private String Libelle;
    private int Quantite;

    public Stock(int id_stock, String type, String libelle, int quantite) {
        this.Id_stock = id_stock;
        this.Type = type;
        this.Libelle = libelle;
        this.Quantite = quantite;
    }

    public int getId_stock() {
        return Id_stock;
    }

    public void setId_stock(int id_stock) {
        Id_stock = id_stock;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }

    public int getQuantite() {
        return Quantite;
    }

    public void setQuantite(int quantite) {
        Quantite = quantite;
    }
}
