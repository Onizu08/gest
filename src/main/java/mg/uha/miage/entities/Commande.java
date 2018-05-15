package mg.uha.miage.entities;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "commande")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "commandeid")
	private Integer commandeId;
	@Column(name = "reference")
	private String reference;
	@Column(name = "datecommande")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateCommande;
	@Column(name = "statut")
	private String statut;

	@OneToMany(mappedBy = "commande", fetch = FetchType.LAZY)
	private List<Achat> listAchat = new ArrayList<Achat>();

	@ManyToOne
	@JoinColumn(name = "clientId")
	private Client client;

	@Transient
	private String setDateCommande;

	public Integer getCommandeId() {
		return commandeId;
	}

	public void setCommandeId(Integer commandeId) {
		this.commandeId = commandeId;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public List<Achat> getListAchat() {
		return listAchat;
	}

	public void setListAchat(List<Achat> listAchat) {
		this.listAchat = listAchat;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getSetDateCommande() {
		return setDateCommande;
	}

	public void setSetDateCommande(String setDateCommande) {
		this.setDateCommande = setDateCommande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

}
