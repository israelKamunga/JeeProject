package com.culinarysharing.culinarysharing.Entities;

public class Utilisateur {
    private int idUtilisateur;
    private String nomUtilisateur;
    private String postnomUtilisateur;
    private String motdepasse;

    //CONSTRUCTEUR
    public Utilisateur(){}
    public Utilisateur(int idUtilisateur,String nomUtilisateur,String postnomUtilisateur,String motdepasse){
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.postnomUtilisateur = postnomUtilisateur;
        this.motdepasse = motdepasse;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getPostnomUtilisateur() {
        return postnomUtilisateur;
    }

    public void setPostnomUtilisateur(String postnomUtilisateur) {
        this.postnomUtilisateur = postnomUtilisateur;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

}
