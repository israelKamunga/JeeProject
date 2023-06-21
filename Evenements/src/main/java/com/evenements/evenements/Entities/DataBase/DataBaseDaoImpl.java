package com.evenements.evenements.Entities.DataBase;

import com.evenements.evenements.Entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseDaoImpl implements DataBaseDAO{
    Connection connection = null;
    @Override
    public void AddUser(User user) throws SQLException {
            connection = DataBaseInstance.getInstance();
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO User(Name,FirstName,MailAdresse,UserPassword)" +
                            "VALUES (?,?,?,?)"
            );
            statement.setString(1,user.getNom());
            statement.setString(2,user.getPrenom());
            statement.setString(3,user.getAdresseEmail());
            statement.setString(4,user.getMotDePasse());
            statement.execute();
            connection.close();

    }

    @Override
    public void AddEvent(Evenment evenment) throws SQLException {
            connection = DataBaseInstance.getInstance();
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Evenment(Description,EvenmentDate,Hours,location,capacity,OWNER,titre)" +
                            "VALUES (?,?,?,?,?,?,?)"
            );
            statement.setString(1,evenment.getDescription());
            statement.setDate(2,evenment.getDate());
            statement.setTime(3,evenment.getTime());
            statement.setString(4,evenment.getLieu());
            statement.setInt(5,evenment.getCapacite());
            statement.setInt(6,evenment.getIdUser());
            statement.setString(7,evenment.getTitre());
            statement.execute();
            connection.close();
    }

    @Override
    public void AddRegistration(Registration registration) throws SQLException {
        connection = DataBaseInstance.getInstance();
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Registration(UserId,EvenmentId)" +
                        "VALUES (?,?,?)"
        );
        statement.setInt(1,registration.getIdUser());
        statement.setInt(2,registration.getIdEvent());
        statement.execute();
        connection.close();
    }

    @Override
    public void AddShare(Partage partage) throws SQLException {
        connection = DataBaseInstance.getInstance();
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Share(EvenmentId,SocialNetworkId,UserOwnerId)" +
                        "VALUES (?,?,?)"
        );
        statement.setInt(1,partage.getIdEvent());
        statement.setInt(2,partage.getIdReseauSocial());
        statement.setInt(3,partage.getIdPartage());
        statement.execute();
        connection.close();
    }

    @Override
    public void AddSocialNetwork(ReseauSocial reseauSocial) throws SQLException {
        connection = DataBaseInstance.getInstance();
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO SocialNetwork(ACCOUNT,Identifier,SocialNetworkPassword,UserOwner)" +
                        "VALUES (?,?,?,?)"
        );
        statement.setString(1,reseauSocial.getNom());
        statement.setString(2,reseauSocial.getIdentifiant());
        statement.setString(3,reseauSocial.getPassword());
        statement.setInt(4,reseauSocial.getUser());
        statement.execute();
        connection.close();
    }

    @Override
    public User getUserByUserAddressMail(String adresseMail) throws SQLException {
        User user;
        connection = DataBaseInstance.getInstance();
        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT  * from User where MailAdresse=?");
        preparedStatement.setString(1,adresseMail);
        ResultSet resultSet = preparedStatement.executeQuery() ;//statement.executeQuery("SELECT * from User where MailAdresse="+adresseMail);

        while(resultSet.next()){
            user = new User();
            user.setIdUser(resultSet.getInt("UserId"));
            user.setNom(resultSet.getString("Name"));
            user.setPrenom(resultSet.getString("FirstName"));
            user.setAdresseEmail(resultSet.getString("MailAdresse"));
            user.setMotDePasse(resultSet.getString("UserPassword"));
            return user;
        }
        connection.close();
        return null;
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        connection = DataBaseInstance.getInstance();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from User");
        while(resultSet.next()){
            User user = new User();
            user.setIdUser(resultSet.getInt("UserId"));
            user.setNom(resultSet.getString("Name"));
            user.setPrenom(resultSet.getString("FirstName"));
            user.setAdresseEmail(resultSet.getString("MailAdresse"));

            users.add(user);
        }
        connection.close();
        return users;
    }

    @Override
    public List<Evenment> getEventByDescription(String description) throws SQLException {
        List<Evenment> evenments = new ArrayList<>();
        connection = DataBaseInstance.getInstance();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from Evenment where Description LIKE '%'"+description+"'%'");

        while(resultSet.next()){
            Evenment evenment = new Evenment();
            evenment.setIdEvent(resultSet.getInt("EvenmentId"));
            evenment.setDescription(resultSet.getString("Description"));
            evenment.setDate(resultSet.getDate("EvenmentDate"));
            evenment.setTime(resultSet.getTime("Hours"));
            evenment.setLieu(resultSet.getString("location"));
            evenment.setCapacite(resultSet.getInt("capacity"));
            evenment.setIdUser(resultSet.getInt("OWNER"));
            evenment.setTitre(resultSet.getString("titre"));
            evenments.add(evenment);
        }
        connection.close();
        return evenments;
    }

    @Override
    public List<Evenment> getEventByLocation(String location) throws SQLException {
        List<Evenment> evenments = new ArrayList<>();
        connection = DataBaseInstance.getInstance();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from Evenment where Description LIKE '%'"+location+"'%'");

        while(resultSet.next()){
            Evenment evenment = new Evenment();
            evenment.setIdEvent(resultSet.getInt("EvenmentId"));
            evenment.setDescription(resultSet.getString("Description"));
            evenment.setDate(resultSet.getDate("EvenmentDate"));
            evenment.setTime(resultSet.getTime("Hours"));
            evenment.setLieu(resultSet.getString("location"));
            evenment.setCapacite(resultSet.getInt("capacity"));
            evenment.setIdUser(resultSet.getInt("OWNER"));
            evenment.setTitre(resultSet.getString("titre"));
            evenments.add(evenment);
        }
        connection.close();
        return evenments;
    }

    @Override
    public List<Evenment> getAllEvents() throws SQLException {
        List<Evenment> evenments = new ArrayList<>();
        connection = DataBaseInstance.getInstance();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from Evenment");

        while(resultSet.next()){
            Evenment evenment = new Evenment();
            evenment.setIdEvent(resultSet.getInt("EvenmentId"));
            evenment.setDescription(resultSet.getString("Description"));
            evenment.setDate(resultSet.getDate("EvenmentDate"));
            evenment.setTime(resultSet.getTime("Hours"));
            evenment.setLieu(resultSet.getString("location"));
            evenment.setCapacite(resultSet.getInt("capacity"));
            evenment.setIdUser(resultSet.getInt("OWNER"));
            evenment.setTitre(resultSet.getString("titre"));
            evenments.add(evenment);
        }
        connection.close();
        return evenments;
    }

    @Override
    public List<Registration> getRegistrationByUser(User user) throws SQLException {
        List<Registration> registrations = new ArrayList<>();
        connection = DataBaseInstance.getInstance();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from Registration where UserId ="+user.getIdUser());

        while(resultSet.next()){
            Registration registration = new Registration();
            registration.setIdRegistration(resultSet.getInt("RegistrationId"));
            registration.setIdUser(resultSet.getInt("UserId"));
            registration.setIdEvent(resultSet.getInt("EvenmentId"));
            registrations.add(registration);
        }
        connection.close();
        return registrations;
    }

    @Override
    public List<Registration> getRegistrationByEvent(Evenment evenment) throws SQLException {
        List<Registration> registrations = new ArrayList<>();
        connection = DataBaseInstance.getInstance();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from Registration where  EvenmentiD ="+evenment.getIdEvent());

        while(resultSet.next()){
            Registration registration = new Registration();
            registration.setIdRegistration(resultSet.getInt("RegistrationId"));
            registration.setIdUser(resultSet.getInt("UserId"));
            registration.setIdEvent(resultSet.getInt("EvenmentId"));
            registrations.add(registration);
        }
        connection.close();
        return registrations;
    }

    @Override
    public List<Partage> getSharingByUser(User user) throws SQLException {
        /*List<Partage> sharings = new ArrayList<>();
        connection = DataBaseInstance.getInstance();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from Share where UserOwnerId ="+user.getIdUser());

        while(resultSet.next()){
            Partage share = new Partage();
            share.getEvenment().setIdEvent(resultSet.getInt("EvenmentId"));
            share.getReseauSocial().setIdReseaSocial(resultSet.getInt("SocialNetworkId"));
            share.get
            registrations.add(registration);
        }
        connection.close();
        return registrations;*/
        return null;
    }

    @Override
    public List<Partage> getSharingByEvent(Evenment evenment) throws SQLException {
        List<Partage> sharings = new ArrayList<>();
        connection = DataBaseInstance.getInstance();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from Share where EvenmentId ="+evenment.getIdEvent());

        while(resultSet.next()){
            Partage share = new Partage();
            share.setIdEvent(resultSet.getInt("EvenmentId"));
            share.setIdReseauSocial(resultSet.getInt("SocialNetworkId"));
            share.setUserOwner(resultSet.getInt("UserOwnerId"));
            sharings.add(share);
        }
        connection.close();
        return sharings;
    }

    @Override
    public ReseauSocial getSocialNetworkByUser(User user) throws SQLException {
        ReseauSocial reseauSocial;
        connection = DataBaseInstance.getInstance();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from SocialNetwork where UserOwnerId ="+user.getIdUser());

        while(resultSet.next()){
            reseauSocial = new ReseauSocial();
            reseauSocial.setIdReseaSocial(resultSet.getInt("SocialNetworkId"));
            reseauSocial.setNom(resultSet.getString("account"));
            reseauSocial.setIdentifiant(resultSet.getString("Identifier"));
            reseauSocial.setPassword(resultSet.getString("SocialNetworkPassword"));
            reseauSocial.setUser(resultSet.getInt("UserOwnerId"));
            return reseauSocial;
        }
        connection.close();
        return null;
    }

    @Override
    public List<ReseauSocial> getAllSocialNetwork() throws SQLException {
        List<ReseauSocial> reseauSocials = new ArrayList<>();
        connection = DataBaseInstance.getInstance();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from SocialNetwork");

        while(resultSet.next()){
            ReseauSocial reseauSocial = new ReseauSocial();
            reseauSocial.setIdReseaSocial(resultSet.getInt("SocialNetworkId"));
            reseauSocial.setNom(resultSet.getString("account"));
            reseauSocial.setIdentifiant(resultSet.getString("Identifier"));
            reseauSocial.setPassword(resultSet.getString("SocialNetworkPassword"));
            reseauSocial.setUser(resultSet.getInt("UserOwnerId"));

            reseauSocials.add(reseauSocial);
        }
        connection.close();
        return reseauSocials;
    }

    @Override
    public boolean UpdateUser(String EmailAdress, User user) throws SQLException {
        connection = DataBaseInstance.getInstance();

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE User SET Name="+user.getNom()+" FirstName="+user.getPrenom()+" MailAdresse="+user.getAdresseEmail()+" UserPassword="+user.getMotDePasse()+" where MailAdresse="+EmailAdress);
        connection.close();
        return preparedStatement.execute();
    }

    @Override
    public boolean UpdateEvent(int id, Evenment evenment) throws SQLException {
        connection = DataBaseInstance.getInstance();

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE evenment SET Description="+evenment.getDescription()+" EvenmentDate="+evenment.getDate()+" Hours="+evenment.getTime()+" location="+evenment.getLieu()+" capacity="+evenment.getCapacite()+" where EvenmentId="+id);
        connection.close();
        return preparedStatement.execute();
    }

    @Override
    public boolean updateSocialNetwork(int id, ReseauSocial reseauSocial) throws SQLException {
        connection = DataBaseInstance.getInstance();

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE SocialNetwork SET Account="+reseauSocial.getNom()+" Identifier="+reseauSocial.getCompte()+" SocialNetworkPassword="+reseauSocial.getPassword());
        connection.close();
        return preparedStatement.execute();
    }

    @Override
    public boolean DeleteUser(String EmailAdress) throws SQLException {
        connection = DataBaseInstance.getInstance();

        PreparedStatement preparedStatement = connection.prepareStatement("DELETE * From User where MailAdresse="+EmailAdress);
        connection.close();
        return preparedStatement.execute();
    }

    @Override
    public boolean DeleteEvent(int id) throws SQLException {
        connection = DataBaseInstance.getInstance();

        PreparedStatement preparedStatement = connection.prepareStatement("DELETE * From Evenment where EvenmentId="+id);
        connection.close();
        return preparedStatement.execute();
    }

    @Override
    public boolean DeleteRegistration(int id) throws SQLException {
        connection = DataBaseInstance.getInstance();

        PreparedStatement preparedStatement = connection.prepareStatement("DELETE * From Registration where RegistrationId="+id);
        connection.close();
        return preparedStatement.execute();
    }

    @Override
    public boolean DeleteSocialNetwork(int id) throws SQLException {
        connection = DataBaseInstance.getInstance();

        PreparedStatement preparedStatement = connection.prepareStatement("DELETE * From SocialNetwork where SocialNetworkId="+id);
        connection.close();
        return preparedStatement.execute();
    }
}
