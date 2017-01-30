package br.com.ct.bean;

import java.util.List;

import br.com.ct.dao.GenericDao;
import br.com.ct.entity.Curso;

public class CursosBean {

	public List<Curso> getListaCursos() {
		GenericDao<Curso> dao = new GenericDao<>(Curso.class);
		return dao.listar();
	}

}
