package mg.uha.miage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.UtilisateurDAOInterf;
import mg.uha.miage.entities.Utilisateur;

@Transactional
public class UtilisateurDAOImpl implements UtilisateurDAOInterf {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Integer addUser(Utilisateur p) {
		// TODO Auto-generated method stub
		em.persist(p);
		return p.getUtilisateurId();
	}

	@Override
	public void udpateUser(Utilisateur p) {
		// TODO Auto-generated method stub
		em.merge(p);
	}

	@Override
	public void deleteUser(Integer idP) {
		// TODO Auto-generated method stub
		Utilisateur u = getUser(idP);
		em.remove(u);
	}

	@Override
	public List<Utilisateur> listUser() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select u from Utilisateur u");
		return req.getResultList();
	}

	@Override
	public Utilisateur getUser(Integer idP) {
		// TODO Auto-generated method stub
		return em.find(Utilisateur.class, idP);
	}
}
