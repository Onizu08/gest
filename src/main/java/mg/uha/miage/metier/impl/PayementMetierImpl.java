package mg.uha.miage.metier.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.PayementDAOInterf;
import mg.uha.miage.entities.Payer;
import mg.uha.miage.metier.interf.PayementMetierInterf;

@Transactional
public class PayementMetierImpl implements PayementMetierInterf {

	private PayementDAOInterf payerDAO;

	public void setPayerDAO(PayementDAOInterf payerDAO) {
		this.payerDAO = payerDAO;
	}

	@Override
	public Integer addPayement(Payer p) {
		// TODO Auto-generated method stub
		return payerDAO.addPayement(p);
	}

	@Override
	public void updatePayement(Payer p) {
		// TODO Auto-generated method stub
		payerDAO.updatePayement(p);
	}

	@Override
	public void deletePayement(Integer idP) {
		// TODO Auto-generated method stub
		payerDAO.deletePayement(idP);
	}

	@Override
	public List<Payer> listPayement() {
		// TODO Auto-generated method stub
		return payerDAO.listPayement();
	}

	@Override
	public Payer getPayement(Integer idP) {
		// TODO Auto-generated method stub
		return payerDAO.getPayement(idP);
	}

}
