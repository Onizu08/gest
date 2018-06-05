package mg.uha.miage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mg.uha.miage.entities.Achat;
import mg.uha.miage.metier.interf.AchatMetierInterf;
import mg.uha.miage.metier.interf.ArticleMetierInterf;
import mg.uha.miage.metier.interf.CommandeMetierInterf;
import mg.uha.miage.metier.interf.FactureMetierInterf;

@Controller
@RequestMapping(value = "/Achat")
public class AchatController {

	MakaUtilisateur utilisateur = new MakaUtilisateur();

	@Autowired
	private AchatMetierInterf achatMetierInterf;

	@Autowired
	private CommandeMetierInterf commandeMetierInterf;
	@Autowired
	private ArticleMetierInterf articleMetierInterf;

	@Autowired
	private FactureMetierInterf factureMetierInterf;

	@RequestMapping(value = "/index")
	public String index(Model model, HttpServletRequest httpServletRequest) {
		model.addAttribute("user", utilisateur.getUser(httpServletRequest));
		model.addAttribute("achat", new Achat());
		model.addAttribute("achatlist", achatMetierInterf.listAchat());
		model.addAttribute("articlelist", articleMetierInterf.listArticle());
		model.addAttribute("commandelist", commandeMetierInterf.listCommande());
		model.addAttribute("facturelist", factureMetierInterf.listFacture());
		return "achatpage";
	}

}
