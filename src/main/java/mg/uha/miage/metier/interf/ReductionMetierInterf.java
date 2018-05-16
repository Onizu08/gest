package mg.uha.miage.metier.interf;

import java.util.List;

import mg.uha.miage.entities.Reduction;

public interface ReductionMetierInterf {

	public Integer ajoutReduction(Reduction c);

	public void updateReduction(Reduction c);

	public void deleteReduction(Integer idC);

	public List<Reduction> listReduction();

	public Reduction getReduction(Integer idC);

}
