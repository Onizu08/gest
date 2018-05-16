package mg.uha.miage.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {

	@Id
	@Column(name = "utilisateurid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer utilisateurId;

	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
	private List<Facture> listFacture = new ArrayList<Facture>();

	@ManyToOne
	@JoinColumn(name = "profileId")
	private Profil profil;

	@ManyToOne
	@JoinColumn(name = "societeId")
	private Societe societe;

	@Column(name = "login")
	private String login;
	@Column(name = "pwd")
	private String pwd;

	public Integer getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(Integer utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	public List<Facture> getListFacture() {
		return listFacture;
	}

	public void setListFacture(List<Facture> listFacture) {
		this.listFacture = listFacture;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(String login, String pwd) {
		super();
		this.login = login;
		this.pwd = pwd;
	}

}
