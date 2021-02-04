package br.edu.unoesc.java.eleicao.ui;

import java.util.List;

import br.edu.unoesc.java.eleicao.dao.impl.jpa.PartidoDAOJpa;
import br.edu.unoesc.java.eleicao.model.Partido;

/**
 * Executa a aplicação da Eleição
 * 
 * @author Roberson Alves
 *
 */
public class EleicaoApp {
	public static void main(String[] args) {
		PartidoDAOJpa partidoDAOJpa = new PartidoDAOJpa();
		
		// cadastrar um novo partido
		Partido p = new Partido();
		p.setNome("Partido teste db");
		p.setSigla("ptdb");
		partidoDAOJpa.salvar(p);
		
		Partido p3 = new Partido();
		p3.setNome("partido 2");
		p3.setSigla("Pablo");
		System.out.println(p3.getNome());
		partidoDAOJpa.salvar(p3);
		
		// excluir
		p = partidoDAOJpa.get(6);
		partidoDAOJpa.excluir(p);
		
		// listar todos os partidos
		List<Partido> partidos = partidoDAOJpa.listar();
		for (Partido partido : partidos) {
			System.out.println(partido.getNome() + " - "
					+ partido.getSigla());
			
			
		}
		
	}
	
	
	
}
