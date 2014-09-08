
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/bootstrap-theme.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ul class="nav nav-tabs">
            <li class="passive"><a href="adminEtusivu.jsp">Lahjalista</a></li>
            <li class="active"><a href="#">Lisää lahjaehdotus</a></li>
            <li class="passive"><a href="../html-demo/etusivu.jsp">Admin Sign Out</a></li>
        </ul>
        
        <div class="container">
            <h1>Lisää lahjaehdotus</h1>
            <form class="form-horizontal" role="form" action="#" method="POST">
                <div class="form-group">
                    <label for="inputName" class="col-md-2 control-label">Lahjan nimi</label>
                    <div class="col-md-10">
                        <input type="text" class="form-control" name="nimi" placeholder="nimi">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPrice" class="col-md-2 control-label">Hinta</label>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="inputPrice" name="hinta" placeholder="hinta">
                    </div>
                </div>
                <div class="form-group">
                    <label for="max varaukset" class="col-md-2 control-label">Max Varaukset</label>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="text" name="max varaukset" placeholder="max varaukset">
                    </div>
                </div>
                 <div class="form-group">
                    <label for="URL" class="col-md-2 control-label">Ostopaikan url</label>
                    <div class="col-md-10">
                            <input type="text" class="form-control" id="URL" name="URL" placeholder="URL">
                    </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-2 col-md-10">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> Liitä tilinumero
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-2 col-md-10">
                        <button type="submit" class="btn btn-default">Lisää Lahja</button>
                    </div>
                    <br />
                    <p> BETA! Kaikki tunnukset toimii! </p>
                </div>
            </form>
        </div>
        
        
    </body>
</html>
