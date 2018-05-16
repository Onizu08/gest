package mg.uha.miage.dao.interf;

import java.util.List;

import mg.uha.miage.entities.Commande;

public interface CommandeDAOInterf {

	public Integer ajoutCommande(Commande s);

	public void updateCommande(Commande s);

	public void deleteCommande(Integer idS);

	public List<Commande> listCommande();

	public Commande getCommande(Integer idS);
}
