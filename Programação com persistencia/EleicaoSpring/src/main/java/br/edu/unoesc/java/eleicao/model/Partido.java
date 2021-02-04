package br.edu.unoesc.java.eleicao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe que representa um partido
 * 
 * @author Roberson Alves
 *
 */
@Entity
@Table(name = "partido")
public class Partido implements Serializable {
	// os 3 atributos estão encapsulados
	@Id
	@GeneratedValue(generator = "partido_sq")
	@Column(name = "codpar")
	private Integer codigo;
	@Column(name = "nompar", nullable = false)
	private String nome;
	@Column(name = "sigpar", nullable = false)
	private String sigla;

	// construtor
	public Partido() {
		// não faz nada
	}

	// construtor
	public Partido(Integer codigo, String nome, String sigla) {
		this.codigo = codigo;
		this.nome = nome;
		this.sigla = sigla;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}