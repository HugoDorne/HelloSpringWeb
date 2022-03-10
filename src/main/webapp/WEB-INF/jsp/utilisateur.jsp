<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
    <head>
        <title>Utilisateur</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">

    </head>

    <body class="bg-white">
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light text-center">
            <a class="navbar-brand" href="accueil">
                <img src="<c:url value="/resources/img/LogoCN_Q.png" />" height="30" alt="Bouton accueil">
            </a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav m-auto pr-5">
                    <a class="nav-item nav-link" href="utilisateurs">Utilisateurs</a>
                    <a class="nav-item nav-link" href="livres">Livres</a>
                </div>
            </div>
        </nav>
    </header>

    <div class="d-flex" style="height: 89vh">
        <div class="card w-50 m-auto my-auto">
            <div class="card-body shadow text-center">
                <h1>Création / Modification d'utilisateur</h1>

                <form class="text-left">
                    <div class="form-group">
                        <label class="mb-1" for="id">#</label>
                        <input type="text" class="form-control mb-2" id="id" placeholder="127" readonly>
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
                        <input type="date" class="form-control mb-2" id="dateNaissance">
                    </div>

                    <button type="submit" class="btn btn-primary w-100">Sauvegarder</button>
                </form>
            </div>
        </div>
    </div>


    <%-- JS pour Bootstrap --%>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    </body>
</html>

