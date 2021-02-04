package br.edu.unoesc.java.eleicao.ui;

import java.util.List;

import br.edu.unoesc.java.eleicao.dao.impl.jdbc.Conexao;
import br.edu.unoesc.java.eleicao.dao.impl.jdbc.PartidoDAOJdbc;
import br.edu.unoesc.java.eleicao.model.Candidato;
import br.edu.unoesc.java.eleicao.model.Cargo;
import br.edu.unoesc.java.eleicao.model.Partido;

/**
 * Executa a aplicação da Eleição
 * 
 * @author Roberson Alves
 *
 */
public class EleicaoApp {

	public static void main(String[] args) {
		// Conexão na base de dados - testar a conexão
		Conexao.conectar("jdbc:postgresql:eleicaodb", "sysdba", "L$5a7*(B", "org.postgresql.Driver");
		
		// criação de um novo partido

		Partido partido = new Partido(10, "Partido", "PRT");
		// dados do partido
		System.out.println("-----------------------");
		System.out.println(partido.getNome());
		System.out.println(partido.getSigla());
		
		PartidoDAOJdbc partidoDAO = new PartidoDAOJdbc();
		partidoDAO.salvar(partido);		
		
		Partido partido1 = new Partido();
		partido1.setCodigo(20);
		partido1.setNome("Partido da TI");
		partido1.setSigla("PTI");
		
		partidoDAO.salvar(partido1);
		
		Partido partido3 = new Partido();
		partido3.setCodigo(50);
		partido3.setNome("Lucas");
		partido3.setSigla("LCA");
		PartidoDAOJdbc partiDAO = new PartidoDAOJdbc();
		partiDAO.salvar(partido3);
		System.out.println(partido3.getNome());
		System.out.println(partido3.getSigla());
		
		
		List<Partido> partidos = partidoDAO.listar();
		for (Partido partido2 : partidos) {
			System.out.println(partido2.getNome());
		}
		
		
		System.out.println("-----------------------");
		System.out.println(partido1.getNome());
		System.out.println(partido1.getSigla());
		
		
//		
//		PartidoDAO partidoDao = new PartidoDAOJdbc();
//		partidoDao.salvar(partido);

		Candidato candidato = new Candidato();
		candidato.setCodigoRegistro(123);
		candidato.setCpf(123L);
		candidato.setNome("Candidato");
		candidato.setPartido(partido);
		candidato.setCargo(Cargo.GOVERNADOR);

		// dados do candidato
		System.out.println("-----------------------");
		System.out.println(candidato.getCpf());
		System.out.println(candidato.getCargo().toString());
//		// acessando dados do partido a partir de candidato
//		System.out.println(candidato.getPartido().getSigla());
//		System.out.println(candidato.getCargo().toString());
//
//		// testando a funcionalida da interface de validar documentos
//		if (candidato.validarDocumento(candidato.getCpf()))
//			System.out.println("Válido!");
//		else
//			System.out.println("Inválido!");
	}
}
