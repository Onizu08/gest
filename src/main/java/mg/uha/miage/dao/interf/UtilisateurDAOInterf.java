package mg.uha.miage.dao.interf;

import java.util.List;

import mg.uha.miage.entities.Utilisateur;

public interface UtilisateurDAOInterf {

	public Integer addUser(Utilisateur p);

	public void udpateUser(Utilisateur p);

	public void deleteUser(Integer idP);

	public List<Utilisateur> listUser();

	public Utilisateur getUser(Integer idP);

}
