package com.cekalix.controlador;

import com.cekalix.dao.ProductoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/productos")
public class ProductoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final ProductoDAO productoDAO = new ProductoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuarioSesion") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        try {
            request.setAttribute("productos", productoDAO.listar());
            request.getRequestDispatcher("/WEB-INF/vistas/productos.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error al listar productos.", e);
        }
    }
}
