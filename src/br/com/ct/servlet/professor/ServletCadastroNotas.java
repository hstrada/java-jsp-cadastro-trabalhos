package br.com.ct.servlet.professor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ct.dao.GenericDao;
import br.com.ct.entity.Aluno;
import br.com.ct.entity.Curso;
import br.com.ct.entity.Perfil;
import br.com.ct.entity.Usuario;

@WebServlet("/professor/cadNotas")
public class ServletCadastroNotas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCadastroNotas() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.getRequestDispatcher("listarAlunos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nome = request.getParameter("nome");
			String ra = request.getParameter("ra");
			String usuario = request.getParameter("usuario");
			String senha = request.getParameter("senha");
			Integer curso = Integer.parseInt(request.getParameter("curso"));

			Curso c = new Curso();
			c.setId(curso);

			Usuario u = new Usuario();
			u.setUsuario(usuario);
			u.setSenha(senha);
			u.setPerfil(Perfil.ALUNO);
			
			// TODO testar se ao inserir um aluno, eu preciso ou não também adicionar um usuario
			
			Aluno aluno = new Aluno();
			aluno.setNome(nome);
			aluno.setRa(ra);
			aluno.setCurso(c);

			GenericDao<Aluno> dao = new GenericDao<>(Aluno.class);
			GenericDao<Usuario> usuarioDao = new GenericDao<>(Usuario.class);
			aluno.setUsuario(usuarioDao.buscar(usuarioDao.adicionar(u).getId()));
			dao.adicionar(aluno);

			request.setAttribute("mensagem", "O Aluno " + aluno.getNome() + " foi cadastrado com sucesso.");
			request.getRequestDispatcher("cadAluno.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("mensagem", "Erro: " + e.getMessage());
			request.getRequestDispatcher("cadAluno.jsp").forward(request, response);
		}
	}
}