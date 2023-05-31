package com.culinarysharing.culinarysharing.Entities;

public class Question {
    private int idQuestion;
    private Utilisateur auteur;
    private Recette recette;
    private String question;

    //CONSTRUCTEUR

    public Question(){}
    public Question(int idQuestion,Utilisateur auteur,Recette recette,String question){
        this.idQuestion = idQuestion;
        this.auteur = auteur;
        this.recette = recette;
        this.question = question;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
