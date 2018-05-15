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
@Table(name = "article")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "articleid")
	private Integer articleId;

	@OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
	private List<Achat> listAchat = new ArrayList<Achat>();

	@OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
	private List<Affecter> listAffecter = new ArrayList<Affecter>();

	@ManyToOne
	@JoinColumn(name = "categorieId")
	private Categorie categorie;

	@Column(name = "refarticle")
	private String refArticle;
	@Column(name = "nomarticle")
	private String nomArticle;
	@Column(name = "prixunitaire")
	private Float prixUnitaire;
	@Column(name = "promoarticle")
	private String promoArticle;
	@Column(name = "descriptionarticle")
	private String descriptionArticle;

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(Categorie categorie, String refArticle, String nomArticle, Float prixUnitaire, String promoArticle,
			String descriptionArticle) {
		super();
		this.categorie = categorie;
		this.refArticle = refArticle;
		this.nomArticle = nomArticle;
		this.prixUnitaire = prixUnitaire;
		this.promoArticle = promoArticle;
		this.descriptionArticle = descriptionArticle;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public List<Achat> getListAchat() {
		return listAchat;
	}

	public void setListAchat(List<Achat> listAchat) {
		this.listAchat = listAchat;
	}

	public List<Affecter> getListAffecter() {
		return listAffecter;
	}

	public void setListAffecter(List<Affecter> listAffecter) {
		this.listAffecter = listAffecter;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getRefArticle() {
		return refArticle;
	}

	public void setRefArticle(String refArticle) {
		this.refArticle = refArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public Float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(Float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public String getPromoArticle() {
		return promoArticle;
	}

	public void setPromoArticle(String promoArticle) {
		this.promoArticle = promoArticle;
	}

	public String getDescriptionArticle() {
		return descriptionArticle;
	}

	public void setDescriptionArticle(String descriptionArticle) {
		this.descriptionArticle = descriptionArticle;
	}

}
