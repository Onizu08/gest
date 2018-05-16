package mg.uha.miage.metier.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.CommandeDAOInterf;
import mg.uha.miage.entities.Commande;
import mg.uha.miage.metier.interf.CommandeMetierInterf;

@Transactional
public class CommandeMetierImpl implements CommandeMetierInterf {

	private CommandeDAOInterf commandeDAO;

	public void setCommandeDAO(CommandeDAOInterf commandeDAO) {
		this.commandeDAO = commandeDAO;
	}

	@Override
	public Integer ajoutCommande(Commande s) {
		// TODO Auto-generated method stub
		return commandeDAO.ajoutCommande(s);
	}

	@Override
	public void updateCommande(Commande s) {
		// TODO Auto-generated method stub
		commandeDAO.updateCommande(s);
	}

	@Override
	public void deleteCommande(Integer idS) {
		// TODO Auto-generated method stub
		commandeDAO.deleteCommande(idS);
	}

	@Override
	public List<Commande> listCommande() {
		// TODO Auto-generated method stub
		return commandeDAO.listCommande();
	}

	@Override
	public Commande getCommande(Integer idS) {
		// TODO Auto-generated method stub
		return commandeDAO.getCommande(idS);
	}

}
