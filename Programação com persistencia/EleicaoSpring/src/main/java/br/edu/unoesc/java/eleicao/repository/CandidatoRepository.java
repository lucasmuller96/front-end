package br.edu.unoesc.java.eleicao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.unoesc.java.eleicao.model.Candidato;
import br.edu.unoesc.java.eleicao.model.PartidoCandidatos;
import br.edu.unoesc.java.eleicao.model.PartidoCandidatosView;

// repositório de candidato = CandidatoDAO
public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {

	// busca por CPF
	@Query("select c from Candidato c where c.cpf = :cpf")
	List<Candidato> porCpf(@Param("cpf") Long cpf);

	// fazendo join entre candidato e partido
	@Query("select c from Candidato c inner join c.partido")
	List<Candidato> dadosCandidato();

	// contar os candidatos por partido
	@Query("select new br.edu.unoesc.java.eleicao.model.PartidoCandidatos(count(c), c.partido) "
			+ "from Candidato c group by c.partido")
	List<PartidoCandidatos> contaCandidatosPorPartido();

	// contar os candidatos por partido - usando projection
	@Query("select count(c) as total, p as partido "
			+ "from Candidato c inner join c.partido p group by p")
	List<PartidoCandidatosView> contaCandidatosPorPartidoProjection();
}
