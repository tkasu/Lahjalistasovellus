<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<t:pohja pageTitle="Lahjalista"> 
        <div class="container">
            
            <div class="container">
                <img class="center-block" src="logo.png" class="img-responsive" height="40%" width="40%">
            </div>
            
            <br>
            <br>
            
            <div class="row row-centered">
                <form class="form-horizontal" role="form" action="passIn" method="POST">
                    <div class="form-group">
                        <div class="col-sm-2 col-centered"
                            <label for="tunnussana"></label>
                            <input name="tunnussana" class="form-control text-center" placeholder="tunnussana">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 col-centered">
                            <button type="submit" class="btn btn-default center-block">Lähetä</button>
                        </div>
                    </div>
                </form>
            </div>
            
            <c:if test="${errorViesti != null}">
                <div class="alert alert-danger">${errorViesti}</div>
            </c:if>
                    
            <c:if test="${ilmoitus != null}">
                <div class="alert alert-info">${ilmoitus}</div>
            </c:if>
                    
        </div>
</t:pohja>
