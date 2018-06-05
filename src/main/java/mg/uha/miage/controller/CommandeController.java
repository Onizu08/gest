package mg.uha.miage.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mg.uha.miage.entities.Client;
import mg.uha.miage.entities.Commande;
import mg.uha.miage.metier.interf.ClientMetierInterf;
import mg.uha.miage.metier.interf.CommandeMetierInterf;

@Controller
@RequestMapping(value = "/Commande")
@Transactional
public class CommandeController {
	MakaUtilisateur utilisateur = new MakaUtilisateur();

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private CommandeMetierInterf commandeMetierInterf;

	@Autowired
	private ClientMetierInterf clientMetierInterf;

	@RequestMapping(value = "/index")
	public String index(Model model, HttpServletRequest httpServletRequest) {
		model.addAttribute("user", utilisateur.getUser(httpServletRequest));
		model.addAttribute("commande", new Commande());
		model.addAttribute("commandelist", commandeMetierInterf.listCommande());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		return "commandepage";
	}

	@RequestMapping(value = "/saveCommande")
	public String saveCommande(@Valid Commande commande, Model model, BindingResult bindingResult,
			HttpServletRequest httpServletRequest) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("user", utilisateur.getUser(httpServletRequest));
			model.addAttribute("commandelist", commandeMetierInterf.listCommande());
			model.addAttribute("clientlist", clientMetierInterf.listClient());
			return "commandepage";
		}
		if (commande.getCommandeId() == null) {
			if (commande.getReference() == "") {
				model.addAttribute("error", "Veuiller remplir le formulaire");
			} else {
				commandeMetierInterf.ajoutCommande(commande);
			}

		} else {
			if (commande.getReference() == "") {
				model.addAttribute("error", "Veuiller remplir le formulaire");
			} else {
				commandeMetierInterf.updateCommande(commande);
			}
		}
		model.addAttribute("user", utilisateur.getUser(httpServletRequest));
		model.addAttribute("commande", new Commande());
		model.addAttribute("commandelist", commandeMetierInterf.listCommande());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		return "commandepage";
	}

	@RequestMapping(value = "/editCommande")
	public String editCommande(Integer commandeId, Model model, HttpServletRequest httpServletRequest) {
		Commande commande = commandeMetierInterf.getCommande(commandeId);
		model.addAttribute("user", utilisateur.getUser(httpServletRequest));
		model.addAttribute("commande", commande);
		model.addAttribute("commandelist", commandeMetierInterf.listCommande());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		return "commandepage";
	}

	@RequestMapping(value = "/deleteCommande")
	public String deleteCommande(Integer commandeId, Model model, HttpServletRequest httpServletRequest) {
		commandeMetierInterf.deleteCommande(commandeId);
		model.addAttribute("user", utilisateur.getUser(httpServletRequest));
		model.addAttribute("commande", new Commande());
		model.addAttribute("commandelist", commandeMetierInterf.listCommande());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		return "commandepage";
	}

	// maka donnee atao param
	public String makaPrenom(Integer e) {
		Client c = new Client();
		Query req = em.createQuery("select c.clientPrenom from Client c where c.clientId = :clientId")
				.setParameter("clientId", e);
		String prenom = (String) req.getSingleResult();
		c.setClientPrenom(prenom);
		return c.getClientPrenom();
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public @ResponseBody String affichePrenom(@RequestParam("clientId") Integer indiv) {
		return makaPrenom(indiv);
	}

}
