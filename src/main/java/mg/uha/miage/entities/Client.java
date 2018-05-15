package mg.uha.miage.entities;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clientid")
	private Integer clientId;
	@Column(name = "nom")
	private String clientNom;
	@Column(name = "prenom")
	private String clientPrenom;
	@Column(name = "datenaissance", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateNaissanceClient;
	@Column(name = "adresse")
	private String adresseClient;
	@Column(name = "telephone")
	private String clientTelephone;
	@Column(name = "mail")
	private String mail;
	@Column(name = "type")
	private String clientType;
	@Column(name = "datedebutclient", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateDebutClient;
	@Column(name = "montantavoir")
	private Float montantAvoir;
	@Column(name = "montantdu")
	private Float monantDu;
	@Column(name = "tauxremise")
	private Float tauxRemise;

	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private List<Payer> listPayement = new ArrayList<Payer>();

	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private List<Facture> listFacture = new ArrayList<Facture>();

	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private List<Commande> listCommande = new ArrayList<Commande>();

	@ManyToOne
	@JoinColumn(name = "idVille")
	private Ville ville;
	
	@ManyToOne
	@JoinColumn(name = "societeId")
	private Societe societe;

	@Transient
	private String setDateDebutClient;

	@Transient
	private String setDateNaisse;

	public String getSetDateNaisse() {
		return setDateNaisse;
	}

	public Ville getVille() {
		return ville;
	}

	public List<Facture> getListFacture() {
		return listFacture;
	}

	public void setListFacture(List<Facture> listFacture) {
		this.listFacture = listFacture;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	public void setSetDateNaisse(String setDateNaisse) {
		this.setDateNaisse = setDateNaisse;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getClientNom() {
		return clientNom;
	}

	public void setClientNom(String clientNom) {
		this.clientNom = clientNom;
	}

	public String getClientPrenom() {
		return clientPrenom;
	}

	public void setClientPrenom(String clientPrenom) {
		this.clientPrenom = clientPrenom;
	}

	public Date getDateNaissanceClient() {
		return dateNaissanceClient;
	}

	public List<Commande> getListCommande() {
		return listCommande;
	}

	public void setListCommande(List<Commande> listCommande) {
		this.listCommande = listCommande;
	}

	public void setDateNaissanceClient(Date dateNaissanceClient) {
		this.dateNaissanceClient = dateNaissanceClient;
	}

	public String getClientTelephone() {
		return clientTelephone;
	}

	public void setClientTelephone(String clientTelephone) {
		this.clientTelephone = clientTelephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getAdresseClient() {
		return adresseClient;
	}

	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getDateDebutClient() {
		return dateDebutClient;
	}

	public void setDateDebutClient(Date dateDebutClient) {
		this.dateDebutClient = dateDebutClient;
	}

	public List<Payer> getListPayement() {
		return listPayement;
	}

	public void setListPayement(List<Payer> listPayement) {
		this.listPayement = listPayement;
	}

	public Float getMontantAvoir() {
		return montantAvoir;
	}

	public void setMontantAvoir(Float montantAvoir) {
		this.montantAvoir = montantAvoir;
	}

	public Float getMonantDu() {
		return monantDu;
	}

	public void setMonantDu(Float monantDu) {
		this.monantDu = monantDu;
	}

	public Float getTauxRemise() {
		return tauxRemise;
	}

	public void setTauxRemise(Float tauxRemise) {
		this.tauxRemise = tauxRemise;
	}

	public String getSetDateDebutClient() {
		return setDateDebutClient;
	}

	public void setSetDateDebutClient(String setDateDebutClient) {
		this.setDateDebutClient = setDateDebutClient;
	}

	public Client(String clientNom, String clientPrenom, Date dateNaissanceClient, String adresseClient,
			String clientTelephone, String mail, String clientType, Date dateDebutClient, Float montantAvoir,
			Float monantDu, Float tauxRemise, Ville ville, String setDateDebutClient, String setDateNaisse) {
		super();
		this.clientNom = clientNom;
		this.clientPrenom = clientPrenom;
		this.dateNaissanceClient = dateNaissanceClient;
		this.adresseClient = adresseClient;
		this.clientTelephone = clientTelephone;
		this.mail = mail;
		this.clientType = clientType;
		this.dateDebutClient = dateDebutClient;
		this.montantAvoir = montantAvoir;
		this.monantDu = monantDu;
		this.tauxRemise = tauxRemise;
		this.ville = ville;
		this.setDateDebutClient = setDateDebutClient;
		this.setDateNaisse = setDateNaisse;
	}

}
