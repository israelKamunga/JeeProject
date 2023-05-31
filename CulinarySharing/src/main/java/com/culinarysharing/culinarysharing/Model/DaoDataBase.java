package com.culinarysharing.culinarysharing.Model;

import com.culinarysharing.culinarysharing.Entities.*;

import java.sql.SQLException;
import java.util.List;

public interface DaoDataBase {
    //CREATE
    public boolean CreateUser(Utilisateur utilisateur) throws SQLException;
    public  boolean CreateRecette(Recette recette) throws SQLException;
    public boolean CreateFeedback(FeedBack feedBack) throws SQLException;
    public boolean CreateQuestion(Question question) throws SQLException;
    public boolean CreateFavoris(Favoris favoris) throws SQLException;

    //READ
        //UTILISATEUR
    public Utilisateur getUser(int id) throws SQLException;
    public List<Utilisateur> getUsers() throws SQLException;
        //RECETTE
    public Recette getRecette(int id) throws SQLException;
    public List<Recette> getRecettes() throws SQLException;
        //FEEDBACK
    public FeedBack getFeedback(int id) throws SQLException;
    public List<FeedBack> getFeedbacks() throws SQLException;
        //QUESTION
    public Question getQuestion(int id) throws SQLException;
    public List<Question> getQuestions() throws SQLException;
        //FAVORIS
    public Favoris getFavoris(int id) throws SQLException;
    public List<Favoris> getFavoris() throws SQLException;

    //UPDATE
        //UTILISATEUR
    public boolean updateUser(int id,Utilisateur utilisateur) throws SQLException;
        //RECETTE
    public boolean updateRecette(int id,Recette recette) throws SQLException;
        //FEEDBACK
    public boolean updateFeedback(int id,FeedBack feedBack) throws SQLException;
        //QUESTION
    public boolean updateQuestion(int id,Question question) throws SQLException;
        //FAVORIS
    public boolean updateFavoris(int id,Favoris favoris) throws SQLException;

    //DELETE
        //UTILISATEUR
    public boolean deleteUser(int id) throws SQLException;
        //RECETTE
    public boolean deleteRecette(int id) throws SQLException;
        //FEEDBACK
    public  boolean deleteFeedBack(int id) throws SQLException;
        //QUESTION
    public boolean deleteQuestion(int id) throws SQLException;
        //FAVORIS
    public  boolean deleteFavoris(int id) throws SQLException;
}
