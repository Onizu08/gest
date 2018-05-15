package mg.uha.miage.metier.interf;

import java.util.List;

import mg.uha.miage.entities.Profil;

public interface ProfilMetierInterf {

	public Integer addProfil(Profil p);

	public void udpateProfil(Profil p);

	public void deleteProfil(Integer idP);

	public List<Profil> listProfil();

	public Profil getProfil(Integer idP);
}
