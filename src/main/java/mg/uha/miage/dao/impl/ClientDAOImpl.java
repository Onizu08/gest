package mg.uha.miage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.ClientDAOInterf;
import mg.uha.miage.entities.Client;

@Transactional
public class ClientDAOImpl implements ClientDAOInterf {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Integer ajoutClient(Client c) {
		// TODO Auto-generated method stub
		em.persist(c);
		return c.getClientId();
	}

	@Override
	public void updateClient(Client c) {
		// TODO Auto-generated method stub
		em.merge(c);
	}

	@Override
	public void deleteClient(Integer idC) {
		// TODO Auto-generated method stub
		Client c = getClient(idC);
		em.remove(c);
	}

	@Override
	public List<Client> listClient() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select c from Client c");
		return req.getResultList();
	}

	@Override
	public Client getClient(Integer idC) {
		// TODO Auto-generated method stub
		return em.find(Client.class, idC);
	}

}
