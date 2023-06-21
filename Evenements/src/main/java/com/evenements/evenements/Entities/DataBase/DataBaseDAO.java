package com.evenements.evenements.Entities.DataBase;

import com.evenements.evenements.Entities.*;

import java.sql.SQLException;
import java.util.List;

public interface DataBaseDAO {
    //CREATE
    public void AddUser(User user) throws SQLException;
    public void AddEvent(Evenment evenment) throws SQLException;
    public void AddRegistration(Registration registration) throws SQLException;
    public void AddShare(Partage partage) throws SQLException;
    public void AddSocialNetwork(ReseauSocial reseauSocial) throws SQLException;

    //READ
    //USER
    public User getUserByUserAddressMail(String adresseMail) throws SQLException;
    public List<User> getAllUsers() throws SQLException;
    //EVENT
    public List<Evenment> getEventByDescription(String description) throws SQLException;
    public List<Evenment> getEventByLocation(String location) throws SQLException;
    public List<Evenment> getAllEvents() throws SQLException;
    //REGISTRATION
    public List<Registration> getRegistrationByUser(User user) throws SQLException;
    public List<Registration> getRegistrationByEvent(Evenment evenment) throws SQLException;
    //SHARE
    public List<Partage> getSharingByUser(User user) throws SQLException;
    public List<Partage> getSharingByEvent(Evenment evenment) throws SQLException;
    //SOCIALNETWORK
    public ReseauSocial getSocialNetworkByUser(User user) throws SQLException;
    public List<ReseauSocial> getAllSocialNetwork() throws SQLException;

    //UPDATE
    public boolean UpdateUser(String EmailAdress,User user) throws SQLException;
    public boolean UpdateEvent(int id,Evenment evenment) throws SQLException;
    public boolean updateSocialNetwork(int id,ReseauSocial reseauSocial) throws SQLException;

    //DELETE
    public boolean DeleteUser(String EmailAdress) throws SQLException;
    public boolean DeleteEvent(int id) throws SQLException;
    public boolean DeleteRegistration(int id) throws SQLException;
    public boolean DeleteSocialNetwork(int id) throws SQLException;

}
