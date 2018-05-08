package mg.uha.miage.metier.interf;

import java.util.List;

import mg.uha.miage.entities.Ville;

public interface VilleMetierInterf {

	public String ajoutVille(Ville v);

	public void updateVille(Ville v);

	public void deleteVille(String idV);

	public List<Ville> listVille();

	public Ville getVille(String idV);
}
