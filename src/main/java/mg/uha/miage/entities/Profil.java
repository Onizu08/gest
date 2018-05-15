package mg.uha.miage.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "profil")
public class Profil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "profileid")
	private Integer profileId;
	@Column(name = "profilelib")
	private String profileLib;
	@OneToMany(mappedBy = "profil", fetch = FetchType.LAZY)
	private List<Utilisateur> listUtilisateur = new ArrayList<Utilisateur>();

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public String getProfileLib() {
		return profileLib;
	}

	public void setProfileLib(String profileLib) {
		this.profileLib = profileLib;
	}

	public List<Utilisateur> getListUtilisateur() {
		return listUtilisateur;
	}

	public void setListUtilisateur(List<Utilisateur> listUtilisateur) {
		this.listUtilisateur = listUtilisateur;
	}

	public Profil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profil(String profileLib) {
		super();
		this.profileLib = profileLib;
	}

}
