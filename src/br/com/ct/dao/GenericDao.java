package br.com.ct.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.ct.entity.Aluno;
import br.com.ct.entity.Disciplina;
import br.com.ct.entity.Nota;
import br.com.ct.entity.Professor;
import br.com.ct.entity.Usuario;

public class GenericDao<T> implements Dao<T> {

	private final Class<T> classe;
	protected EntityManager em;

	public GenericDao(Class<T> classe) {
		this.classe = classe;
	}

	@Override
	public T adicionar(T entidade) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		T t = em.merge(entidade);
		em.getTransaction().commit();
		em.close();

		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listar() {
		em = JpaUtil.getEntityManager();
		return em.createQuery("From " + classe.getSimpleName()).getResultList();
	}

	@Override
	public T buscar(int id) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		T entidade = em.find(classe, id);

		return entidade;
	}

	public Usuario buscarUsuario(String usuario, String senha) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em
				.createQuery("select u from Usuario u where usuario = :usuario and senha = :senha");
		query.setParameter("usuario", usuario);
		query.setParameter("senha", senha);
		return (Usuario) query.getSingleResult();
	}

	public Professor buscarProfessorPorIdUsuario(int idUsuario) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em
				.createQuery("select p from Professor p where p.usuario.id = :idUsuario");
		query.setParameter("idUsuario", idUsuario);
		return (Professor) query.getSingleResult();
	}

	public Aluno buscarAlunoPorIdUsuario(int idUsuario) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em
				.createQuery("select a from Aluno a where a.usuario.id = :idUsuario");
		query.setParameter("idUsuario", idUsuario);
		return (Aluno) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> listarAlunosPorIdDisciplina(int idDisciplina) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();

		Query query = em
				.createQuery("select n.aluno from Nota n where n.disciplina.id = :idDisciplina ");

		query.setParameter("idDisciplina", idDisciplina);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Disciplina> listarDisciplinasPorIdProfessor(int idProfessor) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();

		Query query = em
				.createQuery("select d.id as id, d.nome as nome from Disciplina d join d.professores p where p.id = :idProfessor");
		query.setParameter("idProfessor", idProfessor);

		return query.getResultList();
	}

	public Nota buscarNotaDoAluno(int idAluno, int idDisciplina) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em
				.createQuery("select n from Nota n where n.aluno.id = :idAluno and n.disciplina.id = :idDisciplina");
		query.setParameter("idAluno", idAluno);
		query.setParameter("idDisciplina", idDisciplina);
		return (Nota) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Nota> listarNotasPorAluno(int idAluno) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();

		Query query = em
				.createQuery("select n.atividadePratica, n.projeto1, n.projeto2 from Nota n where n.aluno.id = :idAluno");
		query.setParameter("idAluno", idAluno);

		return query.getResultList();
	}

}
