package entities;

import java.util.Date;

public class Seance {
    private Integer id;
    private String libelle;
    private Date date;
    private String informtions;
    private Integer code_quizz;

    public Seance(Integer id, String libelle,Date date,String informtions,Integer code_quizz){
        this.id=id;
        this.informtions=informtions;
        this.date=date;
        this.libelle=libelle;
        this.code_quizz=code_quizz;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public Integer getCode_quizz() {
        return code_quizz;
    }

    public String getInformtions() {
        return informtions;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setCode_quizz(Integer code_quizz) {
        this.code_quizz = code_quizz;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setInformtions(String informtions) {
        this.informtions = informtions;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
