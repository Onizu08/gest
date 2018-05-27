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
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "AJOUTCLIENT", procedureName = "AJOUTCLIENT", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "VALNOM"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "VALPRENOM"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "VALEMAIL"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "VALTELEPHONE"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "VALADRESSE"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "VALPOSTALE"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "VALVILLE"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "VALPAYS") }),

		@NamedStoredProcedureQuery(name = "AJOUTSOCIETE", procedureName = "AJOUTSOCIETE", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "VALNOMSOCIETE"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "VALSIRET"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "VALNOM"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "VALPRENOM"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "VALMAIL"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "VALTELEPHONE"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "VALPHONESOC"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "VALADRESSE"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "VALPOSTALE") }) })

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
	@Column(name = "datenaissance")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateNaissanceClient;
	@Column(name = "adresse")
	private String adresseClient;
	@Column(name = "telephone")
	private String clientTelephone;
	@Column(name = "mail")
	private String mail;
	@Column(name = "postale")
	private String postale;
	@Column(name = "type")
	private String clientType;
	@Column(name = "datedebutclient")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateDebutClient;
	@Column(name = "montantavoir")
	private Float montantAvoir;
	@Column(name = "montantdu")
	private Float monantDu;
	@Column(name = "tauxremise")
	private Float tauxRemise;
	@Column(name = "pays")
	private String pays;

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

	@Transient
	private String nomSociete;
	@Transient
	private Integer siret;
	@Transient
	private String telephonSocie;
	@Transient
	private String fax;
	@Transient
	private String valeurVille;

	@Transient
	private Pays makaPays;

	public Pays getMakaPays() {
		return makaPays;
	}

	public void setMakaPays(Pays makaPays) {
		this.makaPays = makaPays;
	}

	//
	public String getSetDateNaisse() {
		return setDateNaisse;
	}

	public String getValeurVille() {
		return valeurVille;
	}

	public void setValeurVille(String valeurVille) {
		this.valeurVille = valeurVille;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public List<Facture> getListFacture() {
		return listFacture;
	}

	public void setListFacture(List<Facture> listFacture) {
		this.listFacture = listFacture;
	}

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	public String getPostale() {
		return postale;
	}

	public void setPostale(String postale) {
		this.postale = postale;
	}

	public String getNomSociete() {
		return nomSociete;
	}

	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}

	public Integer getSiret() {
		return siret;
	}

	public void setSiret(Integer siret) {
		this.siret = siret;
	}

	public String getTelephonSocie() {
		return telephonSocie;
	}

	public void setTelephonSocie(String telephonSocie) {
		this.telephonSocie = telephonSocie;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public void setSetDateNaisse(String setDateNaisse) {
		this.setDateNaisse = setDateNaisse;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
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

	public Client(Integer clientId, String clientNom, String clientPrenom, Date dateNaissanceClient,
			String adresseClient, String clientTelephone, String mail, String postale, String clientType,
			Date dateDebutClient, Float montantAvoir, Float monantDu, Float tauxRemise, String pays,
			String setDateDebutClient, String setDateNaisse, String nomSociete, Integer siret, String telephonSocie,
			String fax, String valeurVille, Ville ville) {
		super();
		this.clientId = clientId;
		this.clientNom = clientNom;
		this.clientPrenom = clientPrenom;
		this.dateNaissanceClient = dateNaissanceClient;
		this.adresseClient = adresseClient;
		this.clientTelephone = clientTelephone;
		this.mail = mail;
		this.postale = postale;
		this.clientType = clientType;
		this.dateDebutClient = dateDebutClient;
		this.montantAvoir = montantAvoir;
		this.monantDu = monantDu;
		this.tauxRemise = tauxRemise;
		this.pays = pays;
		this.setDateDebutClient = setDateDebutClient;
		this.setDateNaisse = setDateNaisse;
		this.nomSociete = nomSociete;
		this.siret = siret;
		this.telephonSocie = telephonSocie;
		this.fax = fax;
		this.valeurVille = valeurVille;
		this.ville = ville;
	}

}
