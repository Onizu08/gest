package mg.uha.miage.dao.interf;

import java.util.List;

import mg.uha.miage.entities.Societe;

public interface SocieteDAOInterf {

	public Integer ajoutSociete(Societe s);

	public void updateSociete(Societe s);

	public void deleteSociete(Integer idS);

	public List<Societe> listSociete();

	public Societe getSociete(Integer idS);

}
