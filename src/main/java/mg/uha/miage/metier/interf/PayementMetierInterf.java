package mg.uha.miage.metier.interf;

import java.util.List;

import mg.uha.miage.entities.Payer;

public interface PayementMetierInterf {
	public Integer addPayement(Payer p);

	public void updatePayement(Payer p);

	public void deletePayement(Integer idP);

	public List<Payer> listPayement();

	public Payer getPayement(Integer idP);

	public void insertioPayement(Integer valFacture, Integer valClient);

}
