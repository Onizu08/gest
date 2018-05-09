package mg.uha.miage.metier.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.SocieteDAOInterf;
import mg.uha.miage.entities.Societe;
import mg.uha.miage.metier.interf.SocieteMetierInterf;

@Transactional
public class SocieteMetierImpl implements SocieteMetierInterf {

	private SocieteDAOInterf societeDAO;

	public void setSocieteDAO(SocieteDAOInterf societeDAO) {
		this.societeDAO = societeDAO;
	}

	@Override
	public Integer ajoutSociete(Societe s) {
		// TODO Auto-generated method stub
		return societeDAO.ajoutSociete(s);
	}

	@Override
	public void updateSociete(Societe s) {
		// TODO Auto-generated method stub
		societeDAO.updateSociete(s);
	}

	@Override
	public void deleteSociete(Integer idS) {
		// TODO Auto-generated method stub
		societeDAO.deleteSociete(idS);
	}

	@Override
	public List<Societe> listSociete() {
		// TODO Auto-generated method stub
		return societeDAO.listSociete();
	}

	@Override
	public Societe getSociete(Integer idS) {
		// TODO Auto-generated method stub
		return societeDAO.getSociete(idS);
	}

}
