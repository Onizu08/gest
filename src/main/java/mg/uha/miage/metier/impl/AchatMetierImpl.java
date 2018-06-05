package mg.uha.miage.metier.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.AchatDAOInterf;
import mg.uha.miage.entities.Achat;
import mg.uha.miage.metier.interf.AchatMetierInterf;

@Transactional

public class AchatMetierImpl implements AchatMetierInterf {

	private AchatDAOInterf achatDAO;

	public void setAchatDAO(AchatDAOInterf achatDAO) {
		this.achatDAO = achatDAO;
	}

	@Override
	public Integer ajoutAchat(Achat c) {
		// TODO Auto-generated method stub
		return achatDAO.ajoutAchat(c);
	}

	@Override
	public void updateAchat(Achat c) {
		// TODO Auto-generated method stub
		achatDAO.updateAchat(c);
	}

	@Override
	public void deleteAchat(Integer idC) {
		// TODO Auto-generated method stub
		achatDAO.deleteAchat(idC);
	}

	@Override
	public List<Achat> listAchat() {
		// TODO Auto-generated method stub
		return achatDAO.listAchat();
	}

	@Override
	public Achat getAchat(Integer idC) {
		// TODO Auto-generated method stub
		return achatDAO.getAchat(idC);
	}

}
