package mg.uha.miage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.DeviseDAOInterf;
import mg.uha.miage.entities.Devise;

@Transactional
public class DeviseDAOImpl implements DeviseDAOInterf {

	@PersistenceContext
	private EntityManager em;

	@Override
	public String addDevise(Devise d) {
		// TODO Auto-generated method stub
		em.persist(d);
		return d.getDeviseId();
	}

	@Override
	public void updateDevise(Devise d) {
		// TODO Auto-generated method stub
		em.merge(d);
	}

	@Override
	public void deleteDEvise(String idD) {
		// TODO Auto-generated method stub
		Devise d = getDevise(idD);
		em.remove(d);
	}

	@Override
	public List<Devise> listDevise() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select d from Devise d");
		return req.getResultList();
	}

	@Override
	public Devise getDevise(String idD) {
		// TODO Auto-generated method stub
		return em.find(Devise.class, idD);
	}

}
