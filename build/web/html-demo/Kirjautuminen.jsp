
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/bootstrap-theme.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
   
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin kirjautuminen</title>
    </head>
    <body>
        <ul class="nav nav-tabs">
            <li class="passive"><a href="../html-demo/etusivu.jsp">Lahjalista</a></li>
            <li class="active"><a href="#">Admin Sign In</a></li>
        </ul>
        <div class="container">
            <h1>Admin-kirjautuminen</h1>
            <form class="form-horizontal" role="form" action="lomake.html" method="POST">
                <div class="form-group">
                    <label for="inputUsername" class="col-md-2 control-label">Käyttäjätunnus</label>
                    <div class="col-md-10">
                        <input type="text" class="form-control" name="Username" placeholder="Username">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword1" class="col-md-2 control-label">Salasana</label>
                    <div class="col-md-10">
                        <input type="password" class="form-control" id="inputPassword1" name="password" placeholder="Password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-2 col-md-10">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> Muista kirjautuminen
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-2 col-md-10">
                        <button type="submit" class="btn btn-default">Kirjaudu sisään</button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
