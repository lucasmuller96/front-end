package br.edu.unoesc.java.eleicao.model;

public class PartidoCandidatos {
	private Long total;
	private Partido partido;

	public PartidoCandidatos() {

	}

	public PartidoCandidatos(Long total, Partido partido) {
		this.total = total;
		this.partido = partido;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

}
