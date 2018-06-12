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
import mg.uha.miage.metier.interf.DeviseMetierInterf;
import mg.uha.miage.metier.interf.FactureMetierInterf;
import mg.uha.miage.metier.interf.UtilisateurMetierInterf;

@Controller
@RequestMapping(value = "/Facture")
@Transactional
public class FactureController {
	MakaUtilisateur utilisateur = new MakaUtilisateur();

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private ClientMetierInterf clientMetierInterf;
	@Autowired
	private FactureMetierInterf factureMetierInterf;

	@Autowired
	private DeviseMetierInterf deviseMetierInterf;

	@Autowired
	private UtilisateurMetierInterf utilisateurMetierInterf;

	@RequestMapping(value = "/facture")
	public String facturepage() {
		return "factpage";
	}

	@RequestMapping(value = "/index")
	public String index(Model model) {
		String valStatut = "En cours";
		model.addAttribute("facture", new Facture());
		model.addAttribute("facturelist", factureMetierInterf.listFacture());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		// model.addAttribute("clienttsyanatycommande",
		// listClientAnatyCommande());
		model.addAttribute("deviselist", deviseMetierInterf.listDevise());
		model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUser());
		System.out.println("Numéro de la commande " + numCommande(1, valStatut));
		return "facturepage";
	}

	@RequestMapping(value = "/saveFacture")
	public String saveFacture(@Valid Facture fac, Model model, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("facturelist", factureMetierInterf.listFacture());
			model.addAttribute("clientlist", clientMetierInterf.listClient());
			model.addAttribute("deviselist", deviseMetierInterf.listDevise());
			model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUser());
			return "facturepage";
		}
		if (fac.getFactureId() != null) {
			factureMetierInterf.updateFacture(fac);
		} else {
			// if (fac.getDateEcheance() == null || fac.getDateFacture() == null ||
			// fac.getFraisFacture() == null
			// || fac.getMontantFacture() == null || fac.getNbrPaiement() == null ||
			// fac.getNbrValidite() == null
			// || fac.getStatut() == "" || fac.getTypeFacture() == "") {
			// model.addAttribute("error", "Veuiller remplir les champs");
			// } else {
			factureMetierInterf.addFacture(fac);
			// }
		}
		model.addAttribute("facture", new Facture());
		model.addAttribute("facturelist", factureMetierInterf.listFacture());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		model.addAttribute("deviselist", deviseMetierInterf.listDevise());
		model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUser());
		return "facturepage";
	}

	@RequestMapping(value = "/editFacture")
	public String editFacture(Integer factureId, Model model) {
		Facture f = factureMetierInterf.getFactureId(factureId);
		model.addAttribute("facture", f);
		model.addAttribute("facturelist", factureMetierInterf.listFacture());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		model.addAttribute("deviselist", deviseMetierInterf.listDevise());
		model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUser());
		return "facturepage";
	}

	@RequestMapping(value = "/deleteFacture")
	public String deleteFacture(Integer factureId, Model model) {
		factureMetierInterf.deleteFacture(factureId);
		model.addAttribute("facture", new Facture());
		model.addAttribute("facturelist", factureMetierInterf.listFacture());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		model.addAttribute("deviselist", deviseMetierInterf.listDevise());
		model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUser());
		return "facturepage";
	}

	// facture droit avoaka liste client sy listeze commande statut tsy valide zay
	// vao atao anaty facture

	// facture d avoir

	@RequestMapping(value = "/facture/factureAvoir/index")
	public String factureAvoir(Model model, HttpServletRequest httpServletRequest) {
		return "factureavoir";
	}

	// maka commande à partir client et statut
	public Integer numCommande(Integer idClien, String statu) {
		Query req = em
				.createNativeQuery(
						"SELECT C.commandeid FROM commande C WHERE C.statut = :stat AND C.clientId = :idClie")
				.setParameter("stat", statu).setParameter("idClie", idClien);
		Integer val = (Integer) req.getSingleResult();
		return val;
	}

	public List<Client> listClientAnatyCommande(Integer vidCli) {

		Query req = em.createQuery("select c.clientNom from Client c where c.clientId = :vidCli").setParameter("vidCli",
				vidCli);

		List<Client> list = new ArrayList<Client>();
		Client client1 = new Client(), client2 = new Client();
		client1.setClientNom("Willy");
		client2.setClientNom("test");
		list.add(client1);
		list.add(client2);
		return list;
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public @ResponseBody List<Client> affciheList(@RequestParam("clientIdComm") Integer clientId) {
		return listClientAnatyCommande(clientId);
	}

	@RequestMapping(value = "/index1", method = RequestMethod.POST)
	public @ResponseBody Integer affciheNumCommande(@RequestParam("clientIdComm") Integer clientId) {
		String valStatut = "En cours";
		return numCommande(clientId, valStatut);
	}
}
