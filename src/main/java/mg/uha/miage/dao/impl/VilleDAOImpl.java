package mg.uha.miage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.VilleDAOInterf;
import mg.uha.miage.entities.Ville;

@Transactional
public class VilleDAOImpl implements VilleDAOInterf {

	@PersistenceContext
	private EntityManager em;

	@Override
	public String ajoutVille(Ville v) {
		// TODO Auto-generated method stub

		em.persist(v);
		return v.getIdVille();
	}

	@Override
	public void updateVille(Ville v) {
		// TODO Auto-generated method stub
		em.merge(v);
	}

	@Override
	public void deleteVille(String idV) {
		// TODO Auto-generated method stub
		Ville v = getVille(idV);
		em.remove(v);
	}

	@Override
	public List<Ville> listVille() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select v from Ville v");
		System.out.println("retour liste");
		return req.getResultList();
	}

	@Override
	public Ville getVille(String idV) {
		// TODO Auto-generated method stub
		return em.find(Ville.class, idV);
	}

}
