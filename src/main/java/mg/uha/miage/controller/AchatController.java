package mg.uha.miage.controller;

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

import mg.uha.miage.entities.Achat;
import mg.uha.miage.entities.Article;
import mg.uha.miage.entities.Commande;
import mg.uha.miage.metier.interf.AchatMetierInterf;
import mg.uha.miage.metier.interf.ArticleMetierInterf;
import mg.uha.miage.metier.interf.CommandeMetierInterf;
import mg.uha.miage.metier.interf.FactureMetierInterf;

@Controller
@RequestMapping(value = "/Achat")
@Transactional
public class AchatController {

	@PersistenceContext
	private EntityManager em;

	MakaUtilisateur utilisateur = new MakaUtilisateur();

	@Autowired
	private AchatMetierInterf achatMetierInterf;

	@Autowired
	private CommandeMetierInterf commandeMetierInterf;
	@Autowired
	private ArticleMetierInterf articleMetierInterf;

	@Autowired
	private FactureMetierInterf factureMetierInterf;

	String val = "En cours";

	@RequestMapping(value = "/index")
	public String index(Model model, HttpServletRequest httpServletRequest) {

		model.addAttribute("user", utilisateur.getUser(httpServletRequest));
		model.addAttribute("achat", new Achat());
		model.addAttribute("achatlist", achatMetierInterf.listAchat());
		model.addAttribute("articlelist", articleMetierInterf.listArticle());
		model.addAttribute("commandelistval", listVal(val));
		model.addAttribute("facturelist", factureMetierInterf.listFacture());
		return "achatpage";
	}

	@RequestMapping(value = "/saveAchat")
	public String saveAchat(@Valid Achat achat, Model model, BindingResult bindingResult,
			HttpServletRequest httpServletRequest) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("user", utilisateur.getUser(httpServletRequest));
			model.addAttribute("achatlist", achatMetierInterf.listAchat());
			model.addAttribute("articlelist", articleMetierInterf.listArticle());
			model.addAttribute("commandelistval", listVal(val));
			model.addAttribute("facturelist", factureMetierInterf.listFacture());
			return "achatpage";
		}
		if (achat.getAchatId() == null) {
			achatMetierInterf.ajoutAchat(achat);
		} else {
			achatMetierInterf.updateAchat(achat);
		}

		model.addAttribute("user", utilisateur.getUser(httpServletRequest));
		model.addAttribute("achat", new Achat());
		model.addAttribute("achatlist", achatMetierInterf.listAchat());
		model.addAttribute("articlelist", articleMetierInterf.listArticle());
		model.addAttribute("commandelistval", listVal(val));
		model.addAttribute("facturelist", factureMetierInterf.listFacture());
		return "achatpage";
	}

	public List<Commande> listVal(String valId) {
		Query req = em.createQuery("select c from Commande c where c.statut = :valId").setParameter("valId", valId);
		return req.getResultList();
	}

	// public Float makaPrix(Integer idA) {
	// Article a = new Article();
	// Query req = em.createQuery("select a.prixUnitaire from Article a where
	// a.articleId = :idA").setParameter("idA",
	// idA);
	// Float val = (Float) req.getSingleResult();
	// a.setPrixUnitaire(val);
	// return a.getPrixUnitaire();
	// }

	// @RequestMapping(value = "/index", method = RequestMethod.POST)
	// public @ResponseBody Float affichePrenom(@RequestParam("articleId") Integer
	// indiv) {
	// return makaPrix(indiv);
	// }
}
