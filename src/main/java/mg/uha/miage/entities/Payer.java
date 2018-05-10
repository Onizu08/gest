package mg.uha.miage.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "payer")
public class Payer {

	@Id
	@Column(name = "idpayement")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentId;
	@Column(name = "dateprevu")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date datePrevu;
	@Column(name = "montantprevu")
	private Float montantPrevu;
	@Column(name = "datepayement")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date datePayement;
	@Column(name = "montantpayement")
	private Float montantPayement;

	@ManyToOne
	@JoinColumn(name = "clientId")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "factureId")
	private Facture facture;

	@Transient
	private String setDatePrevu;
	@Transient
	private String setDatePayement;

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Date getDatePrevu() {
		return datePrevu;
	}

	public void setDatePrevu(Date datePrevu) {
		this.datePrevu = datePrevu;
	}

	public Float getMontantPrevu() {
		return montantPrevu;
	}

	public void setMontantPrevu(Float montantPrevu) {
		this.montantPrevu = montantPrevu;
	}

	public Date getDatePayement() {
		return datePayement;
	}

	public void setDatePayement(Date datePayement) {
		this.datePayement = datePayement;
	}

	public Float getMontantPayement() {
		return montantPayement;
	}

	public void setMontantPayement(Float montantPayement) {
		this.montantPayement = montantPayement;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public String getSetDatePrevu() {
		return setDatePrevu;
	}

	public void setSetDatePrevu(String setDatePrevu) {
		this.setDatePrevu = setDatePrevu;
	}

	public String getSetDatePayement() {
		return setDatePayement;
	}

	public void setSetDatePayement(String setDatePayement) {
		this.setDatePayement = setDatePayement;
	}

	public Payer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payer(Date datePrevu, Float montantPrevu, Date datePayement, Float montantPayement, String setDatePrevu,
			String setDatePayement) {
		super();
		this.datePrevu = datePrevu;
		this.montantPrevu = montantPrevu;
		this.datePayement = datePayement;
		this.montantPayement = montantPayement;
		this.setDatePrevu = setDatePrevu;
		this.setDatePayement = setDatePayement;
	}

}
