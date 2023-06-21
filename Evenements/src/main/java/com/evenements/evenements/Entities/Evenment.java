package com.evenements.evenements.Entities;

import java.sql.Date;
import java.sql.Time;

public class Evenment {
    private int IdEvent;

    private String titre;
    private String description;
    private Date date;
    private Time time;
    private String lieu;
    private int capacite;

    private int idUser;

    //initilizer constructor
    public Evenment(){}

    public Evenment(int IdEvent,String titre,String description, Date date, Time time, String lieu, int capacite,int idUser){
        this.titre = titre;
        this.IdEvent = IdEvent;
        this.description = description;
        this.date = date;
        this.time = time;
        this.lieu = lieu;
        this.capacite = capacite;
        this.idUser = idUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public int getIdEvent() {
        return IdEvent;
    }

    public void setIdEvent(int idEvent) {
        IdEvent = idEvent;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
