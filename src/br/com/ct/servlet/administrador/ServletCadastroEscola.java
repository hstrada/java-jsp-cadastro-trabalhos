package br.com.ct.servlet.administrador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ct.dao.GenericDao;
import br.com.ct.entity.Escola;

@WebServlet("/admin/cadEscola")
public class ServletCadastroEscola extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCadastroEscola() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("cadEscola.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nome = request.getParameter("nome");

			Escola escola = new Escola();
			escola.setNome(nome);

			GenericDao<Escola> dao = new GenericDao<>(Escola.class);
			dao.adicionar(escola);

			request.setAttribute("mensagem", "A escola " + escola.getNome() + " foi incluída com sucesso.");
			request.getRequestDispatcher("cadEscola.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("mensagem", "Erro: " + e.getMessage());
			request.getRequestDispatcher("cadEscola.jsp").forward(request, response);
		}
	}
}