package mg.uha.miage.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import mg.uha.miage.entities.Societe;
import mg.uha.miage.metier.interf.SocieteMetierInterf;

@Controller
@RequestMapping(value = "/Societe")
public class SocieteController {

	@Autowired
	private SocieteMetierInterf societeMetierInterf;

	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("societe", new Societe());
		model.addAttribute("societelist", societeMetierInterf.listSociete());
		return "societepage";
	}

	@RequestMapping(value = "/saveSociete")
	public String saveSociete(@Valid Societe soc, Model model, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("societelist", societeMetierInterf.listSociete());
			return "societepage";
		}
		if (soc.getSocieteId() != null) {
			societeMetierInterf.updateSociete(soc);
		} else {
			model.addAttribute("error", "Aucune Modification effectué");
		}
		model.addAttribute("societe", new Societe());
		model.addAttribute("societelist", societeMetierInterf.listSociete());
		return "societepage";
	}

	@RequestMapping(value = "/editSociete")
	public String editSociete(Integer societeId, Model model) {
		Societe soc = societeMetierInterf.getSociete(societeId);
		model.addAttribute("societe", soc);
		model.addAttribute("societelist", societeMetierInterf.listSociete());
		return "societepage";
	}

	@RequestMapping(value = "/deleteSociete")
	public String deleteSociete(Integer societeId, Model model) {
		societeMetierInterf.deleteSociete(societeId);
		model.addAttribute("societe", new Societe());
		model.addAttribute("societelist", societeMetierInterf.listSociete());
		return "societepage";

	}
}
