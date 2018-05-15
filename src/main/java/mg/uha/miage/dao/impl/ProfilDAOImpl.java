package mg.uha.miage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.ProfilDAOInterf;
import mg.uha.miage.entities.Profil;

@Transactional
public class ProfilDAOImpl implements ProfilDAOInterf {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Integer addProfil(Profil p) {
		// TODO Auto-generated method stub
		em.persist(p);
		return p.getProfileId();
	}

	@Override
	public void udpateProfil(Profil p) {
		// TODO Auto-generated method stub
		em.merge(p);
	}

	@Override
	public void deleteProfil(Integer idP) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Profil> listProfil() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select p from Profil p");
		return req.getResultList();
	}

	@Override
	public Profil getProfil(Integer idP) {
		// TODO Auto-generated method stub
		return em.find(Profil.class, idP);
	}

}
