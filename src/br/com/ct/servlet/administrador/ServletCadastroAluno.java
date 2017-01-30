package br.com.ct.servlet.administrador;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ct.dao.GenericDao;
import br.com.ct.entity.Aluno;
import br.com.ct.entity.Curso;
import br.com.ct.entity.Disciplina;
import br.com.ct.entity.Nota;
import br.com.ct.entity.Perfil;
import br.com.ct.entity.Usuario;

@WebServlet("/admin/cadAluno")
public class ServletCadastroAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCadastroAluno() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cadAluno.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {

			GenericDao<Aluno> alunoDao = new GenericDao<>(Aluno.class);
			GenericDao<Usuario> usuarioDao = new GenericDao<>(Usuario.class);
			GenericDao<Curso> cursoDao = new GenericDao<>(Curso.class);
			GenericDao<Nota> notaDao = new GenericDao<>(Nota.class);

			String nome = request.getParameter("nome");
			String ra = request.getParameter("ra");
			String usuario = request.getParameter("usuario");
			String senha = request.getParameter("senha");
			Integer idCurso = Integer.parseInt(request.getParameter("curso"));

			// Curso c = new Curso();
			// c.setId(curso);

			Curso curso = cursoDao.buscar(idCurso);

			Usuario u = new Usuario();
			u.setUsuario(usuario);
			u.setSenha(senha);
			u.setPerfil(Perfil.ALUNO);

			Aluno aluno = new Aluno();
			aluno.setNome(nome);
			aluno.setRa(ra);
			aluno.setCurso(curso);

			aluno.setUsuario(usuarioDao.buscar(usuarioDao.adicionar(u).getId()));
			aluno = alunoDao.buscar(alunoDao.adicionar(aluno).getId());

			Collection<Disciplina> disciplinas = curso.getDisciplinas();
			for (Disciplina disciplina : disciplinas) {
				Nota nota = new Nota();
				nota.setAluno(aluno);
				nota.setDisciplina(disciplina);
				nota.setAtividadePratica(0d);
				nota.setProjeto1(0d);
				nota.setProjeto2(0d);
				notaDao.adicionar(nota);
			}

			request.setAttribute("mensagem", "O Aluno " + aluno.getNome()
					+ " foi cadastrado com sucesso.");
			request.getRequestDispatcher("cadAluno.jsp").forward(request,
					response);
		} catch (Exception e) {
			request.setAttribute("mensagem", "Erro: " + e.getMessage());
			request.getRequestDispatcher("cadAluno.jsp").forward(request,
					response);
		}
	}
}