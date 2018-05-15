package mg.uha.miage.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "devise")
public class Devise {
	@Id
	@Column(name = "deviseid")
	private String deviseId;

	@OneToMany(mappedBy = "devise", fetch = FetchType.LAZY)
	private List<Facture> listFacture = new ArrayList<Facture>();

	@Column(name = "deviselib")
	private String deviseLibelle;
	@Column(name = "tauxdevise")
	private Float tauxDevise;

	public String getDeviseId() {
		return deviseId;
	}

	public void setDeviseId(String deviseId) {
		this.deviseId = deviseId;
	}

	public List<Facture> getListFacture() {
		return listFacture;
	}

	public void setListFacture(List<Facture> listFacture) {
		this.listFacture = listFacture;
	}

	public String getDeviseLibelle() {
		return deviseLibelle;
	}

	public void setDeviseLibelle(String deviseLibelle) {
		this.deviseLibelle = deviseLibelle;
	}

	public Float getTauxDevise() {
		return tauxDevise;
	}

	public void setTauxDevise(Float tauxDevise) {
		this.tauxDevise = tauxDevise;
	}

	public Devise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Devise(String deviseLibelle, Float tauxDevise) {
		super();
		this.deviseLibelle = deviseLibelle;
		this.tauxDevise = tauxDevise;
	}

}
