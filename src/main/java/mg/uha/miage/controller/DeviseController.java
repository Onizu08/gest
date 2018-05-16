package mg.uha.miage.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import mg.uha.miage.entities.Devise;
import mg.uha.miage.metier.interf.DeviseMetierInterf;

@Controller
@RequestMapping(value = "/Devise")
public class DeviseController {

	@Autowired
	private DeviseMetierInterf deviseMetierInterf;

	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("devise", new Devise());
		model.addAttribute("deviselist", deviseMetierInterf.listDevise());
		return "devisepage";
	}

	@RequestMapping(value = "/saveDevise")
	public String saveDevise(@Valid Devise fac, Model model, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("deviselist", deviseMetierInterf.listDevise());
			return "devisepage";
		}
		if (fac.getDeviseId() != "") {
			if (fac.getDeviseLibelle() == "" || fac.getTauxDevise() == null) {
				model.addAttribute("error", "Veuiller remplir les champs");
			} else {
				deviseMetierInterf.updateDevise(fac);
			}
		} else {
			if (fac.getDeviseLibelle() == "" || fac.getTauxDevise() == null) {
				model.addAttribute("error", "Veuiller remplir les champs");
			} else {
				deviseMetierInterf.addDevise(fac);
			}
		}
		model.addAttribute("devise", new Devise());
		model.addAttribute("deviselist", deviseMetierInterf.listDevise());
		return "devisepage";
	}

	@RequestMapping(value = "/editDevise")
	public String editDevise(String deviseId, Model model) {
		Devise f = deviseMetierInterf.getDevise(deviseId);
		model.addAttribute("devise", f);
		model.addAttribute("deviselist", deviseMetierInterf.listDevise());
		return "devisepage";
	}

	@RequestMapping(value = "/deleteDevise")
	public String deleteDevise(String deviseId, Model model) {
		deviseMetierInterf.deleteDEvise(deviseId);
		model.addAttribute("devise", new Devise());
		model.addAttribute("deviselist", deviseMetierInterf.listDevise());
		return "devisepage";
	}
}
