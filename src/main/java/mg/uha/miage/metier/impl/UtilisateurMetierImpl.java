package mg.uha.miage.metier.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.UtilisateurDAOInterf;
import mg.uha.miage.entities.Utilisateur;
import mg.uha.miage.metier.interf.UtilisateurMetierInterf;

@Transactional
public class UtilisateurMetierImpl implements UtilisateurMetierInterf {
	private UtilisateurDAOInterf utilisateurDAO;

	public void setUtilisateurDAO(UtilisateurDAOInterf utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}

	@Override
	public Integer addUser(Utilisateur p) {
		// TODO Auto-generated method stub
		return utilisateurDAO.addUser(p);
	}

	@Override
	public void udpateUser(Utilisateur p) {
		// TODO Auto-generated method stub
		utilisateurDAO.udpateUser(p);
	}

	@Override
	public void deleteUser(Integer idP) {
		// TODO Auto-generated method stub
		utilisateurDAO.deleteUser(idP);
	}

	@Override
	public List<Utilisateur> listUser() {
		// TODO Auto-generated method stub
		return utilisateurDAO.listUser();
	}

	@Override
	public Utilisateur getUser(Integer idP) {
		// TODO Auto-generated method stub
		return utilisateurDAO.getUser(idP);
	}

}
