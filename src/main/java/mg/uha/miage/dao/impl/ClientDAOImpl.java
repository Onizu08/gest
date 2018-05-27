package mg.uha.miage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.ClientDAOInterf;
import mg.uha.miage.entities.Client;

@Transactional
public class ClientDAOImpl implements ClientDAOInterf {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Integer ajoutClient(Client c) {
		// TODO Auto-generated method stub
		em.persist(c);
		return c.getClientId();
	}

	@Override
	public void updateClient(Client c) {
		// TODO Auto-generated method stub
		em.merge(c);
	}

	@Override
	public void deleteClient(Integer idC) {
		// TODO Auto-generated method stub
		Client c = getClient(idC);
		em.remove(c);
	}

	@Override
	public List<Client> listClient() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select c from Client c");
		return req.getResultList();
	}

	@Override
	public Client getClient(Integer idC) {
		// TODO Auto-generated method stub
		return em.find(Client.class, idC);
	}

	@Override
	public void addClientP(String valNom, String valPrenom, String valMail, String valPhone, String valAdresse,
			Integer valPost, String valVille, String valPays) {

		// TODO Auto-generated method stub

		StoredProcedureQuery req = em.createStoredProcedureQuery("AJOUTCLIENT")
				.registerStoredProcedureParameter("VALNOM", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("VALPRENOM", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("VALEMAIL", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("VALTELEPHONE", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("VALADRESSE", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("VALPOSTALE", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("VALVILLE", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("VALPAYS", String.class, ParameterMode.IN)
				.setParameter("VALNOM", valNom).setParameter("VALPRENOM", valPrenom).setParameter("VALEMAIL", valMail)
				.setParameter("VALTELEPHONE", valPhone).setParameter("VALADRESSE", valAdresse)
				.setParameter("VALPOSTALE", valPost).setParameter("VALVILLE", valVille)
				.setParameter("VALPAYS", valPays);
		req.execute();

	}

	@Override
	public void addSocieteC(String valNomSoc, Integer valSiret, String valNom, String valPrenom, String valMail,
			String valPhone, String valPhoneSoc, String valAdresse, String valVille, String valPays,
			Integer valPostale) {
		// TODO Auto-generated method stub
		StoredProcedureQuery req = em.createStoredProcedureQuery("AJOUTSOCIETE")
				.registerStoredProcedureParameter("VALNOMSOCIETE", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("VALSIRET", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("VALNOM", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("VALPRENOM", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("VALMAIL", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("VALTELEPHONE", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("VALPHONESOC", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("VALADRESSE", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("VALVILLE", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("VALPAYS", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("VALPOSTALE", Integer.class, ParameterMode.IN)
				.setParameter("VALNOMSOCIETE", valNomSoc).setParameter("VALSIRET", valSiret)
				.setParameter("VALNOM", valNom).setParameter("VALPRENOM", valPrenom).setParameter("VALMAIL", valMail)
				.setParameter("VALTELEPHONE", valPhone).setParameter("VALPHONESOC", valPhoneSoc)
				.setParameter("VALADRESSE", valAdresse).setParameter("VALVILLE", valVille)
				.setParameter("VALPAYS", valPays).setParameter("VALPOSTALE", valPostale);
		req.execute();
	}

}
