
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
            <li class="passive"><a href="lisaaLahja.jsp">Lisää lahjaehdotus</a></li>
            <li class="passive"><a href="../html-demo/etusivu.jsp">Admin Sign Out</a></li>
        </ul>
        <div class="container">
            <h1>Admin</h1>
            <p>Kirjautunut käyttäjätunnuksella xxx</p>
            
            
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
                            <th>varanneet</th>
                            <th>Muokkaa/Poista</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>lahja1</td>
                            <td>10e</td>
                            <td>2/10</td>
                            <td>Matti, Seppo</td>
                            <td><button type="button" class="btn-default" data-toggle="modal" data-target="#muokkaaModal">Muokkaa</button></td>
                        </tr>
                        <tr>
                            <td>lahja2</td>
                            <td>20e</td>
                            <td>0/1</td>
                            <td>null</td>
                            <td><button type="button" class="btn-default">Muokkaa</button></td>
                        </tr>
                    </tbody>
                    
                </table>
            </div>
        
        
            <div class="modal fade" id="muokkaaModal" tabindex="-1" role="dialog" aria-labelledby="muokkaaModalLabel" aria-hidden="true">
                 <div class="modal-dialog">
                     <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                            <h4 class="modal-title">Muokkaa lahjaa</h4>
                        </div>
                        <div class="modal-body">
                            <p>lomake tänne</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Sulje</button>
                            <button type="button" class="btn btn-primary">Tallenna</button>
                        </div>
                    </div>
                </div>
            </div>
    </body>
</html>
