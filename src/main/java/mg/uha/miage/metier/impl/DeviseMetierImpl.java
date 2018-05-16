package mg.uha.miage.metier.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.DeviseDAOInterf;
import mg.uha.miage.entities.Devise;
import mg.uha.miage.metier.interf.DeviseMetierInterf;

@Transactional
public class DeviseMetierImpl implements DeviseMetierInterf {

	private DeviseDAOInterf deviseDAO;

	public void setDeviseDAO(DeviseDAOInterf deviseDAO) {
		this.deviseDAO = deviseDAO;
	}

	@Override
	public String addDevise(Devise d) {
		// TODO Auto-generated method stub
		return deviseDAO.addDevise(d);
	}

	@Override
	public void updateDevise(Devise d) {
		// TODO Auto-generated method stub
		deviseDAO.updateDevise(d);
	}

	@Override
	public void deleteDEvise(String idD) {
		// TODO Auto-generated method stub
		deviseDAO.deleteDEvise(idD);
	}

	@Override
	public List<Devise> listDevise() {
		// TODO Auto-generated method stub
		return deviseDAO.listDevise();
	}

	@Override
	public Devise getDevise(String idD) {
		// TODO Auto-generated method stub
		return deviseDAO.getDevise(idD);
	}

}
