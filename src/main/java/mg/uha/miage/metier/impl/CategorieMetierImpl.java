package mg.uha.miage.metier.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.CategorieDAOInterf;
import mg.uha.miage.entities.Categorie;
import mg.uha.miage.metier.interf.CategorieMetierInterf;

@Transactional
public class CategorieMetierImpl implements CategorieMetierInterf {
	private CategorieDAOInterf categorieDAO;

	public void setCategorieDAO(CategorieDAOInterf categorieDAO) {
		this.categorieDAO = categorieDAO;
	}

	@Override
	public Integer ajoutCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return categorieDAO.ajoutCategorie(c);
	}

	@Override
	public void updateCategorie(Categorie c) {
		// TODO Auto-generated method stub
		categorieDAO.updateCategorie(c);
	}

	@Override
	public void deleteCategorie(Integer idC) {
		// TODO Auto-generated method stub
		categorieDAO.deleteCategorie(idC);
	}

	@Override
	public List<Categorie> listCategorie() {
		// TODO Auto-generated method stub
		return categorieDAO.listCategorie();
	}

	@Override
	public Categorie getCategorie(Integer idC) {
		// TODO Auto-generated method stub
		return categorieDAO.getCategorie(idC);
	}

}
