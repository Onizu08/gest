package mg.uha.miage.metier.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.ProfilDAOInterf;
import mg.uha.miage.entities.Profil;
import mg.uha.miage.metier.interf.ProfilMetierInterf;

@Transactional
public class ProfilMetierImpl implements ProfilMetierInterf {

	private ProfilDAOInterf profilDAO;

	public void setProfilDAO(ProfilDAOInterf profilDAO) {
		this.profilDAO = profilDAO;
	}

	@Override
	public Integer addProfil(Profil p) {
		// TODO Auto-generated method stub
		return profilDAO.addProfil(p);
	}

	@Override
	public void udpateProfil(Profil p) {
		// TODO Auto-generated method stub
		profilDAO.udpateProfil(p);
	}

	@Override
	public void deleteProfil(Integer idP) {
		// TODO Auto-generated method stub
		profilDAO.deleteProfil(idP);
	}

	@Override
	public List<Profil> listProfil() {
		// TODO Auto-generated method stub
		return profilDAO.listProfil();
	}

	@Override
	public Profil getProfil(Integer idP) {
		// TODO Auto-generated method stub
		return profilDAO.getProfil(idP);
	}

}
