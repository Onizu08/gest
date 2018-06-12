package mg.uha.miage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mg.uha.miage.entities.Client;
import mg.uha.miage.entities.Facture;
import mg.uha.miage.metier.interf.ClientMetierInterf;
import mg.uha.miage.metier.interf.CommandeMetierInterf;
import mg.uha.miage.metier.interf.DeviseMetierInterf;
import mg.uha.miage.metier.interf.FactureMetierInterf;
import mg.uha.miage.metier.interf.UtilisateurMetierInterf;

@Controller
@RequestMapping(value = "/FactureDroit")
@Transactional
public class FactureDroitController {
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private CommandeMetierInterf commandeMetierInterf;

	MakaUtilisateur utilisateur = new MakaUtilisateur();
	@Autowired
	private FactureMetierInterf factureMetierInterf;
	@Autowired
	private ClientMetierInterf clientMetierInterf;

	@Autowired
	private DeviseMetierInterf deviseMetierInterf;

	@Autowired
	private UtilisateurMetierInterf utilisateurMetierInterf;

	@RequestMapping(value = "/index")
	public String index(Model model, HttpServletRequest httpServletRequest) {
		model.addAttribute("facturedroit", new Facture());
		model.addAttribute("facturelist", factureMetierInterf.listFacture());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		model.addAttribute("deviselist", deviseMetierInterf.listDevise());
		model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUser());
		return "facturededroit";
	}

	public Integer nulClientTsyVallide(Integer valCli, String valStatut) {
		Query req = em
				.createQuery("select c.commandeId from Commande c where clientId = :valCli and c.statut = :valStatut")
				.setParameter("valCli", valCli).setParameter("valStatut", valStatut);
		Integer val = (Integer) req.getSingleResult();
		return val;

	}

	@RequestMapping(value = "/saveFacture")
	public String saveFactureDroit(@Valid Facture fac, Model model, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("facturelist", factureMetierInterf.listFacture());
			model.addAttribute("clientlist", clientMetierInterf.listClient());
			model.addAttribute("deviselist", deviseMetierInterf.listDevise());
			model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUser());
			return "facturepage";
		}
		factureMetierInterf.addFacture(fac);
		model.addAttribute("facturedroit", new Facture());
		model.addAttribute("facturelist", factureMetierInterf.listFacture());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		model.addAttribute("deviselist", deviseMetierInterf.listDevise());
		model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUser());
		return "facturededroit";

	}

	@RequestMapping(value = "/editFacutre")
	public String editFacture(Integer commandeId, Model model, HttpServletRequest httpServletRequest) {
		return "facturededroit";
	}

	// maka valeur list @ client s statut

	public List<Client> listClientTsyVallide(Integer valCli, String valStatut) {
		// Query req = em
		// .createQuery("select c.commandeId from Commande c where clientId = :valCli
		// and c.statut = :valStatut")
		// .setParameter("valCli", valCli).setParameter("valStatut", valStatut);

		Query req = em
				.createQuery("select c.clientNom from Client c where c.clientId = :vidCli and clientPrenom =:valStatut")
				.setParameter("vidCli", valCli).setParameter("valStatut", valStatut);

		return req.getResultList();
	}

	// // mandefa valeur
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public @ResponseBody List<Client> mamoakaCommande(@RequestParam("clientIdComm") Integer clientId) {
		String valStut = "bE";
		return listClientTsyVallide(clientId, valStut);

	}

	// public List<Client> listClientAnatyCommande(Integer vidCli) {
	//
	// Query req = em.createQuery("select c.clientNom from Client c where c.clientId
	// = :vidCli").setParameter("vidCli",
	// vidCli);
	//
	// List<Client> list = new ArrayList<Client>();
	// Client client1 = new Client(), client2 = new Client();
	// client1.setClientNom("Willy");
	// client2.setClientNom("test");
	// list.add(client1);
	// list.add(client2);
	// return list;
	// }
	//
	// @RequestMapping(value = "/index", method = RequestMethod.POST)
	// public @ResponseBody List<Client> affciheList(@RequestParam("clientIdComm")
	// Integer clientId) {
	// return listClientAnatyCommande(clientId);
	// }
}
