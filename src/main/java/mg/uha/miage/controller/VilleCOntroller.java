package mg.uha.miage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import mg.uha.miage.entities.Ville;
import mg.uha.miage.metier.interf.PaysMetierInterf;
import mg.uha.miage.metier.interf.VilleMetierInterf;

@Controller
@RequestMapping(value = "Ville")
public class VilleCOntroller {

	@Autowired
	private VilleMetierInterf villeMetierInterf;

	@Autowired
	private PaysMetierInterf paysMetierInterf;

	@RequestMapping(value = "/index")
	private String index(Model model) {
		model.addAttribute("ville", new Ville());
		model.addAttribute("villelist", villeMetierInterf.listVille());
		model.addAttribute("paylist", paysMetierInterf.listPays());
		return "villepage";
	}

	@RequestMapping(value = "/saveVille")
	public String savePays(@Valid Ville ville, Model model, BindingResult bindingResult,
			HttpServletRequest httpServletRequest) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("villelist", villeMetierInterf.listVille());
			model.addAttribute("paylist", paysMetierInterf.listPays());
			return "villepage";
		}
		if (ville.getIdVille() != "") {
			villeMetierInterf.updateVille(ville);
		} else {
			if (ville.getIdVille() == "" || ville.getLibVille() == "") {
				model.addAttribute("error", "veuiller remplir les champs");
			} else {
				villeMetierInterf.ajoutVille(ville);
			}
		}
		model.addAttribute("Succes", "Ville ajouté avec succès");
		model.addAttribute("ville", new Ville());
		model.addAttribute("villelist", villeMetierInterf.listVille());
		model.addAttribute("paylist", paysMetierInterf.listPays());
		return "villepage";
	}

	@RequestMapping(value = "/editVille")
	public String editVille(String idVille, Model model, HttpServletRequest httpServletRequest) {
		Ville ville = villeMetierInterf.getVille(idVille);
		model.addAttribute("ville", ville);
		model.addAttribute("villelist", villeMetierInterf.listVille());
		model.addAttribute("paylist", paysMetierInterf.listPays());
		return "villepage";
	}

	@RequestMapping(value = "/deleteVille")
	public String deleteVille(String idVille, Model model, HttpServletRequest httpServletRequest) {
		villeMetierInterf.deleteVille(idVille);
		model.addAttribute("Succes", "Suppression effectuée");
		model.addAttribute("ville", new Ville());
		model.addAttribute("villelist", villeMetierInterf.listVille());
		model.addAttribute("paylist", paysMetierInterf.listPays());
		return "villepage";
	}
}
