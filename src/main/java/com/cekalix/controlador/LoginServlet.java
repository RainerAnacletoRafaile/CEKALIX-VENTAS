package com.cekalix.controlador;

import com.cekalix.dao.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UsuarioDAO dao = new UsuarioDAO();

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

        try {
            var resultado = dao.autenticar(
                usuario == null ? "" : usuario.trim(),
                clave == null ? "" : clave
            );

            if (resultado.isPresent()) {
                request.getSession(true).setAttribute("usuarioSesion", resultado.get());
                response.sendRedirect(request.getContextPath() + "/inicio");
                return;
            }

            request.setAttribute("error", "Usuario o contraseña incorrectos.");
            doGet(request, response);
        } catch (SQLException e) {
            // El detalle queda en la consola del servidor; no se expone a usuarios.
            getServletContext().log("Error de autenticación de CEKALIX-VENTAS", e);
            request.setAttribute("error",
                "No se pudo conectar con la base de datos. Revisa la consola de Tomcat "
                + "y la configuración de conexión MySQL.");
            doGet(request, response);
        }
    }
}
