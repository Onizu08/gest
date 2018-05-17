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
@Table(name = "reduction")

public class Reduction {

	@Id
	@Column(name = "reductionid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reductionId;

	@OneToMany(mappedBy = "reduction", fetch = FetchType.LAZY)
	private List<Affecter> listAffecter = new ArrayList<Affecter>();

	@OneToMany(mappedBy = "reduction", fetch = FetchType.LAZY)
	private List<Attribuer> listAttribuer = new ArrayList<Attribuer>();

	@Column(name = "reductionlib")
	private String reductionLib;
	@Column(name = "reductionapplique")
	private String reductionApplique;
	@Column(name = "reductiondescription")
	private String reductionDescription;

	public Integer getReductionId() {
		return reductionId;
	}

	public void setReductionId(Integer reductionId) {
		this.reductionId = reductionId;
	}

	public List<Affecter> getListAffecter() {
		return listAffecter;
	}

	public void setListAffecter(List<Affecter> listAffecter) {
		this.listAffecter = listAffecter;
	}

	public String getReductionLib() {
		return reductionLib;
	}

	public void setReductionLib(String reductionLib) {
		this.reductionLib = reductionLib;
	}

	public String getReductionApplique() {
		return reductionApplique;
	}

	public void setReductionApplique(String reductionApplique) {
		this.reductionApplique = reductionApplique;
	}

	public String getReductionDescription() {
		return reductionDescription;
	}

	public void setReductionDescription(String reductionDescription) {
		this.reductionDescription = reductionDescription;
	}

	public Reduction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reduction(String reductionLib, String reductionApplique, String reductionDescription) {
		super();
		this.reductionLib = reductionLib;
		this.reductionApplique = reductionApplique;
		this.reductionDescription = reductionDescription;
	}

}
