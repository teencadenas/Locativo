<%-- 
    Document   : cliente
    Created on : 20/11/2023, 11:34:49 a. m.
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
        <h1>Hello World! cliente</h1>
        <div class="retorno">
            <a href="home.html">Home</a>
        </div>
        <div class="formulario-container">
            <form action="cliente" method="POST">
                <fieldset>
                    <legend class="tituloForm">Cliente</legend>
                    <div class="inputBox">
                        <input type="text" id="idCliente" name="idCliente" minlength="5" maxlength="10" required autofocus placeholder="Id cliente"></input>
                    </div>    
                    <div class="inputBox">
                        <input type="text" id="nombreCliente" name="nombreCliente" minlength="5" maxlength="50" required placeholder="Nombre Cliente"></input></input>
                    </div>    
                    <div class="inputBox">
                        <input type="text" id="direccionCliente" name="direccionCliente" minlength="5" maxlength="100" required placeholder="Direccion cliente"></input>
                    </div>    
                    <div class="inputBox">
                        <input type="tel" id="telefonoCliente" name="telefonoCliente" minlength="5" maxlength="10"   required placeholder="Telefono cliente" ></input>  
                    <div class="inputBoton">
                        <input type="submit" id="crear" name="crear" value="Crear">
                    </div>    
                    <div class="inputBoton">
                        <input type ="reset" value="Editar">
                    </div>    
                    <div class="inputBoton">
                        <input type="submit" value="Buscar">
                    </div>    
                    <div class="inputBoton">
                        <input type ="reset" value="Eliminar">
                    </div>
                </fieldset>
            </form>
            <table>
                <tr>
                    <th>Nit cliente</th>
                    <th>Nombre</th>
                    <th>Direccion</th>
                    <th>Telefono</th>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>


        </div>   
    </body>
</html>
