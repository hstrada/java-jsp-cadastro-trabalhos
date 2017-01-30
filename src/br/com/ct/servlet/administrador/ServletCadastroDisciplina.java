package br.com.ct.servlet.administrador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ct.dao.GenericDao;
import br.com.ct.entity.Disciplina;

@WebServlet("/admin/cadDisciplina")
public class ServletCadastroDisciplina extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCadastroDisciplina() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("cadDisciplina.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nome = request.getParameter("nome");

			Disciplina disciplina = new Disciplina();
			disciplina.setNome(nome);

			GenericDao<Disciplina> dao = new GenericDao<>(Disciplina.class);
			dao.adicionar(disciplina);

			request.setAttribute("mensagem", "A disciplina " + disciplina.getNome() + " foi adicionada com sucesso.");
			request.getRequestDispatcher("cadDisciplina.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("mensagem", "Erro: " + e.getMessage());
			request.getRequestDispatcher("cadDisciplina.jsp").forward(request, response);
		}
	}
}