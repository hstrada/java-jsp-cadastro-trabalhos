package br.com.ct.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "escola")
public class Escola implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "NOME")
	private String nome;

	// @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	// "escola")
	// private List<Curso> cursos = new ArrayList<Curso>();
	//
	// @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	// "escola")
	// private List<Professor> professores = new ArrayList<Professor>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// public List<Curso> getCursos() {
	// return cursos;
	// }
	//
	// public void setCursos(List<Curso> cursos) {
	// this.cursos = cursos;
	// }
	//
	// public List<Professor> getProfessores() {
	// return professores;
	// }
	//
	// public void setProfessores(List<Professor> professores) {
	// this.professores = professores;
	// }

}
