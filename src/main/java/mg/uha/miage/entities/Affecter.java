package mg.uha.miage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "affecter")

public class Affecter {

	@Id
	@Column(name = "affecterid")
	private Integer affecterId;

	@ManyToOne
	@JoinColumn(name = "articleId")
	private Article article;

	@ManyToOne
	@JoinColumn(name = "reductionId")
	private Reduction reduction;

	public Affecter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getAffecterId() {
		return affecterId;
	}

	public void setAffecterId(Integer affecterId) {
		this.affecterId = affecterId;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Reduction getReduction() {
		return reduction;
	}

	public void setReduction(Reduction reduction) {
		this.reduction = reduction;
	}

}
