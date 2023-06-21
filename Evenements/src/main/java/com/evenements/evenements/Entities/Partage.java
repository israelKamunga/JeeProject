package com.evenements.evenements.Entities;

public class Partage {
    private int idPartage;
    private int idEvent;

    private int idReseauSocial;

    private int UserOwner;

    //initializer constructor
    public Partage(){}

    public Partage(int idEvent){
        this.idEvent = idEvent;
    }

    public int getIdPartage() {
        return idPartage;
    }

    public void setIdPartage(int idPartage) {
        this.idPartage = idPartage;
    }


    public int getIdReseauSocial() {
        return idReseauSocial;
    }

    public void setIdReseauSocial(int idReseauSocial) {
        this.idReseauSocial = idReseauSocial;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getUserOwner() {
        return UserOwner;
    }

    public void setUserOwner(int userOwner) {
        UserOwner = userOwner;
    }
}
