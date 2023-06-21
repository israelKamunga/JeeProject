package com.evenements.evenements;

import com.evenements.evenements.Entities.DataBase.DataBaseDaoImpl;
import com.evenements.evenements.Entities.User;

import java.io.*;
import java.sql.SQLException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class controller1 extends HttpServlet {
    private String message;

    public void init() {
        message = "no";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        User user = new User();
        user.setNom(request.getParameter("nom"));
        user.setPrenom(request.getParameter("prenom"));
        user.setAdresseEmail(request.getParameter("adresseMail"));
        user.setMotDePasse(request.getParameter("Password"));

        DataBaseDaoImpl database = new DataBaseDaoImpl();
        try {
            database.AddUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String query = "index.jsp?EmailAdress="+user.getAdresseEmail()+"&Password="+user.getMotDePasse();
        response.sendRedirect(query);
    }

    public void destroy() {
    }
}