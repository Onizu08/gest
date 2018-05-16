package mg.uha.miage.metier.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.ReductionDAOInterf;
import mg.uha.miage.entities.Reduction;
import mg.uha.miage.metier.interf.ReductionMetierInterf;

@Transactional
public class ReductionMetierImpl implements ReductionMetierInterf {

	private ReductionDAOInterf reductionDAO;

	public void setReductionDAO(ReductionDAOInterf reductionDAO) {
		this.reductionDAO = reductionDAO;
	}

	@Override
	public Integer ajoutReduction(Reduction c) {
		// TODO Auto-generated method stub
		return reductionDAO.ajoutReduction(c);
	}

	@Override
	public void updateReduction(Reduction c) {
		// TODO Auto-generated method stub
		reductionDAO.updateReduction(c);
	}

	@Override
	public void deleteReduction(Integer idC) {
		// TODO Auto-generated method stub
		reductionDAO.deleteReduction(idC);
	}

	@Override
	public List<Reduction> listReduction() {
		// TODO Auto-generated method stub
		return reductionDAO.listReduction();
	}

	@Override
	public Reduction getReduction(Integer idC) {
		// TODO Auto-generated method stub
		return reductionDAO.getReduction(idC);
	}

}
