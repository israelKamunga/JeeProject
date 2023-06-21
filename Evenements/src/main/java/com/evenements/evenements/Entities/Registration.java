package com.evenements.evenements.Entities;

public class Registration {
    private int idRegistration;
    private int idUser;
    private int idEvent;

    //initializer constructor
    public Registration(){}

    public Registration(int idUser, int idEvent){
        this.idUser = idUser;
        this.idEvent = idEvent;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getIdRegistration() {
        return idRegistration;
    }

    public void setIdRegistration(int idRegistration) {
        this.idRegistration = idRegistration;
    }
}
