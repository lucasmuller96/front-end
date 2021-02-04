package br.edu.unoesc.java.eleicao.dao.impl.jpa;

import java.util.List;

import br.edu.unoesc.java.eleicao.dao.PartidoDAO;
import br.edu.unoesc.java.eleicao.model.Partido;

/**
 * @author rober
 *
 */
public class PartidoDAOJpa extends BaseDAOJpa implements PartidoDAO {
	@Override
	public boolean salvar(final Partido partido) {
		try {
			entityManager.getTransaction().begin();
			// salvar no banco de dados
			entityManager.persist(partido);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean excluir(final Partido partido) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(partido);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Partido> listar() {
		try {
			// jpaql - jpa query language
			return entityManager.createQuery("select p from Partido p", Partido.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Partido> listarPorNome(String nome) {
		try {
			// jpaql - jpa query language
			return entityManager.createQuery("select p from Partido p where nome like :nome", Partido.class)
					.setParameter("nome", "%" + nome + "%").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Partido get(Integer codigo) {
		return entityManager.find(Partido.class, codigo);
	}

}
