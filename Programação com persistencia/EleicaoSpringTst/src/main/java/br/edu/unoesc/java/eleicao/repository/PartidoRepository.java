package br.edu.unoesc.java.eleicao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.java.eleicao.model.Partido;

/**
 * @author rober
 *
 */
public interface PartidoRepository extends JpaRepository<Partido, Integer> {
	public List<Partido> findByNomeLike(String nome);
}
