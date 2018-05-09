package mg.uha.miage.dao.impl;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.SocieteDAOInterf;
import mg.uha.miage.entities.Societe;

@Transactional
public class SocieteDAOImpl implements SocieteDAOInterf {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Integer ajoutSociete(Societe s) {
		// TODO Auto-generated method stub
		em.persist(s);
		return s.getSocieteId();
	}

	@Override
	public void updateSociete(Societe s) {
		// TODO Auto-generated method stub
		em.merge(s);
	}

	@Override
	public void deleteSociete(Integer idS) {
		// TODO Auto-generated method stub
		Societe s = getSociete(idS);
		em.remove(s);
	}

	@Override
	public List<Societe> listSociete() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select s from Societe s");
		return req.getResultList();
	}

	@Override
	public Societe getSociete(Integer idS) {
		// TODO Auto-generated method stub
		return em.find(Societe.class, idS);
	}

}
