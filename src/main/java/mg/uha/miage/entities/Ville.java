package mg.uha.miage.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ville")

public class Ville implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "idville", length = 10, nullable = false)
	public String idVille;
	@Column(name = "libville", length = 10, nullable = false)
	public String libVille;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ville")
	private List<Client> listClient = new ArrayList<Client>();

	@ManyToOne
	@JoinColumn(name = "paysId")
	private Pays pays;

	public String getIdVille() {
		return idVille;
	}

	public void setIdVille(String idVille) {
		this.idVille = idVille;
	}

	public String getLibVille() {
		return libVille;
	}

	public void setLibVille(String libVille) {
		this.libVille = libVille;
	}

	public Ville(String libVille) {
		super();
		this.libVille = libVille;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public List<Client> getListClient() {
		return listClient;
	}

	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}

	public Ville() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ville(String idVille, String libVille) {
		super();
		this.idVille = idVille;
		this.libVille = libVille;
	}

}
