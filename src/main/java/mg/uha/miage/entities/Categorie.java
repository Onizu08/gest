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
@Table(name = "categorie")

public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categorieid")
	private Integer categorieId;

	@OneToMany(mappedBy = "categorie", fetch = FetchType.LAZY)
	private List<Attribuer> listAttribuer = new ArrayList<Attribuer>();

	@OneToMany(mappedBy = "categorie", fetch = FetchType.LAZY)
	private List<Article> listArticle = new ArrayList<Article>();

	@Column(name = "categorielib")
	private String categorieLib;
	@Column(name = "categoriepromo")
	private String promoCategorie;
	@Column(name = "categoriedescription")
	private String categorieDescription;

	public Integer getCategorieId() {
		return categorieId;
	}

	public void setCategorieId(Integer categorieId) {
		this.categorieId = categorieId;
	}

	public List<Attribuer> getListAttribuer() {
		return listAttribuer;
	}

	public void setListAttribuer(List<Attribuer> listAttribuer) {
		this.listAttribuer = listAttribuer;
	}

	public List<Article> getListArticle() {
		return listArticle;
	}

	public void setListArticle(List<Article> listArticle) {
		this.listArticle = listArticle;
	}

	public String getCategorieLib() {
		return categorieLib;
	}

	public void setCategorieLib(String categorieLib) {
		this.categorieLib = categorieLib;
	}

	public String getPromoCategorie() {
		return promoCategorie;
	}

	public void setPromoCategorie(String promoCategorie) {
		this.promoCategorie = promoCategorie;
	}

	public String getCategorieDescription() {
		return categorieDescription;
	}

	public void setCategorieDescription(String categorieDescription) {
		this.categorieDescription = categorieDescription;
	}

	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categorie(String categorieLib, String promoCategorie, String categorieDescription) {
		super();
		this.categorieLib = categorieLib;
		this.promoCategorie = promoCategorie;
		this.categorieDescription = categorieDescription;
	}

}
