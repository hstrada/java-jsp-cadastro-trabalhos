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
import javax.persistence.Transient;

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

	@Transient
	private Double media;

	@Transient
	private boolean aprovado = false;

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

	public Double getMedia() {
		double p1 = projeto1 * 0.3;
		double p2 = projeto2 * 0.4;
		double ap = atividadePratica * 0.3;
		double media = p1 + p2 + ap;

		if (media >= 7) {
			this.aprovado = true;
		} else {
			this.aprovado = false;
		}

		return media;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public String getAprovadoDescricao() {
		if (aprovado = false)
			return "Reprovado";
		else
			return "Aprovado";
	}

}
