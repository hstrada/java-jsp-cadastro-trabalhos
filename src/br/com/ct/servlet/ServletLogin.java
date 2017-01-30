package br.com.ct.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ct.dao.GenericDao;
import br.com.ct.entity.Perfil;
import br.com.ct.entity.Usuario;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet(urlPatterns = { "/login" }, initParams = { @WebInitParam(name = "user", value = "admin"),
		@WebInitParam(name = "pwd", value = "admin") })
public class ServletLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ServletLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session = request.getSession();

			String usuario = request.getParameter("usuario");
			String senha = request.getParameter("senha");

			GenericDao<Usuario> dao = new GenericDao<>(Usuario.class);

			Usuario u = dao.buscarUsuario(usuario, senha);

			if (u.getId() != null) {
				session.setAttribute("session_u", u);
				
				if(u.getPerfil() == Perfil.PROFESSOR)
					session.setAttribute("professor", dao.buscarProfessorPorIdUsuario(u.getId()));
				else if(u.getPerfil() == Perfil.ALUNO)
					session.setAttribute("aluno", dao.buscarAlunoPorIdUsuario(u.getId()));
				
				response.sendRedirect("index.jsp");
			} else {
				response.sendRedirect("login.jsp");
			}

		} catch (Exception e) {
			response.sendRedirect("login.jsp");
		}

	}

}
