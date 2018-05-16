package mg.uha.miage.dao.interf;

import java.util.List;

import mg.uha.miage.entities.Reduction;

public interface ReductionDAOInterf {

	public Integer ajoutReduction(Reduction c);

	public void updateReduction(Reduction c);

	public void deleteReduction(Integer idC);

	public List<Reduction> listReduction();

	public Reduction getReduction(Integer idC);

}
