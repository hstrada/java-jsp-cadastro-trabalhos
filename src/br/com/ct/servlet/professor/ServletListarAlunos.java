package br.com.ct.servlet.professor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ct.bean.AlunosBean;

@WebServlet("/professor/listarAlunos")
public class ServletListarAlunos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletListarAlunos() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));

			AlunosBean alunosBean = new AlunosBean();

			request.setAttribute("alunos", alunosBean.getListaAlunosPorIdDisciplina(id));
			request.setAttribute("disciplina", id);

			request.getRequestDispatcher("listarAlunos.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}