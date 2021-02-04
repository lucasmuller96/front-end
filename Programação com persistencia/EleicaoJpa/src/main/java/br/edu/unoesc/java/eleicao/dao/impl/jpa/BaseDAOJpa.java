package br.edu.unoesc.java.eleicao.dao.impl.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseDAOJpa {
	protected EntityManagerFactory factory = null;
	protected EntityManager entityManager = null;

	public BaseDAOJpa() {
		factory = Persistence.createEntityManagerFactory("EleicaoDB");
		entityManager = factory.createEntityManager();
	}
}
