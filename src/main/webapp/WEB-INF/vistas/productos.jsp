<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List,com.cekalix.modelo.Producto" %>
<%
    List<Producto> productos = (List<Producto>) request.getAttribute("productos");
%>
<!DOCTYPE html>
<html lang="es"><head>
<meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1">
<title>Productos | CEKALIX</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head><body>
<header class="barra">
    <a class="marca" href="${pageContext.request.contextPath}/inicio">CEKALIX <span>VENTAS</span></a>
    <a href="${pageContext.request.contextPath}/inicio">Volver al panel</a>
</header>
<main class="contenido"><h1>Productos</h1><p>Catálogo registrado en el sistema.</p>
<div class="tabla-contenedor"><table>
<thead><tr><th>SKU</th><th>Producto</th><th>Descripción</th><th>Precio</th><th>Stock</th></tr></thead>
<tbody>
<% if (productos == null || productos.isEmpty()) { %>
<tr><td colspan="5" class="vacio">No hay productos registrados.</td></tr>
<% } else { for (Producto p : productos) { %>
<tr><td><%= p.getSku() %></td><td><%= p.getNombre() %></td>
<td><%= p.getDescripcion() == null ? "-" : p.getDescripcion() %></td>
<td>S/ <%= p.getPrecio() %></td><td><%= p.getStock() %></td></tr>
<% } } %>
</tbody></table></div></main></body></html>
