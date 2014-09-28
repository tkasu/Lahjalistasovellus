<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<t:pohja pageTitle="Lahjalista">
    <ul class="nav nav-tabs">
        <li class="active"><a href="#">Lahjalista</a></li>
        <li class="passive"><a href="login">Admin Sign In</a></li>
    </ul>


    <div class="container">
        <h1>Tervetuloa!</h1>
        <p>Tervetuloa X:n ja Y:n lahjanvaraussivustolle! 
            Alla olevasta listasta voitte selata ja varata lahjaehdotuksia
            Kysymyksissä ja ongelmatilanteissa ota yhteyttä x@y.z.</p>

        <br />
        
        <c:if test="${ilmoitus != null}">
            <div class="alert alert-info">${ilmoitus}</div>
        </c:if>


        <c:forEach var="virhe" items="${virheet}">
            <div class="alert alert-danger">${virhe}</div>
        </c:forEach>



        <div class="panel panel-default">

            <div class="panel-heading">Lahjaehdotukset</div>

            <form class="navbar-form navbar-right" role="form" action="lahjalista" method="GET">
                <div class="form-group">
                    <input type="text" class="form-control" name="hakukentta" value="${hakuehto}" placeholder="Hae nimellä">
                    <button type="submit" class="btn btn-default">Hae</button>
                </div>    
            </form>
           

        <table class="table">
            <thead>
                <tr>
                    <td>nimi</td>
                    <td>hinta</td>
                    <td>Varausten määrä</td>
                    <td>Varaus</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="lahja" items="${lahjat}">
                    <tr>
                        <td>${lahja.nimi}</td>
                        <c:choose>
                            <c:when test="${lahja.hinta != null}">
                                <td>${lahja.hinta}</td>
                            </c:when>
                            <c:otherwise>
                                <td></td> 
                            </c:otherwise>
                        </c:choose>

                        <td>${lahja.varaustenMaara} / ${lahja.maxVaraukset}</td>
                        <c:choose>
                            <c:when test="${lahja.varaustenMaara + 1 > lahja.maxVaraukset}">
                                <td><button type="button" class="open-varaaModal btn btn-default disabled" data-toggle="modal" data-nimi="${lahja.nimi}" data-id="${lahja.id}" data-url="${lahja.osoite}" data-target="#varaaModal">Varaa</button></td>
                            </c:when>
                            <c:otherwise>
                                <td><button type="button" class="open-varaaModal btn btn-default" data-toggle="modal" data-nimi="${lahja.nimi}" data-id="${lahja.id}" data-url="${lahja.osoite}" data-target="#varaaModal">Varaa</button></td>
                            </c:otherwise>
                        </c:choose>
                        
                    </tr>
                </c:forEach>
            </tbody>

        </table>
    </div>


    <div class="modal fade" id="varaaModal" tabindex="-1" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content" >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">Varaa lahja (ei toiminnallisuutta vielä)</h4>
                </div>
                <div class="modal-body">
                    
                    <form class="form-horizontal" role="form" action="varaa" method="POST">
                        <input type="hidden" name="lahja-id" id="lahja-id-hidden" value="">
                        <div class="form-group">
                            <label class="col-md-2 control-label">Varattava lahja</label>
                            <div class="col-md-10">
                                <input type="text" name="lahja-nimi" id="lahja-nimi-hidden" class="form-control" id="lahja-url-hidden" value="" disabled>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label">Esimerkki-URL</label>
                            <div class="col-md-10">
                                <input type="url" name="lahja-url" class="form-control" id="lahja-url-hidden" value="" disabled>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label">Varaajan nimi</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" name="nimi" placeholder="Nimi (pakollinen)">
                            </div> 
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label">Puh.nro.</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" name="numero" placeholder="Numero">
                            </div> 
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label">Email</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" name="email" placeholder="email">
                            </div> 
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Sulje</button>
                            <button type="submit" class="btn btn-primary">Varaa</button>
                        </div>
                    </form>
                </div>
            </div>

        </div>
    </div>
</t:pohja>        

