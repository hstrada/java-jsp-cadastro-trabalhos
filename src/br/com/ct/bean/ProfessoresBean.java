package br.com.ct.bean;

import java.util.List;

import br.com.ct.dao.GenericDao;
import br.com.ct.entity.Professor;

public class ProfessoresBean {

	public List<Professor> getListaProfessores() {
		GenericDao<Professor> dao = new GenericDao<>(Professor.class);
		return dao.listar();
	}

}
