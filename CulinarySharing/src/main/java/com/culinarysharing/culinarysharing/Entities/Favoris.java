package com.culinarysharing.culinarysharing.Entities;

public class Favoris {
    private int idFavoris;
    private Recette recette;
    private Utilisateur auteur;

    public Favoris(){}
    public Favoris(int idFavoris,Recette recette,Utilisateur auteur){
        this.idFavoris = idFavoris;
        this.recette = recette;
        this.auteur = auteur;
    }

    public int getIdFavoris() {
        return idFavoris;
    }

    public void setIdFavoris(int idFavoris) {
        this.idFavoris = idFavoris;
    }

    public Recette getRecette() {
        return recette;
    }

    public void setRecette(Recette recette) {
        this.recette = recette;
    }

    public Utilisateur getAuteur() {
        return auteur;
    }

    public void setAuteur(Utilisateur auteur) {
        this.auteur = auteur;
    }
}
