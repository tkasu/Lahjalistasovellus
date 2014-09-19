<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

   
<t:pohja pageTitle="Kirjautuminen">
    <ul class="nav nav-tabs">
        <li class="passive"><a href="lahjalista">Lahjalista</a></li>
        <li class="active"><a href="#">Admin Sign In</a></li>
    </ul>


    <div class="container">
        <h1>Admin-kirjautuminen</h1>
        <form class="form-horizontal" role="form" action="login" method="POST">
            <div class="form-group">
                <label class="col-md-2 control-label">Käyttäjätunnus</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" name="username" value="${kayttaja}" placeholder="Username">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-2 control-label">Salasana</label>
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
                <br />
                
                <c:if test="${errorViesti != null}">
                    <div class="alert alert-danger">${errorViesti}</div>
                </c:if>
                
                <p>Testitunnukset kirjautumiseen: käyttäjätunnus: admin, salasana: password</p>
                
            </div>
        </form>
    </div>

</t:pohja>
