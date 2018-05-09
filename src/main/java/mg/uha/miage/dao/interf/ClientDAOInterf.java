package mg.uha.miage.dao.interf;

import java.util.List;

import mg.uha.miage.entities.Client;

public interface ClientDAOInterf {

	public Integer ajoutClient(Client c);

	public void updateClient(Client c);

	public void deleteClient(Integer idC);

	public List<Client> listClient();

	public Client getClient(Integer idC);

}
