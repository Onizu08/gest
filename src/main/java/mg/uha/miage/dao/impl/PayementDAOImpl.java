package mg.uha.miage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.PayementDAOInterf;
import mg.uha.miage.entities.Payer;

@Transactional
public class PayementDAOImpl implements PayementDAOInterf {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Integer addPayement(Payer p) {
		// TODO Auto-generated method stub
		em.persist(p);
		return p.getPaymentId();
	}

	@Override
	public void updatePayement(Payer p) {
		// TODO Auto-generated method stub
		em.merge(p);
	}

	@Override
	public void deletePayement(Integer idP) {
		// TODO Auto-generated method stub
		Payer p = getPayement(idP);
		em.remove(p);
	}

	@Override
	public List<Payer> listPayement() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select p from Payer p ");
		return req.getResultList();
	}

	@Override
	public Payer getPayement(Integer idP) {
		// TODO Auto-generated method stub
		return em.find(Payer.class, idP);
	}

	@Override
	public void insertioPayement(Integer valFacture, Integer valClient) {
		// TODO Auto-generated method stub

		StoredProcedureQuery req = em.createStoredProcedureQuery("INSERTIONPAIEMENT")
				.registerStoredProcedureParameter("VALFACTURE", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("VALCLIENT", Integer.class, ParameterMode.IN)
				.setParameter("VALFACTURE", valFacture).setParameter("VALCLIENT", valClient);
		req.execute();
	}

}
