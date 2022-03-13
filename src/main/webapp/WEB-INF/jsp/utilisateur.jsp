<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
    <head>
        <title>Utilisateur</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
              crossorigin="anonymous">
    </head>

    <body class="bg-white">
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

    <div class="d-flex" style="height: 89vh">
        <div class="card w-50 m-auto my-auto">
            <div class="card-body shadow text-center">
                <h1 class="mb-4">Création / Modification d'utilisateur</h1>

                <form class="text-start">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="number">#</label>
                        </div>
                        <input type="text" class="form-control mb-2" id="number" value="127" disabled>
                    </div>

                    <div class="form-group">
                        <label class="mb-1" for="prenom">Prénom</label>
                        <input type="text" class="form-control mb-2" id="prenom" placeholder="Prénom">
                    </div>

                    <div class="form-group">
                        <label class="mb-1" for="nom">Nom</label>
                        <input type="text" class="form-control mb-2" id="nom" placeholder="Nom">
                    </div>

                    <div class="form-group">
                        <label class="mb-1" for="dateNaissance">Date de naissance</label>
                        <input type="date" class="form-control mb-4" id="dateNaissance">
                    </div>

                    <button type="submit" class="btn btn-primary w-100">Sauvegarder</button>
                </form>
            </div>
        </div>
    </div>


    <%-- JS pour Bootstrap --%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous">
    </script>
    </body>
</html>
