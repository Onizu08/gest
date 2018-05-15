package mg.uha.miage.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import mg.uha.miage.entities.Profil;
import mg.uha.miage.metier.interf.ProfilMetierInterf;

@Controller
@RequestMapping(value = "/Profil")
public class ProfilController {

	@Autowired
	private ProfilMetierInterf profilMetierInterf;

	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("profil", new Profil());
		model.addAttribute("profillist", profilMetierInterf.listProfil());
		return "profilpage";
	}

	@RequestMapping(value = "/saveProfil")
	public String saveProfil(@Valid Profil profil, Model model, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("profillist", profilMetierInterf.listProfil());
			return "profilpage";
		}
		if (profil.getProfileId() != null) {
			profilMetierInterf.udpateProfil(profil);
		} else {
			if (profil.getProfileLib() == null) {
				model.addAttribute("error", "Veuiller remplir le forumlaire");
			} else {
				profilMetierInterf.addProfil(profil);
			}
		}
		model.addAttribute("profil", new Profil());
		model.addAttribute("profillist", profilMetierInterf.listProfil());
		return "profilpage";
	}

	@RequestMapping(value = "/editProfil")
	public String editProfil(Integer profilId, Model model) {
		Profil p = profilMetierInterf.getProfil(profilId);
		model.addAttribute("profil", p);
		model.addAttribute("profillist", profilMetierInterf.listProfil());
		return "profilpage";
	}

	@RequestMapping(value = "/deleteProfil")
	public String deleteProfil(Integer profilId, Model model) {
		profilMetierInterf.deleteProfil(profilId);
		model.addAttribute("profil", new Profil());
		model.addAttribute("profillist", profilMetierInterf.listProfil());
		return "profilpage";
	}
}
