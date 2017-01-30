package br.com.ct.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;

	@Column(name = "NOME")
	private String nome;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIO", referencedColumnName = "id")
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDESCOLA", referencedColumnName = "id")
	private Escola escola;

	// @ManyToMany(fetch = FetchType.LAZY)
	// @JoinColumn(name = "IDDISCIPLINA", referencedColumnName = "id")
	// private Disciplina disciplina;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "PROFESSOR_DISCIPLINA", joinColumns = {
			@JoinColumn(name = "PROFESSOR_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "DISCIPLINA_ID", nullable = false, updatable = false) })
	private Set<Disciplina> disciplinas = new HashSet<>();

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
