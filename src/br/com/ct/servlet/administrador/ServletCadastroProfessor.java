package br.com.ct.servlet.administrador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ct.dao.GenericDao;
import br.com.ct.entity.Escola;
import br.com.ct.entity.Perfil;
import br.com.ct.entity.Professor;
import br.com.ct.entity.Usuario;

@WebServlet("/admin/cadProfessor")
public class ServletCadastroProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCadastroProfessor() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("cadProfessor.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nome = request.getParameter("nome");
			String login = request.getParameter("usuario");
			String senha = request.getParameter("senha");
			Integer idEscola = Integer.parseInt(request.getParameter("escola"));

			Escola escola = new Escola();
			escola.setId(idEscola);

			Usuario usuario = new Usuario();
			usuario.setUsuario(login);
			usuario.setSenha(senha);
			usuario.setPerfil(Perfil.PROFESSOR);

			Professor professor = new Professor();
			professor.setNome(nome);
			professor.setEscola(escola);

			GenericDao<Professor> professorDao = new GenericDao<>(Professor.class);
			GenericDao<Usuario> usuarioDao = new GenericDao<>(Usuario.class);
			professor.setUsuario(usuarioDao.buscar(usuarioDao.adicionar(usuario).getId()));
			professorDao.adicionar(professor);

			request.setAttribute("mensagem", "O Professor " + professor.getNome() + " foi adicionado com sucesso.");
			request.getRequestDispatcher("cadProfessor.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("mensagem", "Erro: " + e.getMessage());
			request.getRequestDispatcher("cadProfessor.jsp").forward(request, response);
		}
	}
}