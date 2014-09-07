
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/bootstrap-theme.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lahjalista</title>
    </head>
    <body>
        <ul class="nav nav-tabs">
            <li class="active"><a href="#">Lahjalista</a></li>
            <li class="passive"><a href="../html-demo/Kirjautuminen.jsp">Admin Sign In</a></li>
        </ul>
        <div class="container">
            <h1>Tervetuloa!</h1>
            <p>Tervetuloa X:n ja Y:n lahjanvaraussivustolle! 
                Alla olevasta listasta voitte selata ja varata lahjaehdotuksia
                Kysymyksissä ja ongelmatilanteissa ota yhteyttä x@y.z.</p>
            
            
            <br />
            <br />
            <br />
            
            
            
            <div class="panel panel-default">
                 
                <div class="panel-heading">Lahjaehdotukset</div>
                </div>             
             
                <table class="table">
                    <thead>
                        <tr>
                            <th>nimi</td>
                            <th>hinta</td>
                            <th>varauksia jäljellä</td>
                            <th>Varaus</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>lahja1</td>
                            <td>10e</td>
                            <td>2/10</td>
                            <td><button type="button" class="btn-default">Varaa</button></td>
                        </tr>
                        <tr>
                            <td>lahja2</td>
                            <td>20e</td>
                            <td>0/1</td>
                            <td><button type="button" class="btn-default">Varaa</button></td>
                        </tr>
                    </tbody>
                    
                </table>
            </div>
            
        </div>
    </body>
</html>
