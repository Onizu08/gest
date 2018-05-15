package mg.uha.miage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "attribuer")
public class Attribuer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attribuerid")
	private Integer attribuerId;

	@ManyToOne
	@JoinColumn(name = "reductionId")
	private Reduction reduction;

	@ManyToOne
	@JoinColumn(name = "categorieId")
	private Categorie categorie;

	public Integer getAttribuerId() {
		return attribuerId;
	}

	public void setAttribuerId(Integer attribuerId) {
		this.attribuerId = attribuerId;
	}

	public Reduction getReduction() {
		return reduction;
	}

	public void setReduction(Reduction reduction) {
		this.reduction = reduction;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Attribuer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
