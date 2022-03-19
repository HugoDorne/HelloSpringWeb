<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
    <head>
        <title>Emprunt</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
              crossorigin="anonymous">
    </head>

    <body class="bg-white">
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light text-center">
            <a class="navbar-brand ms-2 m-0" href="home">
                <img src="<spring:url value="/resources/img/LogoCN_Q.png" />" height="30" alt="Bouton accueil">
            </a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav m-auto" style="padding-right: 7rem">
                    <a class="nav-item nav-link" href="persons">Personnes</a>
                    <a class="nav-item nav-link" href="books">Livres</a>
                    <a class="nav-item nav-link" href="borrows">Emprunts</a>
                </div>
            </div>
        </nav>
    </header>

    <div class="d-flex" style="height: 89vh">
        <div class="card w-50 m-auto my-auto">
            <div class="card-body shadow text-center">
                <h1 class="mb-4">Création d'un emprunt</h1>

                <form class="text-start">
                    <div class="form-group">
                        <label for="emprunteur" class="form-label">Emprunteur</label>
                        <input class="form-control" list="emprunteurOptions" id="emprunteur" placeholder="Prénom NOM">
                        <datalist id="emprunteurOptions">
                            <option value="Hugo DORNE">
                            <option value="Mickaël FONTES">
                        </datalist>
                    </div>

                    <div class="form-group">
                        <label for="livre" class="form-label">Livre emprunté</label>
                        <input class="form-control" list="livreOptions" id="livre" placeholder="Prénom NOM">
                        <datalist id="livreOptions">
                            <option value="La Bible, Jésus">
                            <option value="Atomic Habits, Michael Scott">
                        </datalist>
                    </div>

                    <div class="form-group">
                        <label class="mb-1" for="dateEmprunt">Date de l'emprunt</label>
                        <input type="date" class="form-control mb-4" id="dateEmprunt">
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
