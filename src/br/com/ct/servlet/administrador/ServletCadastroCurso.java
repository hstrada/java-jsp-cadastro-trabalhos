package br.com.ct.servlet.administrador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ct.dao.GenericDao;
import br.com.ct.entity.Curso;
import br.com.ct.entity.Escola;

@WebServlet("/admin/cadCurso")
public class ServletCadastroCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCadastroCurso() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("cadCurso.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nome = request.getParameter("nome");
			String sigla = request.getParameter("sigla");
			Integer escola = Integer.parseInt(request.getParameter("escola"));

			Escola e = new Escola();
			e.setId(escola);

			Curso curso = new Curso();
			curso.setNome(nome);
			curso.setSigla(sigla);
			curso.setEscola(e);

			GenericDao<Curso> dao = new GenericDao<>(Curso.class);
			dao.adicionar(curso);

			request.setAttribute("mensagem", "O Curso " + curso.getNome() + " foi cadastrado com sucesso.");
			request.getRequestDispatcher("cadCurso.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("mensagem", "Erro: " + e.getMessage());
			request.getRequestDispatcher("cadCurso.jsp").forward(request, response);
		}
	}
}