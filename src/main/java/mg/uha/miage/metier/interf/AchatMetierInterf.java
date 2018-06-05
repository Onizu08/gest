package mg.uha.miage.metier.interf;

import java.util.List;

import mg.uha.miage.entities.Achat;

public interface AchatMetierInterf {

	public Integer ajoutAchat(Achat c);

	public void updateAchat(Achat c);

	public void deleteAchat(Integer idC);

	public List<Achat> listAchat();

	public Achat getAchat(Integer idC);
}
