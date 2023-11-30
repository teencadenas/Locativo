<%-- 
    Document   : empleado
    Created on : 20/11/2023, 11:35:11 a. m.
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
        <h1>Hello World!empleado </h1>
        <div class="retorno">
        <a href="home.html">Home</a>
    </div>
    <div class="formulario-container">
        <form action="" target="_blank" method="post">
            <fieldset>
                <legend>Empleado</legend>
                <div class="inputBox">
                <input type="text" id="idEmpleado" name="idEmpleado" minlength="5" maxlength="10" required autofocus placeholder="Identificacion"></input>
                </div>
                <div class="inputBox">
                <input type="text" id="nombreEmpleado" name="nombreEmpleado" minlength="5" maxlength="10" required placeholder="Nombre"></input>
                </div>
                <div class="inputBox">
                <input type="text" id="apelllidoEmpleado" name="apelllidoEmpleado" minlength="5" maxlength="50" required  placeholder="Apellido"></input>
                </div>
                <div class="inputBox">
                <input type="text" id="ciudadEmpleado" name="ciudadEmpleado" minlength="5" maxlength="100" required  placeholder="Ciudad"></input>
                </div>
                <div class="inputBox">
                <input type="tel" id="telefonoEmpleado" name="telefonoEmpleado" minlength="5" maxlength="50" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" required  placeholder="Telefono"></input>
                </div>
                <div class="inputBox">
                <input type="text" id="estadoEmpleado" name="estadoEmpleado" minlength="5" maxlength="10" required  placeholder="Estado"></input>
                </div>
                <div class="inputBox">
                <input type="text" id="cargoEmpleado" name="cargoEmpleado" minlength="5" maxlength="10" required  placeholder="Cargo"></input>
                </div>
                <div class="inputBox">
                <input type="date" id="fechaEntradaEmpleado" name="fechaEntradaEmpleado" required  placeholder="Fecha ingreso"></input>
                </div>
                <div class="inputBox">
                <input type="date" id="fechaRetiroCliente" name="fechaRetiroCliente"  required placeholder="Fecha Retiro" ></input>
                </div>
                <div class="inputBoton">
                    <input type="submit" value="Crear">
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
    </div>
    
                <tr>
                    <th>Id Empleado</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Ciudad</th>
                    <th>Telefono</th>
                    <th>Estado</th>
                    <th>Cargo</th>
                    <th>Fecha ingreso</th>
                    <th>Fecha retiro</th>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>

    </body>
</html>
