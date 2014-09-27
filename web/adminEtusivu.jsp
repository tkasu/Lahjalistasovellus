<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<t:pohja pageTitle="Admin Lahjalista">
    <ul class="nav nav-tabs">
        <li class="active"><a href="#">Lahjalista</a></li>
        <li class="passive"><a href="lisaa">Lisää lahjaehdotus</a></li>
        <li class="passive"><a href="logout">Admin Sign Out</a></li>
    </ul>

    <div class="container">
        <h1>Admin</h1>
        <p>Kirjautunut käyttäjätunnuksella "${kirjautunut}"</p>
        <p>Varattuja lahjoja ei voi vielä poistaa, tämä toteutetaan varausten yhteydessä ensi viikolla</p>  


        <br />

        <c:if test="${ilmoitus != null}">
            <div class="alert alert-info">${ilmoitus}</div>
        </c:if>


        <c:forEach var="virhe" items="${virheet}">
            <div class="alert alert-danger">${virhe}</div>
        </c:forEach>




        <br />
        <br />



        <div>
            
        </div>
        
        <div class="panel panel-default">

            <div class="panel-heading">Lahjaehdotukset</div>
            
            <form class="navbar-form navbar-right" role="form" action="admin" method="GET">
                <div class="form-group">
                    <input type="text" class="form-control" name="hakukentta" value="${hakuehto}" placeholder="Hae nimellä">
                    <button type="submit" class="btn btn-default">Hae</button>
                </div>    
            </form>

            <table class="table">
                <thead>
                    <tr>
                        <td>nimi
                        </td>
                        <td>hinta</td>
                        <td>varauksia jäljellä</td>
                        <td>varanneet</td>
                        <td>Muokkaa/Poista</td>
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
                            <td>0/${lahja.maxVaraukset}</td>
                            <td>Matti, Seppo(Ei toimi vielä)</td>
                            <td><button class="open-muokkaaModal btn btn-default" data-toggle="modal" data-nimi="${lahja.nimi}" data-hinta="${lahja.hinta}" data-maxVaraukset="${lahja.maxVaraukset}" data-osoite="${lahja.osoite}" data-id="${lahja.id}" data-target="#muokkaaModal">Muokkaa</button></td>
                        </tr>
                    </c:forEach>
                </tbody>

            </table>
        </div>
    </div>


    <div class="modal fade" id="muokkaaModal" tabindex="-1" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">Muokkaa lahjaa</h4>
                </div>
                <div class="modal-body">


                    <form class="form-horizontal" role="form" action="muokkaa" method="POST">
                        <input type="hidden" name="lahja-id" id="id-kentta" value="" />
                        <div  class="form-group">
                            <label class="col-md-2 control-label">Lahjan nimi</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" id="nimiKentta" name="nimi" placeholder="nimi">
                            </div>
                        </div>
                        <div  class="form-group">
                            <label class="col-md-2 control-label">Hinta</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" id="hintaKentta" name="hinta" placeholder="hinta" value="">
                            </div>
                        </div>
                        <div  class="form-group">
                            <label class="col-md-2 control-label">Max Varaukset</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" id="maxVarauksetKentta" name="maxVaraukset" placeholder="max varaukset" value="">
                            </div>
                        </div>  
                        <div  class="form-group">
                            <label class="col-md-2 control-label">Ostopaikan url</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" id="osoiteKentta" name="osoite" placeholder="URL">
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

                        </div>
                        <div class="modal-footer">
                            <button type="button"  class="btn btn-default" data-dismiss="modal">Sulje</button>
                            <button type="submit" class="btn btn-primary">Tallenna</button>
                        </div>
                    </form>

                    <div>
                        <form action="poista" method="POST">
                            <input type="hidden" name="poista-id" id="id-kentta2" value="" />
                            <button type="submit" class="btn btn-danger">Poista Lahja</button>
                        </form>
                        <!---<button type="button" class="btn btn-danger" data-id="" data-toggle="modal" data-target="#poistaModal">Poista Lahja</button> --->
                    </div>

                </div>

            </div>
        </div>
    </div>


    <!--- AINAKIN väliaikaisesti poissa käytöstä
        <div class="open-muokkaaModal modal fade" id="poistaModal" tabindex="-1" role="dialog">
            <input type="hidden" name="lahja-id" id="poistaId" value="" />
            <input type="hidden" name="nimi" id="poistaNimi" value="" />
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Haluatko varmasti poistaa lahjan?</h4>
                    </div>
                    <div class="modal-footer">
                        <form action="poista" method="POST">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Palaa takaisin</button>
                            <button type="submit" class="btn btn-danger">Poista Lahja</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    
        --->
</t:pohja>     


