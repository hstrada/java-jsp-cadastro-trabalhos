package br.com.ct.bean;

import br.com.ct.dao.GenericDao;
import br.com.ct.entity.Nota;

public class NotasBean {

	public Nota getNotaDoAluno(int idAluno, int idDisciplina) {
		GenericDao<Nota> dao = new GenericDao<>(Nota.class);
		return dao.buscarNotaDoAluno(idAluno, idDisciplina);
	}

}
