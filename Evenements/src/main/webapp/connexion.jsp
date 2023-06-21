<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<link>
<head>
    <title>Connexion</title>
    <link rel="stylesheet" href="static/bootstrap.css">
    <link rel="stylesheet" href="static/bootstrap.min.css">
</head>
<body class="vh-100 d-flex justify-content-center align-items-center">
<div class="container col-sm-5 col-10 card p-3 m-0 col-9">
    <!--<div>
        <div class="icon d-flex justify-content-center mb-2">
            <button class="btn btn-primary">
                <img src="GoogleIcon.svg" alt="">
                <label for="">Se connecter avec Google</label>
            </button>
        </div>
    </div>-->
    <!--<form>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email address</label>
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1">
        </div>
        <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Check me out</label>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>-->
    <form class="form-signin" method="get" action="index.jsp">
        <h1 class="h3 mb-3 text-center font-weight-normal"> Please sign in</h1>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" name="EmailAdress" class="form-control" placeholder="Email address" required autofocus style="background-color: #fff; color:#333; outline-color: #EE3268;">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="Password" class="form-control" placeholder="Password" required style="background-color: #fff; color:#333; outline-color: #EE3268;">
        <button class="btn btn-lg btn-primary btn-block w-100" type="submit" style="background-color: #EE3268; color:#fff; outline:none;border: none;margin-top: 10px;">Sign in</button>
    </form>
    <a class="text-primary text-end" href="Inscription.jsp">S'inscrire</a>
</div>
</body>
</html>