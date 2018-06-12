package mg.uha.miage.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

import mg.uha.miage.entities.Achat;
import mg.uha.miage.entities.Client;
import mg.uha.miage.entities.Facture;
import mg.uha.miage.metier.interf.ClientMetierInterf;
import mg.uha.miage.metier.interf.CommandeMetierInterf;
import mg.uha.miage.metier.interf.DeviseMetierInterf;
import mg.uha.miage.metier.interf.FactureMetierInterf;
import mg.uha.miage.metier.interf.PayementMetierInterf;
import mg.uha.miage.metier.interf.UtilisateurMetierInterf;

@Controller
@RequestMapping(value = "/FactureDroit")
@Transactional
public class FactureDroitController {
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private PayementMetierInterf payementMetierInterf;

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
		model.addAttribute("user", utilisateur.getUser(httpServletRequest));
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
	public String saveFactureDroit(@Valid Facture fac, Model model, BindingResult bindingResult,
			HttpServletRequest httpServletRequest) {
		if (bindingResult.hasErrors()) {

			model.addAttribute("facturelist", factureMetierInterf.listFacture());
			model.addAttribute("clientlist", clientMetierInterf.listClient());
			model.addAttribute("deviselist", deviseMetierInterf.listDevise());
			model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUser());
			return "facturepage";
		}

		factureMetierInterf.addFacture(fac);
		model.addAttribute("user", utilisateur.getUser(httpServletRequest));

		HttpSession session = httpServletRequest.getSession();

		session.setAttribute("valeurUtilisateur", numeroUtilisateur(utilisateur.getUser(httpServletRequest)));

		session.setAttribute("valeurCommande", fac.getNumCommande());
		// numero facture
		session.setAttribute("valeurFacture", fac.getFactureId());

		session.setAttribute("valeurClient", fac.getClient().getClientId());

		Integer testNumCommande = (Integer) session.getAttribute("valeurCommande");
		Integer testNumFacture = (Integer) session.getAttribute("valeurFacture");

		System.out.println("après ajout" + testNumCommande);
		System.out.println("après ajout" + testNumFacture);
		model.addAttribute("facturelist", listAchatCommande(fac.getNumCommande()));
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		model.addAttribute("deviselist", deviseMetierInterf.listDevise());
		model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUser());
		return "listeachat";

	}

	@RequestMapping(value = "/validationAchat")
	public String validationAchat(Model model, HttpServletRequest httpServletRequest) {
		HttpSession session = httpServletRequest.getSession();

		Integer testNumCommande = (Integer) session.getAttribute("valeurCommande");
		Integer testNumFacture = (Integer) session.getAttribute("valeurFacture");

		factureMetierInterf.modificationAchatFacture(testNumCommande, testNumFacture);

		Facture f = factureMetierInterf.getFactureId(testNumFacture);

		model.addAttribute("facturedroit", f);

		model.addAttribute("user", utilisateur.getUser(httpServletRequest));
		model.addAttribute("facturelist", factureMetierInterf.listFacture());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		model.addAttribute("deviselist", deviseMetierInterf.listDevise());
		model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUser());
		return "validationachat";
	}

	@RequestMapping(value = "/validationFacture")
	public String validationFacture(@Valid Facture facture, Model model, HttpServletRequest httpServletRequest) {
		HttpSession session = httpServletRequest.getSession();

		Integer testNumFacture = (Integer) session.getAttribute("valeurFacture");
		Integer testNumClient = (Integer) session.getAttribute("valeurClient");
		Integer testNumerUtilisateur = (Integer) session.getAttribute("valeurUtilisateur");

		facture.setUtilisateur(utilisateurMetierInterf.getUser(testNumerUtilisateur));

		facture.setClient(clientMetierInterf.getClient(testNumClient));

		factureMetierInterf.updateFacture(facture);

		System.out.println("Montnant " + facture.getMontantFacture());
		factureMetierInterf.mofidificationFactureSave(testNumFacture);
		payementMetierInterf.insertioPayement(testNumFacture, testNumClient);

		model.addAttribute("facturedroit", new Facture());
		return "validationachat";
	}

	@RequestMapping(value = "/editFacutre")
	public String editFacture(Integer commandeId, Model model, HttpServletRequest httpServletRequest) {
		return "facturededroit";
	}

	// maka valeur list @ client s statut

	public List<Client> listClientTsyVallide(Integer valCli, String valStatut) {
		Query req = em
				.createQuery("select c.commandeId from Commande c where clientId = :valCli and c.statut = :valStatut")
				.setParameter("valCli", valCli).setParameter("valStatut", valStatut);
		return req.getResultList();
	}

	public void ajoutFac(Integer valCli) {
		Query req = em.createNativeQuery("INSERT INTO facture (clientId) values (:valCommande)")
				.setParameter("valCommande", valCli);
		req.executeUpdate();
	}

	// // mandefa valeur
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public @ResponseBody List<Client> mamoakaCommande(@RequestParam("clientIdComm") Integer clientId) {
		String valStut = "En cours";
		return listClientTsyVallide(clientId, valStut);
	}

	// liste achat anaty commande recherche

	public List<Achat> listAchatCommande(Integer commandeId) {
		Query req = em.createQuery("select a from Achat a where factureId IS NULL and commandeId = :commandeId")
				.setParameter("commandeId", commandeId);
		return req.getResultList();
	}

	public Integer numeroUtilisateur(String nomUtili) {
		Query req = em.createQuery("select u.utilisateurId from Utilisateur u where u.login =:nomUtili")
				.setParameter("nomUtili", nomUtili);
		Integer valNum = (Integer) req.getSingleResult();
		return valNum;
	}

}
