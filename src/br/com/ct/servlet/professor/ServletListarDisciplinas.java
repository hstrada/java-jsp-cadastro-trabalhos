package br.com.ct.servlet.professor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ct.bean.DisciplinasBean;
import br.com.ct.dao.GenericDao;
import br.com.ct.entity.Professor;
import br.com.ct.entity.Usuario;

@WebServlet("/professor/listarDisciplinas")
public class ServletListarDisciplinas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletListarDisciplinas() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		
		Usuario u = (Usuario) session.getAttribute("session_u");
		GenericDao<Professor> professorDao = new GenericDao<>(Professor.class);

		Professor p = professorDao.buscarProfessorPorIdUsuario(u.getId());

		DisciplinasBean disciplinasBean = new DisciplinasBean();
		request.setAttribute("disciplinas", disciplinasBean.getListaDisciplinasPorProfessor(p.getId()));

		request.getRequestDispatcher("listarDisciplinas.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}