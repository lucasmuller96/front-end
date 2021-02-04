package br.edu.unoesc.java.eleicao.model;

import java.util.Date;

/**
 * Classe que representa os votos
 * 
 * @author Roberson Alves
 *
 */
public class Voto {
	private Long codigo;
	private Date data;
	private Long urna;
	private Candidato candidato;
	private Eleitor eleitor;

	/**
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * @return the urna
	 */
	public Long getUrna() {
		return urna;
	}

	/**
	 * @param urna the urna to set
	 */
	public void setUrna(Long urna) {
		this.urna = urna;
	}

	/**
	 * @return the candidato
	 */
	public Candidato getCandidato() {
		return candidato;
	}

	/**
	 * @param candidato the candidato to set
	 */
	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	/**
	 * @return the eleitor
	 */
	public Eleitor getEleitor() {
		return eleitor;
	}

	/**
	 * @param eleitor the eleitor to set
	 */
	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}

}
