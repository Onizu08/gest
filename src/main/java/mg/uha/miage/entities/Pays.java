package mg.uha.miage.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pays")
public class Pays implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "paysid", length = 10, nullable = false)
	private String paysId;
	@Column(name = "payslib", length = 30, nullable = false)
	private String paysLib;

	@OneToMany(mappedBy = "pays", fetch = FetchType.LAZY)
	private List<Ville> listVille = new ArrayList<Ville>();

	public String getPaysId() {
		return paysId;
	}

	public void setPaysId(String paysId) {
		this.paysId = paysId;
	}

	public String getPaysLib() {
		return paysLib;
	}

	public void setPaysLib(String paysLib) {
		this.paysLib = paysLib;
	}

	public Pays() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Ville> getListVille() {
		return listVille;
	}

	public void setListVille(List<Ville> listVille) {
		this.listVille = listVille;
	}

	public Pays(String paysLib) {
		super();
		this.paysLib = paysLib;
	}

}
