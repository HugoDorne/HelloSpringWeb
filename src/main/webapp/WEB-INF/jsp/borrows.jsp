<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
    <head>
        <title>Emprunts</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

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


    <div class="text-center mt-4">
        <h1  class="mb-4">Liste des emprunts</h1>

        <div class="w-75 m-auto">
            <table class="table table-bordered">
                <thead class="thead-light">
                    <tr>
                        <th scope="col" style="width: 7.5%">#</th>
                        <th scope="col" style="width: 25%">Emprunteur</th>
                        <th scope="col" style="width: 25%">Livre</th>
                        <th scope="col" style="width: 21.25%">Date de l'emprunt</th>
                        <th scope="col" style="width: 21.25%">Date de retour</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="b" items="${borrows}">
                    <tr>
                        <th scope="row">${b.borrowId}</th>
                        <td>${b.personId.personFirstname += " " += b.personId.personLastname}</td>
                        <td>${"\"" += b.bookId.bookTitle += "\" de " += b.bookId.bookAuthors}</td>
                        <td>${b.borrowDate}</td>
                        <td>
                            <c:choose>
                                <c:when test="${empty b.borrowReturn}">
                                    <form action="#" method="post">
                                        <input type="hidden" name="borrowId" value="${b.borrowId}"/>
                                        <button formaction="returnBorrow" class="btn btn-primary">Rendre l'emprunt</button>
                                    </form>
                                </c:when>
                                <c:otherwise>
                                    ${b.borrowReturn}
                                </c:otherwise>
                            </c:choose>

                        </td>
                    </tr>
                    </c:forEach>

                    <tr>
                        <td colspan="4"></td>
                        <td>
                            <form action="#" method="post">
                                <button formaction="createBorrow" style="background: transparent; border: none !important;">
                                    <svg style="cursor:pointer;" fill="#00A1FF" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24" height="24"><path d="M12.75 7.75a.75.75 0 00-1.5 0v3.5h-3.5a.75.75 0 000 1.5h3.5v3.5a.75.75 0 001.5 0v-3.5h3.5a.75.75 0 000-1.5h-3.5v-3.5z"></path><path fill-rule="evenodd" d="M12 1C5.925 1 1 5.925 1 12s4.925 11 11 11 11-4.925 11-11S18.075 1 12 1zM2.5 12a9.5 9.5 0 1119 0 9.5 9.5 0 01-19 0z"></path></svg>
                                </button>
                            </form>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>


    <%-- JS pour Bootstrap --%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous">
    </script>
    </body>
</html>
