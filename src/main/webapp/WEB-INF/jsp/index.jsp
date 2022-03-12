<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
    <head>
        <title>Login</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
              crossorigin="anonymous">
    </head>

    <body class="vh-100 d-flex bg-secondary">
    <div class="card w-25 m-auto my-auto">
        <div class="card-body shadow">
            <img src="<c:url value="/resources/img/LogoCN_Q.png" />" height="50" alt="Logo Centrale Nantes"
            class="mx-auto d-block mb-2">

            <form action="login" method="post">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control mb-2" id="username" placeholder="Username">
                </div>

                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control mb-4" id="password" placeholder="Password">
                </div>

                <button type="submit" class="btn btn-primary w-100">Sign in</button>
            </form>
        </div>
    </div>


    <%-- JS pour Bootstrap --%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous">
    </script>
    </body>
</html>
