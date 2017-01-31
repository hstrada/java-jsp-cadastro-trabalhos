package br.com.ct.bean;

import java.util.List;

import br.com.ct.dao.GenericDao;
import br.com.ct.entity.Disciplina;

public class DisciplinasBean {

	public List<Disciplina> getListaDisciplinas() {
		GenericDao<Disciplina> dao = new GenericDao<>(Disciplina.class);
		return dao.listar();
	}

	public List<Disciplina> getListaDisciplinasPorProfessor(int idProfessor) {
		GenericDao<Disciplina> dao = new GenericDao<>(Disciplina.class);
		return dao.listarDisciplinasPorIdProfessor(idProfessor);
	}

	public List<Disciplina> getListaDisciplinasPorAluno(int idAluno) {
		GenericDao<Disciplina> dao = new GenericDao<>(Disciplina.class);
		return dao.listarDisciplinasPorIdAluno(idAluno);
	}

}
