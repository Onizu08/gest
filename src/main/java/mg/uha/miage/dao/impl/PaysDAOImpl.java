package mg.uha.miage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.PaysDAOInterf;
import mg.uha.miage.entities.Pays;

@Transactional
public class PaysDAOImpl implements PaysDAOInterf {

	@PersistenceContext
	private EntityManager em;

	@Override
	public String addPays(Pays p) {
		// TODO Auto-generated method stub
		em.persist(p);
		return p.getPaysId();
	}

	@Override
	public void updatePays(Pays p) {
		// TODO Auto-generated method stub
		em.merge(p);
	}

	@Override
	public void deletePays(String idP) {
		// TODO Auto-generated method stub
		Pays p = getPays(idP);
		em.remove(p);
	}

	@Override
	public List<Pays> listPays() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select p from Pays p");
		return req.getResultList();
	}

	@Override
	public Pays getPays(String idP) {
		// TODO Auto-generated method stub
		return em.find(Pays.class, idP);
	}

}
