package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;

/**
 * Servlet implementation class ServletAplicacion
 */
@WebServlet("/Aplicacion")
public class ServletAplicacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAplicacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Usuario u = (Usuario) request.getSession().getAttribute("usuario");
		if (u == null) {
			response.sendRedirect("login.jsp");
		} else {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Aplicación</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Ongi etorri " + u.getNombre() + "</h1>");			
			out.println("<a href='Desconectar'>Salir</a>");
			out.println("<a href='VerAlumnos'>Ver Alumnos</a>");
			out.println("</body>");
			out.println("</html>");
			out.flush();
			out.close();
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
