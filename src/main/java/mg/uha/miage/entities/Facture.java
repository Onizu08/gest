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
@Table(name = "facture")
public class Facture {

	@Id
	@Column(name = "factureid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer factureId;

	@OneToMany(mappedBy = "facture", fetch = FetchType.LAZY)
	private List<Payer> listPayer = new ArrayList<Payer>();

	@OneToMany(mappedBy = "facture", fetch = FetchType.LAZY)
	private List<Achat> listAchat = new ArrayList<Achat>();

	// @OneToMany(mappedBy = "facture", fetch = FetchType.LAZY)
	// private List<Facture> listFacture = new ArrayList<Facture>();

	// @ManyToOne
	// @JoinColumn(name = "factureIdAnnule")
	// private Facture facture;

	@ManyToOne
	@JoinColumn(name = "utilisateurId")
	private Utilisateur utilisateur;

	@ManyToOne
	@JoinColumn(name = "deviseId")
	private Devise devise;

	@ManyToOne
	@JoinColumn(name = "clientId")
	private Client client;

	@Column(name = "factureidannule")
	private Integer factureIdAnnule;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "datefacture")
	private Date dateFacture;
	@Column(name = "typefactue")
	private String typeFacture;
	@Column(name = "montantfacture")
	private Float montantFacture;
	@Column(name = "statut")
	private String statut;
	@Column(name = "echeance")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateEcheance;
	@Column(name = "nbrpaiement")
	private Integer nbrPaiement;
	@Column(name = "fraisfacture")
	private Float fraisFacture;
	@Column(name = "nbrvalidite")
	private Integer nbrValidite;
	@Column(name = "remise")
	private Float remise;
	@Transient
	private String setDateFacture;
	@Transient
	private String setDateEcheance;

	@Transient
	private Integer numCommande;

	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getFactureId() {
		return factureId;
	}

	public void setFactureId(Integer factureId) {
		this.factureId = factureId;
	}

	public Float getRemise() {
		return remise;
	}

	public void setRemise(Float remise) {
		this.remise = remise;
	}

	public Integer getNumCommande() {
		return numCommande;
	}

	public void setNumCommande(Integer numCommande) {
		this.numCommande = numCommande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}

	public List<Achat> getListAchat() {
		return listAchat;
	}

	// public List<Facture> getListFacture() {
	// return listFacture;
	// }
	//
	// public void setListFacture(List<Facture> listFacture) {
	// this.listFacture = listFacture;
	// }

	// public Facture getFacture() {
	// return facture;
	// }
	//
	// public void setFacture(Facture facture) {
	// this.facture = facture;
	// }

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Devise getDevise() {
		return devise;
	}

	public void setDevise(Devise devise) {
		this.devise = devise;
	}

	public Integer getFactureIdAnnule() {
		return factureIdAnnule;
	}

	public void setFactureIdAnnule(Integer factureIdAnnule) {
		this.factureIdAnnule = factureIdAnnule;
	}

	public void setListAchat(List<Achat> listAchat) {
		this.listAchat = listAchat;
	}

	public String getTypeFacture() {
		return typeFacture;
	}

	public void setTypeFacture(String typeFacture) {
		this.typeFacture = typeFacture;
	}

	public Float getMontantFacture() {
		return montantFacture;
	}

	public void setMontantFacture(Float montantFacture) {
		this.montantFacture = montantFacture;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public Integer getNbrPaiement() {
		return nbrPaiement;
	}

	public void setNbrPaiement(Integer nbrPaiement) {
		this.nbrPaiement = nbrPaiement;
	}

	public Float getFraisFacture() {
		return fraisFacture;
	}

	public void setFraisFacture(Float fraisFacture) {
		this.fraisFacture = fraisFacture;
	}

	public Integer getNbrValidite() {
		return nbrValidite;
	}

	public void setNbrValidite(Integer nbrValidite) {
		this.nbrValidite = nbrValidite;
	}

	public String getSetDateFacture() {
		return setDateFacture;
	}

	public void setSetDateFacture(String setDateFacture) {
		this.setDateFacture = setDateFacture;
	}

	public String getSetDateEcheance() {
		return setDateEcheance;
	}

	public void setSetDateEcheance(String setDateEcheance) {
		this.setDateEcheance = setDateEcheance;
	}

	public List<Payer> getListPayer() {
		return listPayer;
	}

	public void setListPayer(List<Payer> listPayer) {
		this.listPayer = listPayer;
	}

	public Facture(Date dateFacture, String typeFacture, Float montantFacture, String statut, Date dateEcheance,
			Integer nbrPaiement, Float fraisFacture, Integer nbrValidite, Float remise, String setDateFacture,
			String setDateEcheance, Integer numCommande) {
		super();
		this.dateFacture = dateFacture;
		this.typeFacture = typeFacture;
		this.montantFacture = montantFacture;
		this.statut = statut;
		this.dateEcheance = dateEcheance;
		this.nbrPaiement = nbrPaiement;
		this.fraisFacture = fraisFacture;
		this.nbrValidite = nbrValidite;
		this.remise = remise;
		this.setDateFacture = setDateFacture;
		this.setDateEcheance = setDateEcheance;
		this.numCommande = numCommande;
	}

}
