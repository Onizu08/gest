package mg.uha.miage.metier.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.ClientDAOInterf;
import mg.uha.miage.entities.Client;
import mg.uha.miage.metier.interf.ClientMetierInterf;

@Transactional
public class ClientMetierImpl implements ClientMetierInterf {

	private ClientDAOInterf clientDAO;

	public void setClientDAO(ClientDAOInterf clientDAO) {
		this.clientDAO = clientDAO;
	}

	@Override
	public Integer ajoutClient(Client c) {
		// TODO Auto-generated method stub
		return clientDAO.ajoutClient(c);
	}

	@Override
	public void updateClient(Client c) {
		// TODO Auto-generated method stub
		clientDAO.updateClient(c);
	}

	@Override
	public void deleteClient(Integer idC) {
		// TODO Auto-generated method stub
		clientDAO.deleteClient(idC);
	}

	@Override
	public List<Client> listClient() {
		// TODO Auto-generated method stub
		return clientDAO.listClient();
	}

	@Override
	public Client getClient(Integer idC) {
		// TODO Auto-generated method stub
		return clientDAO.getClient(idC);
	}

}
