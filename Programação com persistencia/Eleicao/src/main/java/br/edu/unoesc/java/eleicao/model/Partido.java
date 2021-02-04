package br.edu.unoesc.java.eleicao.model;

/**
 * Classe que representa um partido
 * 
 * @author Roberson Alves
 *
 */
public class Partido {
	// os 3 atributos estão encapsulados
	private Integer codigo;
	private String nome;
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