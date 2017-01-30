package br.com.ct.dao;

import java.util.List;

public interface Dao<T> {
	T adicionar(T entidade);

	List<T> listar();

	T buscar(int id);
}
