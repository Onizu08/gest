package mg.uha.miage.metier.interf;

import java.util.List;

import mg.uha.miage.entities.Devise;

public interface DeviseMetierInterf {

	public String addDevise(Devise d);

	public void updateDevise(Devise d);

	public void deleteDEvise(String idD);

	public List<Devise> listDevise();

	public Devise getDevise(String idD);
}
