<%-- 
    Document   : index
    Created on : 20/11/2023, 9:22:36 a. m.
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
        <!-- boton retorn pagina principal -->
    <div class="retorno">
        <a href="home.html">Home</a>
    </div>

    <!-- ingreso datos de usuario -->
    <div class="formulario-container">
        <form class="form" action="principal.jsp" method="POST">
            <fieldset>
                <legend class="tituloForm">Ingreso sistema de gestion</legend>
                <div class="inputBox">
                    <input type="text" id="usuarioIngreso" name="usuarioIngreso" minlength="5" maxlength="30" placeholder="Usuario" required autofocus onchange="usuario()"></input>
                    <i class='bx bxs-user-circle'></i>
                </div>
                <div class="inputBox">
                    <input type="password" id="contrasenaIngreso" name="contrasenaIngreso" minlength="5" maxlength="30" placeholder="password" required></input>
                    <i class='bx bxs-lock'></i>
                </div>
                <div class="inputBoton">
                    <input type= "submit" id="ingresar" name="ingresar" value="Ingresar" />
                </div> <!--envio de la informacion del formularo¿io remplaza buton-->
                <div class="recuperar-registro">
                    <a href="recuperarContraseña.html">Olvide mi contraseña</a>
                </div>    
            </fieldset>                
        </form>   
    </div>    
    </body>
</html>
<!--formaction="home.html"-->