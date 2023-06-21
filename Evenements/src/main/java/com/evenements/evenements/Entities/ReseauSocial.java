package com.evenements.evenements.Entities;

public class ReseauSocial {
    private int IdReseaSocial;
    private String nom;
    private String compte;
    private String identifiant;
    private String password;
    private int idUser;

    //initializer constructor
    public ReseauSocial(){}

    public ReseauSocial(String nom,String compte,String identifiant,String password,int idUser){
        this.nom = nom;
        this.compte = compte;
        this.identifiant = identifiant;
        this.password = password;
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCompte() {
        return compte;
    }

    public void setCompte(String compte) {
        this.compte = compte;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser() {
        return idUser;
    }

    public void setUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdReseaSocial() {
        return IdReseaSocial;
    }

    public void setIdReseaSocial(int idReseaSocial) {
        IdReseaSocial = idReseaSocial;
    }
}
