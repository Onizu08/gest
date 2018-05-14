package mg.uha.miage.dao.interf;

import java.util.List;

import mg.uha.miage.entities.Payer;

public interface PayementDAOInterf {

	public Integer addPayement(Payer p);

	public void updatePayement(Payer p);

	public void deletePayement(Integer idP);

	public List<Payer> listPayement();

	public Payer getPayement(Integer idP);
}