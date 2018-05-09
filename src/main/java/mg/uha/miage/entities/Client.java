package mg.uha.miage.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="clientid")
	private Integer clientId;
	@Column(name="nom")
	private String clientNom;
	@Column(name="prenom")
	private String clientPrenom;
	@Column(name = "datenaissance", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateNaissanceClient;
	@Column(name = "telephone")
	private String clientTelephone;
	@Column(name = "mail")
	private String mail;
	@Column(name = "type")
	private String clientType;

	@Transient
	private String setDateNaisse;

	public String getSetDateNaisse() {
		return setDateNaisse;
	}

	public void setSetDateNaisse(String setDateNaisse) {
		this.setDateNaisse = setDateNaisse;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getClientNom() {
		return clientNom;
	}

	public void setClientNom(String clientNom) {
		this.clientNom = clientNom;
	}

	public String getClientPrenom() {
		return clientPrenom;
	}

	public void setClientPrenom(String clientPrenom) {
		this.clientPrenom = clientPrenom;
	}

	public Date getDateNaissanceClient() {
		return dateNaissanceClient;
	}

	public void setDateNaissanceClient(Date dateNaissanceClient) {
		this.dateNaissanceClient = dateNaissanceClient;
	}

	public String getClientTelephone() {
		return clientTelephone;
	}

	public void setClientTelephone(String clientTelephone) {
		this.clientTelephone = clientTelephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String clientNom, String clientPrenom, Date dateNaissanceClient, String clientTelephone, String mail,
			String clientType, String setDateNaisse) {
		super();
		this.clientNom = clientNom;
		this.clientPrenom = clientPrenom;
		this.dateNaissanceClient = dateNaissanceClient;
		this.clientTelephone = clientTelephone;
		this.mail = mail;
		this.clientType = clientType;
		this.setDateNaisse = setDateNaisse;
	}

}
