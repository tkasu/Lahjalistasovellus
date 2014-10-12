<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<t:pohja pageTitle="Varaukset">
    <ul class="nav nav-tabs">
        <li class="passive"><a href="admin">Lahjalista</a></li>
        <li class="active"><a href="#">Varaukset</a></li>
        <li class="passive"><a href="lisaa">Lisää lahjaehdotus</a></li>
        <li class="passive"><a href="logout">Admin Sign Out</a></li>
    </ul>
    
    <div class="container">
        <h1>Varaukset</h1>
        
        <br />

        <c:if test="${ilmoitus != null}">
            <div class="alert alert-info">${ilmoitus}</div>
        </c:if>


        <c:forEach var="virhe" items="${virheet}">
            <div class="alert alert-danger">${virhe}</div>
        </c:forEach>

        <br />
    
        <div class="panel panel-default">
            <div class="panel-heading">Lahjaehdotukset</div>
            
            <form class="navbar-form navbar-right" role="form" action="varaukset" method="GET">
                <div class="form-group">
                    <input type="text" class="form-control" name="hakukentta" value="${hakuehto}" placeholder="Varaajan/lahjan nimi">
                    <button type="submit" class="btn btn-default">Hae</button>
                </div>    
            </form>
            
            <table class="table">
                <thead>
                    <tr>
                        <td>Varaaaja</td>
                        <td>Varaajan email</td>
                        <td>Lahja</td>
                        <td>Muokkaa/Poista</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="varaus" items="${varaukset}">
                        <tr>
                            <td>${varaus.varaajaNimi}</td>
                            <td>${varaus.varaajaEmail}</td>
                            <td>${varaus.lahjaNimi}</td>
                            <td><button class="open-muokkaaVarausModal btn btn-default" data-toggle="modal" data-lId="${varaus.lahjaId}" data-lNimi="${varaus.lahjaNimi}" data-vId="${varaus.varaajaId}" data-vNimi="${varaus.varaajaNimi}" data-target="#muokkaaVarausModal">Muokkaa</button></td>
                        </tr>
                    </c:forEach>
                </tbody>

            </table>
        </div>
    </div>
                    
    <div class="modal fade" id="muokkaaVarausModal" tabindex="-1" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">Muokkaa varausta</h4>
                </div>
                <div class="modal-body">


                    <form class="form-horizontal" role="form" action="muokkaaVaraus" method="POST">
                        <input type="hidden" name="lahja-id" id="lId-kentta" value="" />
                        <input type="hidden" name="varaaja-id" id="vId-kentta" value="" />
                        <div  class="form-group">
                            <label class="col-md-2 control-label">Varaajan nimi</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" id="vNimi-kentta" name="vNimi" placeholder="Varaajan nimi" value="" disabled>
                            </div>
                        </div>
                        <div  class="form-group">
                            <label class="col-md-2 control-label">Lahjan nimi</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" id="lNimi-kentta" name="lNimi" placeholder="Lahjan nimi" value="">
                            </div>
                        </div>
                        <div class="form-group">

                        </div>
                        <div class="modal-footer">
                            <button type="button"  class="btn btn-default" data-dismiss="modal">Sulje</button>
                            <button type="submit" class="btn btn-primary">Tallenna</button>
                        </div>
                    </form>

                    <div>
                        <form action="poistaVaraus" method="POST">
                            <input type="hidden" name="poista-lahja-id" id="lId-kentta2" value="" />
                            <input type="hidden" name="poista-varaaja-id" id="vId-kentta2" value="" />
                            <button type="submit" class="btn btn-danger">Poista Varaus</button>
                        </form>
                    </div>

                </div>

            </div>
        </div>
    </div>
    
</t:pohja>
