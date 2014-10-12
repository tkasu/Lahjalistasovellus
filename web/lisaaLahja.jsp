<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<t:pohja pageTitle="Lisää Lahjaehdotus">
    <ul class="nav nav-tabs">
        <li class="passive"><a href="admin">Lahjalista</a></li>
        <li class="passive"><a href="varaukset">Varaukset</a></li>
        <li class="active"><a href="#">Lisää lahjaehdotus</a></li>
        <li class="passive"><a href="logout">Admin Sign Out</a></li>
    </ul>

    <div class="container">
        <h1>Lisää lahjaehdotus</h1>
        <form class="form-horizontal" role="form" action="lisaa" method="POST">
            <div class="form-group">
                <label class="col-md-2 control-label">Lahjan nimi</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" name="nimi" value="${nimi}" placeholder="nimi">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-2 control-label">Hinta</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="inputPrice" name="hinta" value="${hinta}" placeholder="hinta">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-2 control-label">Max Varaukset</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="text" name="maxVaraukset" value="${maxVaraukset}" placeholder="max varaukset">
                </div>
            </div>
             <div class="form-group">
                <label class="col-md-2 control-label">Ostopaikan url</label>
                <div class="col-md-10">
                        <input type="text" class="form-control" id="URL" name="ostoOsoite" value="${ostoOsoite}" placeholder="URL">
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
            </div>
        </form>
        <div>
            <c:forEach var="virhe" items="${virheet}">
                <div class="alert alert-danger">${virhe}</div>
            </c:forEach>         
        </div>
    </div>
</t:pohja> 
        

