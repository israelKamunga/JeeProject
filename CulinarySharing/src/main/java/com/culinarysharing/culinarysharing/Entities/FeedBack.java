package com.culinarysharing.culinarysharing.Entities;

public class FeedBack {
    private int idFeedback;
    private Utilisateur auteur;
    private Recette recette;
    private String commentaire;
    private int note;


    public FeedBack(){}
    public FeedBack(int idFeedback,Utilisateur auteur,Recette recette,String commentaire,int note){
        this.idFeedback = idFeedback;
        this.auteur = auteur;
        this.recette = recette;
        this.commentaire = commentaire;
        this.note = note;
    }

    public int getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(int idFeedback) {
        this.idFeedback = idFeedback;
    }

    public Utilisateur getAuteur() {
        return auteur;
    }

    public void setAuteur(Utilisateur auteur) {
        this.auteur = auteur;
    }

    public Recette getRecette() {
        return recette;
    }

    public void setRecette(Recette recette) {
        this.recette = recette;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
