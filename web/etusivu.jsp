<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

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
        
        <c:if test="${true != true}">
            <div class="alert alert-danger">A-Virhe! ${errorViesti}</div>
        </c:if>


        <br />
        <br />
        <br />



        <div class="panel panel-default">

            <div class="panel-heading">Lahjaehdotukset</div>
        </div>             

        <table class="table">
            <thead>
                <tr>
                    <td>nimi</td>
                    <td>hinta</td>
                    <td>varauksia jäljellä</td>
                    <td>Varaus</td>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>lahja1</td>
                    <td>10e</td>
                    <td>2/10</td>
                    <td><button type="button" class="btn btn-default" data-toggle="modal" data-target="#varaaModal">Varaa</button></td>
                </tr>
                <tr>
                    <td>lahja2</td>
                    <td>20e</td>
                    <td>0/1</td>
                    <td><button type="button" class="btn btn-default" data-toggle="modal" data-target="#varaaModal">Varaa</button></td>
                </tr>
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
                   <p> olet varaamassa lahjaa xxx </p>
                    <form class="form-horizontal" role="form" action="adminEtusivu.html" method="POST">
                        <div class="form-group">
                            <label class="col-md-2 control-label">Varaajan nimi</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" name="Nimi" placeholder="Nimi (pakollinen)">
                            </div> 
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label">Puh.nro.</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" name="Numero" placeholder="Numero">
                            </div> 
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label">Email</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" name="Email" placeholder="email">
                            </div> 
                        </div>
                    </form>
               </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Sulje</button>
                    <button type="button" class="btn btn-primary">Varaa</button>
                </div>
            </div>
            
        </div>
    </div>
</t:pohja>        
    
