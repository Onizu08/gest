package mg.uha.miage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.AchatDAOInterf;
import mg.uha.miage.entities.Achat;

@Transactional
public class AchatDAOImpl implements AchatDAOInterf {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Integer ajoutAchat(Achat c) {
		// TODO Auto-generated method stub
		em.persist(c);
		return c.getAchatId();
	}

	@Override
	public void updateAchat(Achat c) {
		// TODO Auto-generated method stub
		em.merge(c);
	}

	@Override
	public void deleteAchat(Integer idC) {
		// TODO Auto-generated method stub
		Achat c = getAchat(idC);
		em.remove(c);
	}

	@Override
	public List<Achat> listAchat() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select a from Achat a");
		return req.getResultList();
	}

	@Override
	public Achat getAchat(Integer idC) {
		// TODO Auto-generated method stub
		return em.find(Achat.class, idC);
	}

}
