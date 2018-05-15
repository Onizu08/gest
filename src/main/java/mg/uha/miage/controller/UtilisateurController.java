package mg.uha.miage.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import mg.uha.miage.entities.Utilisateur;
import mg.uha.miage.metier.interf.ProfilMetierInterf;
import mg.uha.miage.metier.interf.UtilisateurMetierInterf;

@Controller
@RequestMapping(value = "/Utilisateur")
public class UtilisateurController {

	@Autowired
	private UtilisateurMetierInterf utilisateurMetierInterf;

	@Autowired
	private ProfilMetierInterf profilMetierInterf;

	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("utilisateur", new Utilisateur());
		model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUser());
		model.addAttribute("profilelist", profilMetierInterf.listProfil());
		return "utilisateurpage";
	}

	@RequestMapping(value = "/saveUtilisateur")
	public String saveUtilisateur(@Valid Utilisateur utilisateur, Model model, BindingResult b) {
		if (b.hasErrors()) {
			model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUser());
			model.addAttribute("profilelist", profilMetierInterf.listProfil());
			return "utilisateurpage";
		}
		if (utilisateur.getUtilisateurId() != null) {
			utilisateurMetierInterf.udpateUser(utilisateur);
		} else {
			if (utilisateur.getLogin() == null || utilisateur.getPwd() == null) {
				model.addAttribute("error", "Veuiller remplir le formulaire");
			} else {
				utilisateurMetierInterf.addUser(utilisateur);
			}
		}
		model.addAttribute("utilisateur", new Utilisateur());
		model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUser());
		model.addAttribute("profilelist", profilMetierInterf.listProfil());
		return "utilisateurpage";
	}

	@RequestMapping(value = "/editUtilisateur")
	public String editUtilisateur(Integer utilisateurId, Model model) {
		Utilisateur u = utilisateurMetierInterf.getUser(utilisateurId);
		model.addAttribute("utilisateur", u);
		model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUser());
		model.addAttribute("profilelist", profilMetierInterf.listProfil());
		return "utilisateurpage";
	}

	@RequestMapping(value = "/deleteUtilisateur")
	public String deleteUtilisateur(Integer utilisateurId, Model model) {
		utilisateurMetierInterf.deleteUser(utilisateurId);
		model.addAttribute("utilisateur", new Utilisateur());
		model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUser());
		model.addAttribute("profilelist", profilMetierInterf.listProfil());
		return "utilisateurpage";
	}
}
