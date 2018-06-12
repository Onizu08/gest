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

import mg.uha.miage.entities.Client;
import mg.uha.miage.entities.Payer;
import mg.uha.miage.metier.interf.ClientMetierInterf;

@RequestMapping(value = "RecherchePayement")
@Controller
@Transactional
public class RecherchePayementController {

	@PersistenceContext
	private EntityManager em;

	MakaUtilisateur utilisateur = new MakaUtilisateur();

	@Autowired
	private ClientMetierInterf clientMetierInterf;

	@RequestMapping(value = "/index")
	public String index(Model model, HttpServletRequest httpServletRequest) {
		model.addAttribute("payement", new Payer());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		return "recherchepayement";
	}

	@RequestMapping(value = "/recherche")
	public String recherche(@Valid Payer p, Model model, BindingResult bindingResult,
			HttpServletRequest httpServletRequest) {
		if (bindingResult.hasErrors()) {
			return "recherchepayement";
		}
		model.addAttribute("payement", new Payer());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		model.addAttribute("payementlist", listPayement(p.getClient().getClientId()));
		return "recherchepayement";
	}

	public List<Payer> listPayement(Integer clientId) {
		Query req = em.createQuery("select p from Payer p where clientId = :clientId").setParameter("clientId",
				clientId);
		return req.getResultList();
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
