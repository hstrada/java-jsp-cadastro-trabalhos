package br.com.ct.bean;

import java.util.List;

import br.com.ct.dao.GenericDao;
import br.com.ct.entity.Escola;

public class EscolasBean {

	public List<Escola> getListaEscolas() {
		GenericDao<Escola> dao = new GenericDao<>(Escola.class);
		return dao.listar();
	}

}
