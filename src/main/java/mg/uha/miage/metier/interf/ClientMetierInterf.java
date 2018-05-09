package mg.uha.miage.metier.interf;

import java.util.List;

import mg.uha.miage.entities.Client;

public interface ClientMetierInterf {
	public Integer ajoutClient(Client c);

	public void updateClient(Client c);

	public void deleteClient(Integer idC);

	public List<Client> listClient();

	public Client getClient(Integer idC);

}
