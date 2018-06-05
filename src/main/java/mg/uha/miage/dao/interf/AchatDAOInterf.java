package mg.uha.miage.dao.interf;

import java.util.List;

import mg.uha.miage.entities.Achat;

public interface AchatDAOInterf {

	public Integer ajoutAchat(Achat c);

	public void updateAchat(Achat c);

	public void deleteAchat(Integer idC);

	public List<Achat> listAchat();

	public Achat getAchat(Integer idC);
}
