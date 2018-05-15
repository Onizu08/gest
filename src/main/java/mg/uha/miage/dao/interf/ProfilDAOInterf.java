package mg.uha.miage.dao.interf;

import java.util.List;

import mg.uha.miage.entities.Profil;

public interface ProfilDAOInterf {

	public Integer addProfil(Profil p);

	public void udpateProfil(Profil p);

	public void deleteProfil(Integer idP);

	public List<Profil> listProfil();

	public Profil getProfil(Integer idP);

}
