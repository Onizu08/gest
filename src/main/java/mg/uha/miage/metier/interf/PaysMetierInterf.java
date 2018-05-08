package mg.uha.miage.metier.interf;

import java.util.List;

import mg.uha.miage.entities.Pays;

public interface PaysMetierInterf {

	public String addPays(Pays p);

	public void updatePays(Pays p);

	public void deletePays(String idP);

	public List<Pays> listPays();

	public Pays getPays(String idP);
}
