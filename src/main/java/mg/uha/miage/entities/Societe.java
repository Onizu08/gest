package mg.uha.miage.entities;

import java.io.Serializable;
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
@Table(name = "societe")
public class Societe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "societeid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer societeId;
	@Column(name = "societenom")
	private String nomSociete;
	@Column(name = "adressesociete")
	private String adresseSoceite;
	@Column(name = "fax")
	private String fax;
	@Column(name = "siret")
	private Integer siret;
	@Column(name = "capital")
	private Float capital;
	@Column(name = "telephone")
	private String telephoneSociete;

	@Column(name = "numtva")
	private Integer numTva;
	@Column(name = "naf")
	private String naf;

	@OneToMany(mappedBy = "societe", fetch = FetchType.LAZY)
	private List<Utilisateur> listUtilisateur = new ArrayList<Utilisateur>();
	
	@OneToMany(mappedBy = "societe", fetch = FetchType.LAZY)
	private List<Client> listClient= new ArrayList<Client>();

	@ManyToOne
	@JoinColumn(name = "idVille")
	private Ville ville;

	public Integer getSocieteId() {
		return societeId;
	}

	public void setSocieteId(Integer societeId) {
		this.societeId = societeId;
	}

	public String getNomSociete() {
		return nomSociete;
	}

	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}

	public String getAdresseSoceite() {
		return adresseSoceite;
	}

	public String getTelephoneSociete() {
		return telephoneSociete;
	}

	public void setTelephoneSociete(String telephoneSociete) {
		this.telephoneSociete = telephoneSociete;
	}

	public void setAdresseSoceite(String adresseSoceite) {
		this.adresseSoceite = adresseSoceite;
	}

	public List<Utilisateur> getListUtilisateur() {
		return listUtilisateur;
	}

	public void setListUtilisateur(List<Utilisateur> listUtilisateur) {
		this.listUtilisateur = listUtilisateur;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Integer getSiret() {
		return siret;
	}

	public void setSiret(Integer siret) {
		this.siret = siret;
	}

	public Float getCapital() {
		return capital;
	}

	public void setCapital(Float capital) {
		this.capital = capital;
	}

	public Integer getNumTva() {
		return numTva;
	}

	public void setNumTva(Integer numTva) {
		this.numTva = numTva;
	}

	public String getNaf() {
		return naf;
	}

	public void setNaf(String naf) {
		this.naf = naf;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public Societe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Societe(String nomSociete, String adresseSoceite, String fax, Integer siret, Float capital, Integer numTva,
			String naf) {
		super();
		this.nomSociete = nomSociete;
		this.adresseSoceite = adresseSoceite;
		this.fax = fax;
		this.siret = siret;
		this.capital = capital;
		this.numTva = numTva;
		this.naf = naf;
	}

}
