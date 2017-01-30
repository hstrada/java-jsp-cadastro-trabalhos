package br.com.ct.servlet.aluno;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ct.bean.AlunosBean;
import br.com.ct.dao.GenericDao;
import br.com.ct.entity.Aluno;
import br.com.ct.entity.Usuario;

@WebServlet("/aluno/listarNotas")
public class ServletListarNotas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletListarNotas() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = ((HttpServletRequest) request).getSession();

		Usuario u = (Usuario) session.getAttribute("session_u");
		GenericDao<Aluno> alunoDao = new GenericDao<>(Aluno.class);

		Aluno a = alunoDao.buscarAlunoPorIdUsuario(u.getId());

		AlunosBean alunosBean = new AlunosBean();
		
		request.setAttribute("notas", alunosBean.getListaNotasPorAluno(a.getId()));
		
		request.getRequestDispatcher("notas.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
