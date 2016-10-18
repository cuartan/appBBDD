package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestor.GestorBD;
import modelo.Alumno;
import modelo.Usuario;

/**
 * Servlet implementation class ServletVerAlumnos
 */
@WebServlet("/VerAlumnos")
public class ServletVerAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GestorBD gestor;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVerAlumnos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		gestor=GestorBD.getInstance();
		Usuario u=(Usuario) request.getSession().getAttribute("usuario");
		try {
			ArrayList<Alumno> alumnos=gestor.obtenerAlumnos();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Aplicaci�n</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Ongi etorri " + u.getNombre() + "</h1>");			
			out.println("<a href='Desconectar'>Salir</a>");
			out.println("<a href='VerAlumnos'>Ver Alumnos</a>");
			
			/* Mostrar los alumnos */
			out.println("<ul>");
			for(Alumno a:alumnos){
				out.println("<li>"+a.getDni()+" "+a.getNombre()+" "+a.getApellido()+" "+a.getDomicilio()+ "</li>");
			}
			out.println("</ul>");
			out.println("</body>");
			out.println("</html>");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
