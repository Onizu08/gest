package mg.uha.miage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.CommandeDAOInterf;
import mg.uha.miage.entities.Commande;

@Transactional
public class CommandeDAOImpl implements CommandeDAOInterf {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Integer ajoutCommande(Commande s) {
		// TODO Auto-generated method stub
		em.persist(s);
		return s.getCommandeId();
	}

	@Override
	public void updateCommande(Commande s) {
		// TODO Auto-generated method stub
		em.merge(s);
	}

	@Override
	public void deleteCommande(Integer idS) {
		// TODO Auto-generated method stub
		Commande c = getCommande(idS);
		em.remove(c);
	}

	@Override
	public List<Commande> listCommande() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select s from Commande s");
		return req.getResultList();
	}

	@Override
	public Commande getCommande(Integer idS) {
		// TODO Auto-generated method stub
		return em.find(Commande.class, idS);
	}

}
