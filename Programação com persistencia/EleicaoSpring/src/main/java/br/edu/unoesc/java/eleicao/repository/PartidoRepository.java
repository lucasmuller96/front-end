package br.edu.unoesc.java.eleicao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.java.eleicao.model.Partido;

// repositório de partido = PartidoDAO
public interface EleitorRepository extends JpaRepository<Partido, Integer> {
	List<Partido> findByNomeLike(String nome);
}
