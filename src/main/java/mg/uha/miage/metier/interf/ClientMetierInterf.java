package mg.uha.miage.metier.interf;

import java.util.List;

import mg.uha.miage.entities.Client;

public interface ClientMetierInterf {
	public Integer ajoutClient(Client c);

	public void updateClient(Client c);

	public void deleteClient(Integer idC);

	public List<Client> listClient();

	public Client getClient(Integer idC);

	public void addClientP(String valNom, String valPrenom, String valMail, String valPhone, String valAdresse,
			String valPost, String valVille);

	public void addSociete(String valNomSoc, Integer valSiret, String valNom, String valPrenom, String valMail,
			String valPhone, String valPhoneSoc, String valAdresse, String valVille, String valPostale);

	public void modificationSocietO(Integer valCLientId, String valAdresse);
}
