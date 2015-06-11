<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<t:pohja pageTitle="Lahjalista">
    <ul class="nav nav-tabs">
        <li class="active"><a href="#">Lahjalista</a></li>
        <li class="passive"><a href="login">Admin Sign In</a></li>
    </ul>

    <div class="container">
        <img class="center-block" src="logo.png" class="img-responsive" height="40%" width="40%">
    </div>
    
    <br>
    <br>
    <br>
    <br>
    
    <div class="container">
        <div class="center-block">
            <p class="text-center">
                Tervetuloa X:n ja Y:n lahjanvaraussivustolle! 
                Tähän tekstidaa.
                Kysymyksissä ja ongelmatilanteissa ota yhteyttä x@y.z.</p>
        </div>
        <br />
        
        <c:if test="${ilmoitus != null}">
            <div class="alert alert-info">${ilmoitus}</div>
        </c:if>


        <c:forEach var="virhe" items="${virheet}">
            <div class="alert alert-danger">${virhe}</div>
        </c:forEach>

    </div>

        <div class="container panel panel-primary">
            
            
            <div class="page-header">
                <h4 id="tables">Lahjaehdotukset</h4>
            </div>


            <form class="navbar-form navbar-right" role="form" action="lahjalista" method="GET">
                <div class="form-group">
                    <input type="text" class="form-control" name="hakukentta" value="${hakuehto}" placeholder="Hae nimellä">
                    <button type="submit" class="btn btn-primary">Hae</button>
                </div>    
            </form>
           

        <table class="table table-condensed">
            <thead>
                <tr>
                    <th>nimi</th>
                    <th>hinta</th>
                    <th>varausten määrä</th>
                    <!--<th class="pull-right">Varaus</th>-->
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
                                <td><button type="button" class="open-varaaModal btn btn-default disabled pull-right" data-toggle="modal" data-nimi="${lahja.nimi}" data-id="${lahja.id}" data-url="${lahja.osoite}" data-target="#varaaModal">Varaa</button></td>
                            </c:when>
                            <c:otherwise>
                                <td><button type="button" class="open-varaaModal btn btn-default pull-right" data-toggle="modal" data-nimi="${lahja.nimi}" data-id="${lahja.id}" data-url="${lahja.osoite}" data-target="#varaaModal">Varaa</button></td>
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
                    <h4 class="modal-title">Varaa lahja</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" role="form" action="varaa" method="POST">
                        <input type="hidden" name="lahja-id" id="id-kentta" value=""/>
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
                        <br>
                        <h4 class ="modal-title">Uusi Varaaja</h4>
                        <div class="form-group">
                            <label class="col-md-2 control-label">Varaajan nimi</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" name="nimi" placeholder="Nimi (pakollinen)">
                            </div> 
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label">Email</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" name="email" placeholder="email (pakollinen)">
                            </div> 
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label">Puh.nro.</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" name="numero" placeholder="Numero">
                            </div> 
                        </div> 
                        <div class="modal-body right">
                            <button type="submit" class="btn btn-primary">Varaa</button>
                        </div>
                    </form>
                    <br>
                    <form class="form-horizontal" role="form" action="varaanyky" method="POST">
                        <input type="hidden" name="lahja-id" id="id-kentta2" value=""/>
                        <h4 class ="modal-title">Toista lahjaa varaavat</h4>
                        <label class="col-md-2 control-label">Email</label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" name="email" placeholder="email (pakollinen)">
                        </div>
                        <br>
                        <br>
                        <div class="modal-body right">
                            <button type="submit" class="btn btn-primary">Varaa</button>
                        </div>
                    </form>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Sulje</button>
                    </div>
                </div>
            </div>

        </div>
    </div>
</t:pohja>        

