<%-- 
    Document   : ordenTrabajo
    Created on : 20/11/2023, 11:35:29 a. m.
    Author     : teenc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div class="retorno">
        <a href="home.html">Home</a>
    </div>
    <div class="formulario-container">
        <form class="form" action="#" target="_blank" method="post">
            <fieldset>
                <legend class="tituloForm">Crear Servicio</legend>
                <div class="inputBox">
                    <input type="text" id="numeroOrden" name="numeroOrden" minlength="5" maxlength="15" required pattern="[0-9]" autofocus placeholder="Numero Orden"></input>
                </div>
                <div class="inputSelect">
                    <select id="idCliente" name="idCliente">
                        <option value="">Cliente</option>             
                    </select>
                    <input type="text" id="nombreCliente" name="nombreCliente" placeholder="datos Cliente"</input>
                </div>    
                <div class="inputSelect">
                    <select id="idUnidadComercial" name="idUnidadComercial">
                        <option value="">Comercio</option>
                    <input type="text" id="nombreUnidadComercial" name="nombreUnidadComercial" placeholder="datos busqueda" readonly></input>
                    </select>
                </div>
                    <form class="form" action="#" target="blank" method="post">
                        <fieldset>
                            <legend class="tituloForm">Servicio a Realizar</legend>    
                                <div class="inputBoton">
                                    <input type="search" id="idServicio" name="idServicio" minlength="5" maxlength="15" required pattern="[0-9]" placeholder="# Servicio"></input>
                                </div>
                                <div class="inputBox">
                                    <input type="text" id="Servicio" name="Servicio" readonly></input>
                                </div>    
                               <div class="inputBoton">
                                    <input type="submit" id="buscarServicio" value="Agregar"></input>
                                </div>                             
                                    <ol>
                                        <li>Servicio 1</li>
                                        <li>Servicio 2</li>
                                        <li>Servicio 3</li>
                                        <li>Servicio 4</li>
                                    </ol>
                        </fieldset>    
                    </form>    
                <div class="inputBoton">
                    <input type="submit" value="Grabar"> 
                </div>
                <div class="inputBoton">
                    <input type ="reset" value="Limpiar formulario">
                </div>
            </fieldset>
        </form>
    </div>
    </body>
</html>
