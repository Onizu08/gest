package mg.uha.miage.dao.interf;

import java.util.List;

import mg.uha.miage.entities.Devise;

public interface DeviseDAOInterf {

	public String addDevise(Devise d);

	public void updateDevise(Devise d);

	public void deleteDEvise(String idD);

	public List<Devise> listDevise();

	public Devise getDevise(String idD);
}
