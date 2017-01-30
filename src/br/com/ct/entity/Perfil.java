package br.com.ct.entity;

public enum Perfil {

	ADMINISTRADOR(1), ALUNO(2), PROFESSOR(3);

	private int id;

	Perfil(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
