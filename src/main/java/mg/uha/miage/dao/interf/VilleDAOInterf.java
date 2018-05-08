package mg.uha.miage.dao.interf;

import java.util.List;

import mg.uha.miage.entities.Ville;

public interface VilleDAOInterf {

	public String ajoutVille(Ville v);

	public void updateVille(Ville v);

	public void deleteVille(String idV);

	public List<Ville> listVille();

	public Ville getVille(String idV);
}
