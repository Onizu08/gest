package mg.uha.miage.metier.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.VilleDAOInterf;
import mg.uha.miage.entities.Ville;
import mg.uha.miage.metier.interf.VilleMetierInterf;

@Transactional
public class VilleMetierImpl implements VilleMetierInterf {

	private VilleDAOInterf villeDAO;

	public void setVilleDAO(VilleDAOInterf villeDAO) {
		this.villeDAO = villeDAO;
	}

	@Override
	public String ajoutVille(Ville v) {
		// TODO Auto-generated method stub
		return villeDAO.ajoutVille(v);
	}

	@Override
	public void updateVille(Ville v) {
		// TODO Auto-generated method stub
		villeDAO.updateVille(v);
	}

	@Override
	public void deleteVille(String idV) {
		// TODO Auto-generated method stub
		villeDAO.deleteVille(idV);
	}

	@Override
	public List<Ville> listVille() {
		// TODO Auto-generated method stub
		return villeDAO.listVille();
	}

	@Override
	public Ville getVille(String idV) {
		// TODO Auto-generated method stub
		return villeDAO.getVille(idV);
	}

}
