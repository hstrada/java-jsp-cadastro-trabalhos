package br.com.ct.bean;

import java.util.List;

import br.com.ct.dao.GenericDao;
import br.com.ct.entity.Aluno;
import br.com.ct.entity.Nota;

public class AlunosBean {

	public List<Aluno> getListaAlunos() {
		GenericDao<Aluno> dao = new GenericDao<>(Aluno.class);
		return dao.listar();
	}

	public List<Aluno> getListaAlunosPorIdDisciplina(int idDisciplina) {
		GenericDao<Aluno> dao = new GenericDao<>(Aluno.class);
		return dao.listarAlunosPorIdDisciplina(idDisciplina);
	}

	public List<Nota> getListaNotasPorAluno(int idAluno) {
		GenericDao<Nota> dao = new GenericDao<>(Nota.class);
		return dao.listarNotasPorAluno(idAluno);
	}

}
