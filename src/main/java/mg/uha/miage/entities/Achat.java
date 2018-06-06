package mg.uha.miage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "achat")
public class Achat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "achatid")
	private Integer achatId;
	@Column(name = "quantite")
	private Float quantite;
	@Column(name = "montantht")
	private Float montantHt;
	@Column(name = "tva")
	private Float tva;
	@Column(name = "remise")
	private Float remise;
	@Column(name = "total")
	private Float total;
	@Column(name = "valeurtva")
	private Float valeurTva;
	@ManyToOne
	@JoinColumn(name = "commandeId")
	private Commande commande;
	@Transient
	private Float prix;

	@ManyToOne
	@JoinColumn(name = "articleId")
	private Article article;

	 

	@ManyToOne
	@JoinColumn(name = "factureId")
	private Facture facture;

	public Integer getAchatId() {
		return achatId;
	}

	public void setAchatId(Integer achatId) {
		this.achatId = achatId;
	}

	public Float getQuantite() {
		return quantite;
	}

	public void setQuantite(Float quantite) {
		this.quantite = quantite;
	}

	public Float getMontantHt() {
		return montantHt;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public void setMontantHt(Float montantHt) {
		this.montantHt = montantHt;
	}

	public Float getValeurTva() {
		return valeurTva;
	}

	 

	public void setValeurTva(Float valeurTva) {
		this.valeurTva = valeurTva;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Float getTva() {
		return tva;
	}

	public void setTva(Float tva) {
		this.tva = tva;
	}

	public Float getRemise() {
		return remise;
	}

	public void setRemise(Float remise) {
		this.remise = remise;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public Achat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Achat(Float quantite, Float montantHt, Float tva, Float remise, Float total, Float valeurTva, Float prix) {
		super();
		this.quantite = quantite;
		this.montantHt = montantHt;
		this.tva = tva;
		this.remise = remise;
		this.total = total;
		this.valeurTva = valeurTva;
		this.prix = prix;
	}

}
