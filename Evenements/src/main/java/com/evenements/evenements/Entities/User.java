package com.evenements.evenements.Entities;

public class User {
    private int idUser;
    private String nom;
    private String prenom;
    private String adresseEmail;
    private String motDePasse;

    //initializer constructor
    public User(){}

    public User(String nom,String prenom, String adresseEmail, String motDePasse){
        this.nom = nom;
        this.prenom = prenom;
        this.adresseEmail = adresseEmail;
        this.motDePasse = motDePasse;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresseEmail() {
        return adresseEmail;
    }

    public void setAdresseEmail(String adresseEmail) {
        this.adresseEmail = adresseEmail;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

}
