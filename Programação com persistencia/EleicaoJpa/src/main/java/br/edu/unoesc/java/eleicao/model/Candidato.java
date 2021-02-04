package br.edu.unoesc.java.eleicao.model;

/**
 * Classe que representa um candidato
 * 
 * @author Roberson Alves
 *
 */
public class Candidato implements Validador {
	private Integer codigoRegistro;
	private String nome;
	private Long cpf;
	private Partido partido; // o objeto do Partido
	private Cargo cargo;

	/**
	 * @return the codigoRegistro
	 */
	public Integer getCodigoRegistro() {
		return codigoRegistro;
	}

	/**
	 * @param codigoRegistro the codigoRegistro to set
	 */
	public void setCodigoRegistro(Integer codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cpf
	 */
	public Long getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the partido
	 */
	public Partido getPartido() {
		return partido;
	}

	/**
	 * @param partido the partido to set
	 */
	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	/**
	 * @return the cargo
	 */
	public Cargo getCargo() {
		return cargo;
	}

	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public boolean validarDocumento(Long numero) {
		return numero > 10; // número maior que 10
	}

}
