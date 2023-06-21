<%--
  Created by IntelliJ IDEA.
  User: Isy_ART
  Date: 19/06/2023
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<link>
<head>
    <title>Connexion</title>
    <link rel="stylesheet" href="static/bootstrap.css">
    <link rel="stylesheet" href="static/bootstrap.min.css">
</head>
<body class="vh-100 d-flex justify-content-center align-items-center">
    <div class="container col-sm-5 col-10 card p-3 m-0 col-9">
        <form class="form-signin" method="get" action="controller1">
            <h1 class="h3 mb-3 text-center font-weight-normal">Inscription</h1>
            <label for="" class="sr-only">Nom</label>
            <input type="text" id="" name="nom" class="form-control" placeholder="Nom" required autofocus style="background-color: #fff; color:#333; outline-color: #EE3268;">
            <label for="" class="sr-only">Prenom</label>
            <input type="txt" id="" name="prenom" class="form-control" placeholder="Prenom" required autofocus style="background-color: #fff; color:#333; outline-color: #EE3268;">
            <label for="" class="sr-only">Adresse Mail</label>
            <input type="email" id="" name="adresseMail" class="form-control" placeholder="adresseMail" required autofocus style="background-color: #fff; color:#333; outline-color: #EE3268;">
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" maxlength="10" name="Password" class="form-control" placeholder="Password" required style="background-color: #fff; color:#333; outline-color: #EE3268;">
            <button class="btn btn-lg btn-primary btn-block w-100" type="submit" style="background-color: #EE3268; color:#fff; outline:none;border: none;margin-top: 10px;">S'inscrire</button>
        </form>
    </div>
</body>
</html>