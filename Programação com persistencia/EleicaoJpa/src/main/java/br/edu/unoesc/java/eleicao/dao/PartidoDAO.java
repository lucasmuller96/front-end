package br.edu.unoesc.java.eleicao.dao;

import java.util.List;

import br.edu.unoesc.java.eleicao.model.Partido;

public interface PartidoDAO {
	public boolean salvar(final Partido partido);

	public boolean excluir(final Partido partido);

	public List<Partido> listar();

	public List<Partido> listarPorNome(String nome);
	
	public Partido get(Integer codigo);

}
