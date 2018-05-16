package mg.uha.miage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import mg.uha.miage.entities.Categorie;
import mg.uha.miage.metier.interf.CategorieMetierInterf;

@Controller
@RequestMapping(value = "/Categorie")
public class CategorieController {

	@Autowired
	private CategorieMetierInterf categorieMetierInterf;

	@RequestMapping(value = "/index")
	private String index(Model model) {
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categorielist", categorieMetierInterf.listCategorie());
		return "categoriepage";
	}

	@RequestMapping(value = "/saveCategorie")
	public String saveCategorie(@Valid Categorie ville, Model model, BindingResult bindingResult,
			HttpServletRequest httpServletRequest) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("categorielist", categorieMetierInterf.listCategorie());
			return "categoriepage";
		}
		if (ville.getCategorieId() != null) {
			categorieMetierInterf.updateCategorie(ville);
		} else {
			if (ville.getCategorieLib() == "" || ville.getPromoCategorie() == "") {
				model.addAttribute("error", "veuiller remplir les champs");
			} else {
				categorieMetierInterf.ajoutCategorie(ville);
			}
		}
		model.addAttribute("Succes", "Ville ajouté avec succès");
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categorielist", categorieMetierInterf.listCategorie());
		return "categoriepage";
	}

	@RequestMapping(value = "/editCategorie")
	public String editCategorie(Integer categorieId, Model model, HttpServletRequest httpServletRequest) {
		Categorie ville = categorieMetierInterf.getCategorie(categorieId);
		model.addAttribute("categorie", ville);
		model.addAttribute("categorielist", categorieMetierInterf.listCategorie());
		return "categoriepage";
	}

	@RequestMapping(value = "/deleteCategorie")
	public String deleteVille(Integer categorieId, Model model, HttpServletRequest httpServletRequest) {
		categorieMetierInterf.deleteCategorie(categorieId);
		model.addAttribute("Succes", "Suppression effectuée");
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categorielist", categorieMetierInterf.listCategorie());
		return "categoriepage";
	}
}
