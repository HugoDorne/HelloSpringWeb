<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
    <head>
        <title>Livres</title>

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

    <div class="text-center mt-4">
        <h1 class="mb-4">Liste des livres</h1>

        <div class="w-75 m-auto">
            <table class="table table-bordered">
                <thead class="thead-light">
                    <tr>
                        <th scope="col" style="width: 7.5%">#</th>
                        <th scope="col" style="width: 36.25%">Titre</th>
                        <th scope="col" style="width: 36.25%">Auteur</th>
                        <th scope="col" style="width: 10%">Disponibilité</th>
                        <th scope="col" style="width: 10%"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="l" items="${livres}">
                    <tr>
                        <th scope="row">${l.id}</th>
                        <td class="text-start">${l.titre}</td>
                        <td class="text-start">${l.auteur.prenom += " " += l.auteur.nom}</td>
                        <td class="text-start">${l.disponibilite.label}</td>
                        <td>
                            <svg class="me-2" style="cursor:pointer;" fill="#000" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24" height="24"><path fill-rule="evenodd" d="M17.263 2.177a1.75 1.75 0 012.474 0l2.586 2.586a1.75 1.75 0 010 2.474L19.53 10.03l-.012.013L8.69 20.378a1.75 1.75 0 01-.699.409l-5.523 1.68a.75.75 0 01-.935-.935l1.673-5.5a1.75 1.75 0 01.466-.756L14.476 4.963l2.787-2.786zm-2.275 4.371l-10.28 9.813a.25.25 0 00-.067.108l-1.264 4.154 4.177-1.271a.25.25 0 00.1-.059l10.273-9.806-2.94-2.939zM19 8.44l2.263-2.262a.25.25 0 000-.354l-2.586-2.586a.25.25 0 00-.354 0L16.061 5.5 19 8.44z"></path></svg>
                            <svg style="cursor:pointer;" fill="#FF0000" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24" height="24"><path fill-rule="evenodd" d="M1 12C1 5.925 5.925 1 12 1s11 4.925 11 11-4.925 11-11 11S1 18.075 1 12zm8.036-4.024a.75.75 0 00-1.06 1.06L10.939 12l-2.963 2.963a.75.75 0 101.06 1.06L12 13.06l2.963 2.964a.75.75 0 001.061-1.06L13.061 12l2.963-2.964a.75.75 0 10-1.06-1.06L12 10.939 9.036 7.976z"></path></svg>
                        </td>
                    </tr>
                    </c:forEach>

                    <tr>
                        <td colspan="4"></td>
                        <td>
                            <svg style="cursor:pointer;" fill="#00A1FF" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24" height="24"><path d="M12.75 7.75a.75.75 0 00-1.5 0v3.5h-3.5a.75.75 0 000 1.5h3.5v3.5a.75.75 0 001.5 0v-3.5h3.5a.75.75 0 000-1.5h-3.5v-3.5z"></path><path fill-rule="evenodd" d="M12 1C5.925 1 1 5.925 1 12s4.925 11 11 11 11-4.925 11-11S18.075 1 12 1zM2.5 12a9.5 9.5 0 1119 0 9.5 9.5 0 01-19 0z"></path></svg>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>

        <a href="livre">Livre</a>
    </div>


    <%-- JS pour Bootstrap --%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous">
    </script>
    </body>
</html>
