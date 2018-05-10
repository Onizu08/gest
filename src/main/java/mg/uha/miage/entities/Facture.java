package mg.uha.miage.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
	private Integer factureId;
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

	@Transient
	private String setDateFacture;
	@Transient
	private String setDateEcheance;

	@OneToMany(mappedBy = "facture", fetch = FetchType.LAZY)
	private List<Payer> listPayer = new ArrayList<Payer>();

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

	public Date getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
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
			Integer nbrPaiement, Float fraisFacture, Integer nbrValidite, String setDateFacture,
			String setDateEcheance) {
		super();
		this.dateFacture = dateFacture;
		this.typeFacture = typeFacture;
		this.montantFacture = montantFacture;
		this.statut = statut;
		this.dateEcheance = dateEcheance;
		this.nbrPaiement = nbrPaiement;
		this.fraisFacture = fraisFacture;
		this.nbrValidite = nbrValidite;
		this.setDateFacture = setDateFacture;
		this.setDateEcheance = setDateEcheance;
	}

}
