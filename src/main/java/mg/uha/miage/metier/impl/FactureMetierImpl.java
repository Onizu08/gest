package mg.uha.miage.metier.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.FactureDAOInterf;
import mg.uha.miage.entities.Facture;
import mg.uha.miage.metier.interf.FactureMetierInterf;

@Transactional
public class FactureMetierImpl implements FactureMetierInterf {

	private FactureDAOInterf factureDAO;

	public void setFactureDAO(FactureDAOInterf factureDAO) {
		this.factureDAO = factureDAO;
	}

	@Override
	public Integer addFacture(Facture f) {
		// TODO Auto-generated method stub
		return factureDAO.addFacture(f);
	}

	@Override
	public void updateFacture(Facture f) {
		// TODO Auto-generated method stub
		factureDAO.updateFacture(f);
	}

	@Override
	public void deleteFacture(Integer idF) {
		// TODO Auto-generated method stub
		factureDAO.deleteFacture(idF);
	}

	@Override
	public List<Facture> listFacture() {
		// TODO Auto-generated method stub
		return factureDAO.listFacture();
	}

	@Override
	public Facture getFactureId(Integer idF) {
		// TODO Auto-generated method stub
		return factureDAO.getFactureId(idF);
	}

}
