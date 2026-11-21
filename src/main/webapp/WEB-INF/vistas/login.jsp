<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1">
<title>Ingresar | CEKALIX Ventas</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body class="pantalla-login">
<main class="login-card">
    <p class="marca">CEKALIX <span>VENTAS</span></p>
    <h1>Bienvenido</h1><p class="subtitulo">Ingresa tus credenciales para continuar.</p>
    <% if (request.getAttribute("error") != null) { %>
        <div class="alerta"><%= request.getAttribute("error") %></div>
    <% } %>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="usuario">Usuario</label>
        <input id="usuario" name="usuario" type="text" autocomplete="username" required>
        <label for="clave">Contraseña</label>
        <input id="clave" name="clave" type="password" autocomplete="current-password" required>
        <button type="submit">Ingresar</button>
    </form>
    <small>Entorno académico de desarrollo</small>
</main>
</body></html>
