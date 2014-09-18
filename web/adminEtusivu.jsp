<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pohja pageTitle="Admin Lahjalista">
    <ul class="nav nav-tabs">
        <li class="active"><a href="#">Lahjalista</a></li>
        <li class="passive"><a href="lisaa">Lisää lahjaehdotus</a></li>
        <li class="passive"><a href="admin">Admin Sign Out</a></li>
    </ul>
    
    <div class="container">
        <h1>Admin</h1>
        <p>Kirjautunut käyttäjätunnuksella xxx</p>


        <br />
        <br />
        <br />



        <div class="panel panel-default">

            <div class="panel-heading">Lahjaehdotukset</div>
                         

            <table class="table">
                <thead>
                    <tr>
                        <td>nimi</td>
                        <td>hinta</td>
                        <td>varauksia jäljellä</td>
                        <td>varanneet</td>
                        <td>Muokkaa/Poista</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>lahja1</td>
                        <td>10e</td>
                        <td>2/10</td>
                        <td>Matti, Seppo</td>
                        <td><button class="btn btn-default" data-toggle="modal" data-target="#muokkaaModal">Muokkaa</button></td>
                    </tr>
                    <tr>
                        <td>lahja2</td>
                        <td>20e</td>
                        <td>0/1</td>
                        <td>null</td>
                        <td><button class="btn btn-default" data-toggle="modal" data-target="#muokkaaModal">Muokkaa</button></td>
                    </tr>
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


                    <form class="form-horizontal" role="form" action="#" method="POST">
                        <div class="form-group">
                            <label class="col-md-2 control-label">Lahjan nimi</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" name="nimi" placeholder="nimi">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label">Hinta</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" id="inputPrice" name="hinta" placeholder="hinta">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label">Max Varaukset</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" id="text" name="max varaukset" placeholder="max varaukset">
                            </div>
                        </div>
                        <div class="form-group">
                           <label class="col-md-2 control-label">Ostopaikan url</label>
                           <div class="col-md-10">
                                <input type="text" class="form-control" id="URL" name="URL" placeholder="URL">
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
                                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#poistaModal">Poista Lahja</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Sulje</button>
                    <button type="button" class="btn btn-primary">Tallenna</button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="poistaModal" tabindex="-1" role="dialog">
         <div class="modal-dialog">
             <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">Haluatko varmasti poistaa lahjan?</h4>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Palaa takaisin</button>
                    <button type="button" class="btn btn-danger">Poista Lahja</button>
                </div>
            </div>
        </div>
    </div>
</t:pohja>     


