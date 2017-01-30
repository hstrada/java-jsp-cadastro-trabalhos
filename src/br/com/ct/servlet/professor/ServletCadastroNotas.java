package br.com.ct.servlet.professor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ct.dao.GenericDao;
import br.com.ct.entity.Nota;

@WebServlet("/professor/cadNotas")
public class ServletCadastroNotas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCadastroNotas() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			int idDisciplina = Integer.parseInt(request
					.getParameter("disciplina"));
			int idAluno = Integer.parseInt(request.getParameter("aluno"));

			GenericDao<Nota> notaDao = new GenericDao<>(Nota.class);

			request.setAttribute("nota",
					notaDao.buscarNotaDoAluno(idAluno, idDisciplina));
			request.getRequestDispatcher("cadNotas.jsp").forward(request,
					response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {

			GenericDao<Nota> notaDao = new GenericDao<>(Nota.class);

			Integer idAluno = Integer.parseInt(request.getParameter("idAluno"));
			Integer idDisciplina = Integer.parseInt(request
					.getParameter("idDisciplina"));

			Double atividadePratica = Double.parseDouble(request
					.getParameter("atpratica"));
			Double projeto1 = Double.parseDouble(request
					.getParameter("projeto1"));
			Double projeto2 = Double.parseDouble(request
					.getParameter("projeto2"));

			Nota nota = notaDao.buscarNotaDoAluno(idAluno, idDisciplina);
			nota.setAtividadePratica(atividadePratica);
			nota.setProjeto1(projeto1);
			nota.setProjeto2(projeto2);

			notaDao.adicionar(nota);

			request.setAttribute("mensagem",
					"A nota do aluno foi realizada com sucesso.");
			request.getRequestDispatcher("cadNotas.jsp").forward(request,
					response);
		} catch (Exception e) {
			request.setAttribute("mensagem", "Erro: " + e.getMessage());
			request.getRequestDispatcher("cadNotas.jsp").forward(request,
					response);
		}
	}
}