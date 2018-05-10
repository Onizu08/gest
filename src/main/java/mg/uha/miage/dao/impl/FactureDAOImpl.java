package mg.uha.miage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.FactureDAOInterf;
import mg.uha.miage.entities.Facture;

@Transactional
public class FactureDAOImpl implements FactureDAOInterf {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Integer addFacture(Facture f) {
		// TODO Auto-generated method stub
		em.persist(f);
		return f.getFactureId();
	}

	@Override
	public void updateFacture(Facture f) {
		// TODO Auto-generated method stub
		em.merge(f);
	}

	@Override
	public void deleteFacture(Integer idF) {
		// TODO Auto-generated method stub
		Facture f = getFactureId(idF);
		em.remove(f);
	}

	@Override
	public List<Facture> listFacture() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select f from Facture f");
		return req.getResultList();
	}

	@Override
	public Facture getFactureId(Integer idF) {
		// TODO Auto-generated method stub
		return em.find(Facture.class, idF);
	}

}
