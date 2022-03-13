<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
    <head>
        <title>Bibliothèque Centrale</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="<spring:url value="/resources/css/global.css" />" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
              crossorigin="anonymous">
    </head>

    <body class="bg-white vh-100">
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light text-center">
            <a class="navbar-brand ms-2 m-0" href="accueil">
                <img src="<spring:url value="/resources/img/LogoCN_Q.png" />" height="30" alt="Bouton accueil">
            </a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav m-auto" style="padding-right: 7rem">
                    <a class="nav-item nav-link" href="utilisateurs">Utilisateurs</a>
                    <a class="nav-item nav-link" href="livres">Livres</a>
                    <a class="nav-item nav-link" href="emprunts">Emprunts</a>
                </div>
            </div>
        </nav>
    </header>

    <div style="margin-top: 40vh">
        <div class="text-center">
            <h1 class="display-1">Bienvenue</h1>
        </div>
    </div>


    <%-- JS pour Bootstrap --%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous">
    </script>
    </body>
</html>
