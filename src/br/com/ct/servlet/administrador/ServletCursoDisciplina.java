package br.com.ct.servlet.administrador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ct.dao.GenericDao;
import br.com.ct.entity.Curso;
import br.com.ct.entity.Disciplina;

@WebServlet("/admin/cadCursoDisciplina")
public class ServletCursoDisciplina extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCursoDisciplina() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("cursoDisciplina.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			GenericDao<Curso> cursoDao = new GenericDao<>(Curso.class);
			GenericDao<Disciplina> disciplinaDao = new GenericDao<>(Disciplina.class);

			Integer idDisciplina = Integer.parseInt(request.getParameter("disciplina"));
			Integer idCurso = Integer.parseInt(request.getParameter("curso"));

			Curso curso = cursoDao.buscar(idCurso);
			Disciplina disciplina = disciplinaDao.buscar(idDisciplina);

			disciplina.getCursos().add(curso);
			curso.getDisciplinas().add(disciplina);

			cursoDao.adicionar(curso);

			request.setAttribute("mensagem", "A associação foi realizada com sucesso.");
			request.getRequestDispatcher("cursoDisciplina.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("mensagem", "Erro: " + e.getMessage());
			request.getRequestDispatcher("cursoDisciplina.jsp").forward(request, response);
		}
	}
}