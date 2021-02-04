package br.edu.unoesc.java.eleicao.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.edu.unoesc.java.eleicao.model.Candidato;
import br.edu.unoesc.java.eleicao.model.Cargo;
import br.edu.unoesc.java.eleicao.model.Partido;
import br.edu.unoesc.java.eleicao.model.PartidoCandidatos;
import br.edu.unoesc.java.eleicao.model.PartidoCandidatosView;
import br.edu.unoesc.java.eleicao.repository.CandidatoRepository;
import br.edu.unoesc.java.eleicao.repository.PartidoRepository;

/**
 * Executa a aplicação da Eleição
 * 
 * @author Roberson Alves
 *
 */
@SpringBootApplication
@EnableJpaRepositories({ "br.edu.unoesc.java.eleicao.repository" })
@EntityScan({ "br.edu.unoesc.java.eleicao.model" })
public class EleicaoApp implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(EleicaoApp.class, args);
	}

	@Autowired
	private PartidoRepository partidoRepository;
	@Autowired
	private CandidatoRepository candidatoRepository;

	@Override
	public void run(String... args) throws Exception {
		// aqui eu escrevo a minha lógica
		Partido p = new Partido();
		p.setNome("Partido do Spring Data");
		p.setSigla("PSD");

		partidoRepository.save(p);

		List<Partido> partidos = partidoRepository.findByNomeLike("% do %");
		for (Partido partido : partidos) {
			System.out.println(partido.getCodigo() + " - " + partido.getNome());
		}

		Candidato c = new Candidato();
		c.setCpf(5l);
		c.setNome("Candidato Perdido");
		c.setPartido(p);
		c.setCargo(Cargo.DEPUTADO_FEDERAL);
		candidatoRepository.save(c);

//		List<Candidato> candidatos = candidatoRepository.dadosCandidato();
//		for (Candidato candidato : candidatos) {
//			System.out.println(candidato.getNome() + " - " +
//					candidato.getCargo().toString());
//		}

		List<Candidato> candidatos = candidatoRepository.porCpf(5l);
		for (Candidato candidato : candidatos) {
			System.out.println(candidato.getNome() + " - " + candidato.getCargo().toString());
		}

		List<PartidoCandidatosView> contaPartidosProjection = candidatoRepository.contaCandidatosPorPartidoProjection();
		for (PartidoCandidatosView partidoCandidatosView : contaPartidosProjection) {
			System.out.println(partidoCandidatosView.getPartido().getNome() + " - "
					 + partidoCandidatosView.getTotal());
		}

		List<PartidoCandidatos> contaPartidos = candidatoRepository.contaCandidatosPorPartido();
		for (PartidoCandidatos partidoCandidatos : contaPartidos) {
			System.out.println(partidoCandidatos.getPartido().getNome() + " - " + partidoCandidatos.getTotal());
		}
	}
}
