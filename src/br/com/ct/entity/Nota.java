package br.com.ct.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "nota")
public class Nota implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;

	@Column(name = "PROJETO1")
	private Double projeto1;

	@Column(name = "ATPRATICA")
	private Double atividadePratica;

	@Column(name = "PROJETO2")
	private Double projeto2;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDALUNO", referencedColumnName = "id")
	private Aluno aluno;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDDISCIPLINA", referencedColumnName = "id")
	private Disciplina disciplina;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getProjeto1() {
		return projeto1;
	}

	public void setProjeto1(Double projeto1) {
		this.projeto1 = projeto1;
	}

	public Double getAtividadePratica() {
		return atividadePratica;
	}

	public void setAtividadePratica(Double atividadePratica) {
		this.atividadePratica = atividadePratica;
	}

	public Double getProjeto2() {
		return projeto2;
	}

	public void setProjeto2(Double projeto2) {
		this.projeto2 = projeto2;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
