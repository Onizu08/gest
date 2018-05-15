package mg.uha.miage.metier.interf;

import java.util.List;

import mg.uha.miage.entities.Utilisateur;

public interface UtilisateurMetierInterf {
	public Integer addUser(Utilisateur p);

	public void udpateUser(Utilisateur p);

	public void deleteUser(Integer idP);

	public List<Utilisateur> listUser();

	public Utilisateur getUser(Integer idP);

}
