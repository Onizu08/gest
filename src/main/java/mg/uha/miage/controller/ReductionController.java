package mg.uha.miage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import mg.uha.miage.entities.Reduction;
import mg.uha.miage.metier.interf.ReductionMetierInterf;

@Controller
@RequestMapping(value = "/Reduction")
public class ReductionController {

	@Autowired
	private ReductionMetierInterf reductionMetierInterf;

	@RequestMapping(value = "/index")
	private String index(Model model) {
		model.addAttribute("reduction", new Reduction());
		model.addAttribute("reductionlist", reductionMetierInterf.listReduction());
		return "reductionpage";
	}

	@RequestMapping(value = "/saveReduction")
	public String saveReduction(@Valid Reduction ville, Model model, BindingResult bindingResult,
			HttpServletRequest httpServletRequest) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("reductionlist", reductionMetierInterf.listReduction());
			return "reductionpage";
		}
		if (ville.getReductionId() != null) {
			reductionMetierInterf.updateReduction(ville);
		} else {
			if (ville.getReductionLib() == "" || ville.getReductionApplique() == "") {
				model.addAttribute("error", "veuiller remplir les champs");
			} else {
				reductionMetierInterf.ajoutReduction(ville);
			}
		}
		model.addAttribute("Succes", "Ville ajouté avec succès");
		model.addAttribute("reduction", new Reduction());
		model.addAttribute("reductionlist", reductionMetierInterf.listReduction());
		return "reductionpage";
	}

	@RequestMapping(value = "/editReduction")
	public String editReduction(Integer reductionId, Model model, HttpServletRequest httpServletRequest) {
		Reduction ville = reductionMetierInterf.getReduction(reductionId);
		model.addAttribute("reduction", ville);
		model.addAttribute("reductionlist", reductionMetierInterf.listReduction());
		return "reductionpage";
	}

	@RequestMapping(value = "/deleteReduction")
	public String deleteVille(Integer reductionId, Model model, HttpServletRequest httpServletRequest) {
		reductionMetierInterf.deleteReduction(reductionId);
		model.addAttribute("Succes", "Suppression effectuée");
		model.addAttribute("reduction", new Reduction());
		model.addAttribute("reductionlist", reductionMetierInterf.listReduction());
		return "reductionpage";
	}

}
