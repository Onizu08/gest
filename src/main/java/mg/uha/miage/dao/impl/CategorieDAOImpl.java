package mg.uha.miage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.CategorieDAOInterf;
import mg.uha.miage.entities.Categorie;
import mg.uha.miage.entities.Payer;

@Transactional
public class CategorieDAOImpl implements CategorieDAOInterf {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Integer ajoutCategorie(Categorie c) {
		// TODO Auto-generated method stub
		em.persist(c);
		return c.getCategorieId();
	}

	@Override
	public void updateCategorie(Categorie c) {
		// TODO Auto-generated method stub
		em.merge(c);
	}

	@Override
	public void deleteCategorie(Integer idC) {
		// TODO Auto-generated method stub
		Categorie c = getCategorie(idC);
		em.remove(c);
	}

	@Override
	public List<Categorie> listCategorie() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select c from Categorie c ");
		return req.getResultList();
	}

	@Override
	public Categorie getCategorie(Integer idC) {
		// TODO Auto-generated method stub

		return em.find(Categorie.class, idC);
	}

}
