package mg.uha.miage.metier.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.PaysDAOInterf;
import mg.uha.miage.entities.Pays;
import mg.uha.miage.metier.interf.PaysMetierInterf;

@Transactional
public class PaysMetierImpl implements PaysMetierInterf {

	private PaysDAOInterf paysDAO;

	public void setPaysDAO(PaysDAOInterf paysDAO) {
		this.paysDAO = paysDAO;
	}

	@Override
	public String addPays(Pays p) {
		// TODO Auto-generated method stub
		return paysDAO.addPays(p);
	}

	@Override
	public void updatePays(Pays p) {
		// TODO Auto-generated method stub
		paysDAO.updatePays(p);
	}

	@Override
	public void deletePays(String idP) {
		// TODO Auto-generated method stub
		paysDAO.deletePays(idP);
	}

	@Override
	public List<Pays> listPays() {
		// TODO Auto-generated method stub
		return paysDAO.listPays();
	}

	@Override
	public Pays getPays(String idP) {
		// TODO Auto-generated method stub
		return paysDAO.getPays(idP);
	}

}
