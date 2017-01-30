package br.com.ct.servlet.administrador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ct.dao.GenericDao;
import br.com.ct.entity.Disciplina;
import br.com.ct.entity.Professor;

@WebServlet("/admin/cadProfessorDisciplina")
public class ServletProfessorDisciplina extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletProfessorDisciplina() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("professorDisciplina.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			GenericDao<Professor> professorDao = new GenericDao<>(Professor.class);
			GenericDao<Disciplina> disciplinaDao = new GenericDao<>(Disciplina.class);
			
			Integer idDisciplina = Integer.parseInt(request.getParameter("disciplina"));
			Integer idProfessor = Integer.parseInt(request.getParameter("professor"));

			Professor professor = professorDao.buscar(idProfessor);
			Disciplina disciplina = disciplinaDao.buscar(idDisciplina);

			disciplina.getProfessores().add(professor);
			professor.getDisciplinas().add(disciplina);

			professorDao.adicionar(professor);
			
			request.setAttribute("mensagem", "A associação foi realizada com sucesso.");
			request.getRequestDispatcher("professorDisciplina.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("mensagem", "Erro: " + e.getMessage());
			request.getRequestDispatcher("professorDisciplina.jsp").forward(request, response);
		}
	}
}