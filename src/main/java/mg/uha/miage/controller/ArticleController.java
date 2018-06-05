package mg.uha.miage.controller;

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

import mg.uha.miage.entities.Article;
import mg.uha.miage.metier.interf.ArticleMetierInterf;
import mg.uha.miage.metier.interf.CategorieMetierInterf;

@Controller
@RequestMapping(value = "/Article")
@Transactional
public class ArticleController {

	@PersistenceContext
	private EntityManager el;
	@Autowired
	private ArticleMetierInterf articleMetierInterf;

	@Autowired
	private CategorieMetierInterf deviseMetierInterf;

	@RequestMapping(value = "/index")
	private String index(Model model) {
		model.addAttribute("article", new Article());
		model.addAttribute("articlelist", articleMetierInterf.listArticle());
		model.addAttribute("categorielist", deviseMetierInterf.listCategorie());
		return "articlepage";
	}

	@RequestMapping(value = "/saveArticle")
	public String saveCategorie(@Valid Article ville, Model model, BindingResult bindingResult,
			HttpServletRequest httpServletRequest) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("articlelist", articleMetierInterf.listArticle());
			model.addAttribute("categorielist", deviseMetierInterf.listCategorie());
			return "articlepage";
		}
		if (ville.getArticleId() != null) {
			articleMetierInterf.updateArticle(ville);
		} else {
			if (ville.getRefArticle() == "" || ville.getNomArticle() == "" || ville.getPrixUnitaire() == null) {
				model.addAttribute("error", "veuiller remplir les champs");
			} else {
				articleMetierInterf.ajoutArticle(ville);
			}
		}
		model.addAttribute("Succes", "Ville ajouté avec succès");
		model.addAttribute("categorie", new Article());
		model.addAttribute("articlelist", articleMetierInterf.listArticle());
		model.addAttribute("categorielist", deviseMetierInterf.listCategorie());
		return "articlepage";
	}

	@RequestMapping(value = "/editArticle")
	public String editCategorie(Integer articleId, Model model, HttpServletRequest httpServletRequest) {
		Article ville = articleMetierInterf.getArticle(articleId);
		model.addAttribute("categorie", ville);
		model.addAttribute("articlelist", articleMetierInterf.listArticle());
		model.addAttribute("categorielist", deviseMetierInterf.listCategorie());
		return "articlepage";
	}

	@RequestMapping(value = "/deleteArticle")
	public String deleteVille(Integer articleId, Model model, HttpServletRequest httpServletRequest) {
		articleMetierInterf.deleteArticle(articleId);
		model.addAttribute("Succes", "Suppression effectuée");
		model.addAttribute("article", new Article());
		model.addAttribute("articlelist", articleMetierInterf.listArticle());
		model.addAttribute("categorielist", deviseMetierInterf.listCategorie());
		return "articlepage";
	}

	
}
