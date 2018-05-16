package mg.uha.miage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.ReductionDAOInterf;
import mg.uha.miage.entities.Reduction;

@Transactional
public class ReductionDAOImpl implements ReductionDAOInterf {
	@PersistenceContext
	private EntityManager el;

	@Override
	public Integer ajoutReduction(Reduction c) {
		// TODO Auto-generated method stub
		el.persist(c);
		return c.getReductionId();
	}

	@Override
	public void updateReduction(Reduction c) {
		// TODO Auto-generated method stub
		el.merge(c);
	}

	@Override
	public void deleteReduction(Integer idC) {
		// TODO Auto-generated method stub
		Reduction a = getReduction(idC);
		el.remove(a);
	}

	@Override
	public List<Reduction> listReduction() {
		// TODO Auto-generated method stub
		Query req = el.createQuery("select a from Reduction a");
		return req.getResultList();
	}

	@Override
	public Reduction getReduction(Integer idC) {
		// TODO Auto-generated method stub
		return el.find(Reduction.class, idC);
	}
}
