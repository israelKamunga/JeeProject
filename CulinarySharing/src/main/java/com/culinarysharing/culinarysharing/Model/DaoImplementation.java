package com.culinarysharing.culinarysharing.Model;

import com.culinarysharing.culinarysharing.Entities.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoImplementation implements DaoDataBase{


    @Override
    public boolean CreateUser(Utilisateur utilisateur) throws SQLException {

        Connection connection = DataBase.getInstance();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Utilisateur(nomUtilisateur,postnomUtilisateur,motdepasse) values (?,?,?)");
        statement.setString(1,utilisateur.getNomUtilisateur());
        statement.setString(2,utilisateur.getPostnomUtilisateur());
        statement.setString(3,utilisateur.getMotdepasse());

        boolean succes = statement.execute();
        connection.close();
        return succes==true?true:false;
    }


    @Override
    public boolean CreateRecette(Recette recette) throws SQLException {
        Connection connection = DataBase.getInstance();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Recette(nomRecette,ingredients,instructions,categorie,niveauDifficulte,TempsDePreparation,lienPhoto,auteur) values(?,?,?,?,?,?,?,?)");
        statement.setString(1,recette.getTitreRecette());
        statement.setString(2,recette.getIngredientsRecette());
        statement.setString(3,recette.getInstructions());
        statement.setString(4,recette.getCategorie());
        statement.setString(5,recette.getNiveauDifficulte());
        statement.setTime(6,recette.getTempsPreparation());
        statement.setString(7,recette.getLienPhoto());
        statement.setInt(8,recette.getAuteur().getIdUtilisateur());

        boolean succes = statement.execute();
        connection.close();
        return succes==true?true:false;
    }

    @Override
    public boolean CreateFeedback(FeedBack feedBack) throws SQLException {
        Connection connection = DataBase.getInstance();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO feedbacks(auteur,recette,commentaire,note) values (?,?,?,?)");
        statement.setInt(1,feedBack.getAuteur().getIdUtilisateur());
        statement.setInt(2,feedBack.getRecette().getIdRecette());
        statement.setString(3,feedBack.getCommentaire());
        statement.setInt(4,feedBack.getNote());

        boolean succes = statement.execute();
        connection.close();
        return succes==true?true:false;
    }

    @Override
    public boolean CreateQuestion(Question question) throws SQLException {
        Connection connection = DataBase.getInstance();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO question(auteur,recette,question) values (?,?,?)");
        statement.setInt(1,question.getAuteur().getIdUtilisateur());
        statement.setInt(2,question.getRecette().getIdRecette());
        statement.setString(3,question.getQuestion());

        boolean succes = statement.execute();
        connection.close();
        return succes==true?true:false;
    }

    @Override
    public boolean CreateFavoris(Favoris favoris) throws SQLException {
        Connection connection = DataBase.getInstance();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Utilisateur(recette,auteur) values (?,?)");
        statement.setInt(1,favoris.getRecette().getIdRecette());
        statement.setInt(2,favoris.getAuteur().getIdUtilisateur());

        boolean succes = statement.execute();
        connection.close();
        return succes==true?true:false;
    }

    @Override
    public Utilisateur getUser(int id) throws SQLException {
        Utilisateur utilisateur = new Utilisateur();
        Connection connection = DataBase.getInstance();
        PreparedStatement statement = connection.prepareStatement("SELECT * from Utilisateur where idUtilisateur=?");
        statement.setInt(1,id);

        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()){
            utilisateur.setIdUtilisateur(resultSet.getInt("idUtilisateur"));
            utilisateur.setNomUtilisateur(resultSet.getString("nomUtilisateur"));
            utilisateur.setPostnomUtilisateur(resultSet.getString("postnomUtilisateur"));
            utilisateur.setMotdepasse(resultSet.getString("motdepasse"));
        }
        connection.close();
        return utilisateur;

    }

    @Override
    public List<Utilisateur> getUsers() throws SQLException {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        Connection connection = DataBase.getInstance();
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * from utilisateur");
        while(resultSet.next()){
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setIdUtilisateur(resultSet.getInt("idUtilisateur"));
            utilisateur.setNomUtilisateur(resultSet.getString("nomUtilisateur"));
            utilisateur.setPostnomUtilisateur(resultSet.getString("postnomUtilisateur"));
            utilisateur.setMotdepasse(resultSet.getString("motdepasse"));

            utilisateurs.add(utilisateur);
        }
        connection.close();
        return utilisateurs;
    }

    @Override
    public Recette getRecette(int id) throws SQLException {
        Recette recette = new Recette();
        Connection connection = DataBase.getInstance();
        PreparedStatement statement = connection.prepareStatement("SELECT * from recette where idRecette=?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            recette.setIdRecette(resultSet.getInt("idRecette"));
            recette.setTitreRecette(resultSet.getString("nomRecette"));
            recette.setIngredientsRecette(resultSet.getString("ingredients"));
            recette.setInstructions(resultSet.getString("instructions"));
            recette.setCategorie(resultSet.getString("categorie"));
            recette.setNiveauDifficulte(resultSet.getString("niveauDifficulte"));
            recette.setTempsPreparation(resultSet.getTime("TempsDePreparation"));
            recette.setLienPhoto(resultSet.getString("lienPhoto"));
            recette.getAuteur().setIdUtilisateur(resultSet.getInt("auteur"));
        }

        connection.close();

        return recette;
    }

    @Override
    public List<Recette> getRecettes() throws SQLException {
        List<Recette> recettes = new ArrayList<>();
        Connection connection = DataBase.getInstance();
        PreparedStatement statement = connection.prepareStatement("SELECT * from recette");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            Recette recette = new Recette();

            recette.setIdRecette(resultSet.getInt("idRecette"));
            recette.setTitreRecette(resultSet.getString("nomRecette"));
            recette.setIngredientsRecette(resultSet.getString("ingredients"));
            recette.setInstructions(resultSet.getString("instructions"));
            recette.setCategorie(resultSet.getString("categorie"));
            recette.setNiveauDifficulte(resultSet.getString("niveauDifficulte"));
            recette.setTempsPreparation(resultSet.getTime("TempsDePreparation"));
            recette.setLienPhoto(resultSet.getString("lienPhoto"));
            recette.getAuteur().setIdUtilisateur(resultSet.getInt("auteur"));

            recettes.add(recette);
        }

        connection.close();

        return recettes;
    }

    @Override
    public FeedBack getFeedback(int id) throws SQLException {
        FeedBack feedback = new FeedBack();
        Connection connection = DataBase.getInstance();
        PreparedStatement statement = connection.prepareStatement("SELECT * from feedbacks where idFeedback=?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            feedback.setIdFeedback(resultSet.getInt("idFeedback"));
            feedback.getAuteur().setIdUtilisateur(resultSet.getInt("auteur"));
            feedback.getRecette().setIdRecette(resultSet.getInt("recette"));
            feedback.setCommentaire(resultSet.getString("commentaires"));
            feedback.setNote(resultSet.getInt("note"));
        }

        connection.close();

        return feedback;
    }

    @Override
    public List<FeedBack> getFeedbacks() throws SQLException {
        List<FeedBack> feedBacks = new ArrayList<>();
        Connection connection = DataBase.getInstance();
        PreparedStatement statement = connection.prepareStatement("SELECT * from feedbacks");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            FeedBack feedback = new FeedBack();
            feedback.setIdFeedback(resultSet.getInt("idFeedback"));
            feedback.getAuteur().setIdUtilisateur(resultSet.getInt("auteur"));
            feedback.getRecette().setIdRecette(resultSet.getInt("recette"));
            feedback.setCommentaire(resultSet.getString("commentaires"));
            feedback.setNote(resultSet.getInt("note"));

            feedBacks.add(feedback);
        }

        connection.close();

        return feedBacks;
    }

    @Override
    public Question getQuestion(int id) throws SQLException {
        Question question = new Question();
        Connection connection = DataBase.getInstance();
        PreparedStatement statement = connection.prepareStatement("SELECT * from question where idQuestion=?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            question.setIdQuestion(resultSet.getInt("idQuestion"));
            question.getAuteur().setIdUtilisateur(resultSet.getInt("auteur"));
            question.getRecette().setIdRecette(resultSet.getInt("recette"));
            question.setQuestion(resultSet.getString("question"));
        }

        connection.close();

        return question;
    }

    @Override
    public List<Question> getQuestions() throws SQLException {
        List<Question> questions = new ArrayList<>();
        Connection connection = DataBase.getInstance();
        PreparedStatement statement = connection.prepareStatement("SELECT * from question");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            Question question = new Question();
            question.setIdQuestion(resultSet.getInt("idQuestion"));
            question.getAuteur().setIdUtilisateur(resultSet.getInt("auteur"));
            question.getRecette().setIdRecette(resultSet.getInt("recette"));
            question.setQuestion(resultSet.getString("question"));

            questions.add(question);
        }

        connection.close();

        return questions;
    }

    @Override
    public Favoris getFavoris(int id) throws SQLException {
        Favoris favoris = new Favoris();
        Connection connection = DataBase.getInstance();
        PreparedStatement statement = connection.prepareStatement("SELECT * from favoris where idFavoris=?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            favoris.setIdFavoris(resultSet.getInt("idFavoris"));
            favoris.getRecette().setIdRecette(resultSet.getInt("recette"));
            favoris.getAuteur().setIdUtilisateur(resultSet.getInt("auteur"));
        }

        connection.close();

        return favoris;
    }

    @Override
    public List<Favoris> getFavoris() throws SQLException {
        List<Favoris> favorisList = new ArrayList<>();
        Connection connection = DataBase.getInstance();
        PreparedStatement statement = connection.prepareStatement("SELECT * from favoris");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            Favoris favoris = new Favoris();
            favoris.setIdFavoris(resultSet.getInt("idFavoris"));
            favoris.getRecette().setIdRecette(resultSet.getInt("recette"));
            favoris.getAuteur().setIdUtilisateur(resultSet.getInt("auteur"));

            favorisList.add(favoris);
        }

        connection.close();

        return favorisList;
    }

    @Override
    public boolean updateUser(int id, Utilisateur utilisateur) throws SQLException {
        Connection connection = DataBase.getInstance();
        PreparedStatement statement = connection.prepareStatement("UPDATE Utilisateur SET nomUtilisateur=?, postnomUtilisateur=?, motdepasse=? where idUtilisateur=?");
        statement.setString(1,utilisateur.getNomUtilisateur());
        statement.setString(2,utilisateur.getPostnomUtilisateur());
        statement.setString(3,utilisateur.getMotdepasse());
        statement.setInt(4,id);

        boolean succes = statement.execute();
        statement.close();
        return succes==true?true:false;
    }

    @Override
    public boolean updateRecette(int id, Recette recette) throws SQLException {
        Connection connection = DataBase.getInstance();
        PreparedStatement statement = connection.prepareStatement("UPDATE recette SET nomRecette=?,ingredients=?,instructions=?,categorie=?,niveauDifficulte=?,TempsDePreparation=?,lienPhoto=?,auteur=? where idRecette=?");
        statement.setString(1,recette.getTitreRecette());
        statement.setString(2,recette.getIngredientsRecette());
        statement.setString(3,recette.getInstructions());
        statement.setString(4,recette.getCategorie());
        statement.setString(5,recette.getNiveauDifficulte());
        statement.setTime(6,recette.getTempsPreparation());
        statement.setString(7,recette.getLienPhoto());
        statement.setInt(8,recette.getAuteur().getIdUtilisateur());
        boolean succes = statement.execute();

        connection.close();

        return succes==true?true:false;
    }

    @Override
    public boolean updateFeedback(int id, FeedBack feedBack) throws SQLException {
        Connection connection = DataBase.getInstance();
        PreparedStatement statement = connection.prepareStatement("UPDATE feedbacks SET auteur=?, recette=?,commentaire=?,note where idFeedbacks=?");
        statement.setInt(1,feedBack.getAuteur().getIdUtilisateur());
        statement.setInt(2,feedBack.getRecette().getIdRecette());
        statement.setString(3,feedBack.getCommentaire());
        statement.setInt(4,feedBack.getNote());

        boolean succes = statement.execute();

        statement.close();

        return succes==true?true:false;
    }

    @Override
    public boolean updateQuestion(int id, Question question) throws SQLException {
        Connection connection = DataBase.getInstance();
        PreparedStatement statement = connection.prepareStatement("UPDATE question SET auteur=?,recette=?,question=? where idQuestion=?");
        statement.setInt(1,question.getAuteur().getIdUtilisateur());
        statement.setInt(2,question.getRecette().getIdRecette());
        statement.setString(3,question.getQuestion());

        boolean succes = statement.execute();

        statement.close();

        return succes==true?true:false;
    }

    @Override
    public boolean updateFavoris(int id, Favoris favoris) throws SQLException {
        Connection connection = DataBase.getInstance();
        PreparedStatement statement = connection.prepareStatement("UPDATE favoris SET recette=?, auteur=? where idFavoris=?");
        statement.setInt(1,favoris.getRecette().getIdRecette());
        statement.setInt(2,favoris.getAuteur().getIdUtilisateur());


        boolean succes = statement.execute();

        statement.close();

        return succes==true?true:false;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        Connection connection = DataBase.getInstance();
        PreparedStatement statement = connection.prepareStatement("DELETE * from Utilisateur where idUtilisateur=?");
        statement.setInt(1,id);

        boolean succes = statement.execute();

        statement.close();

        return succes==true?true:false;
    }

    @Override
    public boolean deleteRecette(int id) throws SQLException {
        Connection connection = DataBase.getInstance();
        PreparedStatement statement = connection.prepareStatement("DELETE * from Recette where idRecette=?");
        statement.setInt(1,id);

        boolean succes = statement.execute();

        statement.close();

        return succes==true?true:false;
    }

    @Override
    public boolean deleteFeedBack(int id) throws SQLException {
        Connection connection = DataBase.getInstance();
        PreparedStatement statement = connection.prepareStatement("DELETE * from Feedbacks where idFeedback=?");
        statement.setInt(1,id);

        boolean succes = statement.execute();

        statement.close();

        return succes==true?true:false;
    }

    @Override
    public boolean deleteQuestion(int id) throws SQLException {
        Connection connection = DataBase.getInstance();
        PreparedStatement statement = connection.prepareStatement("DELETE * from Question where idQuestion=?");
        statement.setInt(1,id);

        boolean succes = statement.execute();

        statement.close();

        return succes==true?true:false;
    }

    @Override
    public boolean deleteFavoris(int id) throws SQLException {
        Connection connection = DataBase.getInstance();
        PreparedStatement statement = connection.prepareStatement("DELETE * from Utilisateur where idFavoris=?");
        statement.setInt(1,id);

        boolean succes = statement.execute();

        statement.close();

        return succes==true?true:false;
    }
}
