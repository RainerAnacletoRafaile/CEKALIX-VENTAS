package com.cekalix.controlador;

import com.cekalix.dao.UsuarioDAO;
import com.cekalix.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");

        if (usuario == null || usuario.isBlank() || clave == null || clave.isBlank()) {
            request.setAttribute("error", "Ingresa tu usuario y contraseña.");
            request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
            return;
        }

        try {
            Optional<Usuario> resultado = usuarioDAO.validar(usuario.trim(), clave);
            if (resultado.isPresent()) {
                request.getSession(true).setAttribute("usuarioSesion", resultado.get());
                response.sendRedirect(request.getContextPath() + "/inicio");
            } else {
                request.setAttribute("error", "Usuario o contraseña incorrectos.");
                request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException("Error al consultar la base de datos.", e);
        }
    }
}
