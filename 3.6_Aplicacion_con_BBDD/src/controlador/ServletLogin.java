package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestor.GestorBD;
import modelo.Usuario;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/Login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestorBD gestor;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* Coger los parámetros del formulario */
		String nombre = request.getParameter("usuario");
		String clave = request.getParameter("clave");

		gestor = GestorBD.getInstance();
		Usuario u;
		try {
			u = gestor.loginUsuario(nombre, clave);
			/* Si existe ... */
			if (u != null) {
				Usuario user = new Usuario(nombre, clave);
				request.getSession().setAttribute("usuario", user);
				response.sendRedirect("Aplicacion");
			}

			/* Si no existe... */
			else {
				request.setAttribute("error", "Error. Usuario/clave desconocidos");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
