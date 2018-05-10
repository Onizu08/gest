package mg.uha.miage.metier.interf;

import java.util.List;

import mg.uha.miage.entities.Facture;

public interface FactureMetierInterf {

	public Integer addFacture(Facture f);

	public void updateFacture(Facture f);

	public void deleteFacture(Integer idF);

	public List<Facture> listFacture();

	public Facture getFactureId(Integer idF);

}
