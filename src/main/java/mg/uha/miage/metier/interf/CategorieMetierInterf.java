package mg.uha.miage.metier.interf;

import java.util.List;

import mg.uha.miage.entities.Categorie;

public interface CategorieMetierInterf {
	public Integer ajoutCategorie(Categorie c);

	public void updateCategorie(Categorie c);

	public void deleteCategorie(Integer idC);

	public List<Categorie> listCategorie();

	public Categorie getCategorie(Integer idC);
}
