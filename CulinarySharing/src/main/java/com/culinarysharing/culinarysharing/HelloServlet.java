package com.culinarysharing.culinarysharing;

import com.culinarysharing.culinarysharing.Entities.Utilisateur;
import com.culinarysharing.culinarysharing.Model.DaoImplementation;

import java.io.*;
import java.sql.SQLException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        DaoImplementation DAO = new DaoImplementation();
        Utilisateur utilisateur;
        try {
            utilisateur = DAO.getUser(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + utilisateur.getNomUtilisateur() + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}