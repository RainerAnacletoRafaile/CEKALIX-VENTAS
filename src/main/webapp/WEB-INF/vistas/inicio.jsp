<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.cekalix.modelo.Usuario" %>
<%
    Usuario usuarioSesion = (Usuario) session.getAttribute("usuarioSesion");
    if (usuarioSesion == null) {
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }
%>
<!DOCTYPE html>
<html lang="es"><head>
<meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1">
<title>Inicio | CEKALIX</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head><body>
<header class="barra">
    <a class="marca" href="${pageContext.request.contextPath}/inicio">CEKALIX <span>VENTAS</span></a>
    <div>Hola, <strong><%= usuarioSesion.getNombre() %></strong> ·
        <a href="${pageContext.request.contextPath}/cerrar-sesion">Cerrar sesión</a></div>
</header>
<main class="contenido">
    <h1>Panel principal</h1><p>Bienvenido al sistema de gestión de ventas.</p>
    <section class="modulos">
        <a class="modulo" href="${pageContext.request.contextPath}/productos">
            <h2>Productos</h2><p>Consultar catálogo, precios y stock.</p>
        </a>
        <div class="modulo deshabilitado"><h2>Ventas</h2><p>Próximo módulo por implementar.</p></div>
    </section>
</main></body></html>
