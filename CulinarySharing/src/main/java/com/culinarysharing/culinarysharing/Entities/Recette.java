package com.culinarysharing.culinarysharing.Entities;

import java.sql.Time;

public class Recette {
    private int idRecette;
    private String titreRecette;
    private String ingredientsRecette;
    private String instructions;
    private String categorie;
    private String niveauDifficulte;
    private Time tempsPreparation;
    private String lienPhoto;
    private Utilisateur auteur;


    public Recette(){}
    public Recette(int idRecette,String titreRecette,String ingredientsRecette,String instructions,String categorie,String niveauDifficulte,Time tempsPreparation,String lienPhoto,Utilisateur auteur){
        this.idRecette = idRecette;
        this.titreRecette = titreRecette;
        this.ingredientsRecette = ingredientsRecette;
        this.instructions = instructions;
        this.categorie = categorie;
        this.niveauDifficulte = niveauDifficulte;
        this.tempsPreparation = tempsPreparation;
        this.lienPhoto = lienPhoto;
        this.auteur = auteur;
    }

    public int getIdRecette() {
        return idRecette;
    }

    public void setIdRecette(int idRecette) {
        this.idRecette = idRecette;
    }

    public String getTitreRecette() {
        return titreRecette;
    }

    public void setTitreRecette(String titreRecette) {
        this.titreRecette = titreRecette;
    }

    public String getIngredientsRecette() {
        return ingredientsRecette;
    }

    public void setIngredientsRecette(String ingredientsRecette) {
        this.ingredientsRecette = ingredientsRecette;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getNiveauDifficulte() {
        return niveauDifficulte;
    }

    public void setNiveauDifficulte(String niveauDifficulte) {
        this.niveauDifficulte = niveauDifficulte;
    }

    public Time getTempsPreparation() {
        return tempsPreparation;
    }

    public void setTempsPreparation(Time tempsPreparation) {
        this.tempsPreparation = tempsPreparation;
    }

    public String getLienPhoto() {
        return lienPhoto;
    }

    public void setLienPhoto(String lienPhoto) {
        this.lienPhoto = lienPhoto;
    }

    public Utilisateur getAuteur() {
        return auteur;
    }

    public void setAuteur(Utilisateur auteur) {
        this.auteur = auteur;
    }
}
