package mg.uha.miage.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import mg.uha.miage.entities.Commande;
import mg.uha.miage.metier.interf.ClientMetierInterf;
import mg.uha.miage.metier.interf.CommandeMetierInterf;

@Controller
@RequestMapping(value = "/Commande")
public class CommandeController {
	@Autowired
	private CommandeMetierInterf commandeMetierInterf;

	@Autowired
	private ClientMetierInterf clientMetierInterf;

	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("commande", new Commande());
		model.addAttribute("commandelist", commandeMetierInterf.listCommande());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		return "commandepage";
	}

	@RequestMapping(value = "/saveCommande")
	public String saveCommande(@Valid Commande commande, Model model, BindingResult bindingResult) {

		model.addAttribute("commande", new Commande());
		model.addAttribute("commandelist", commandeMetierInterf.listCommande());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		return "commandepage";
	}

	@RequestMapping(value = "/deleteCommande")

	public String deleteCommande(Integer commandeId, Model model) {
		commandeMetierInterf.deleteCommande(commandeId);
		model.addAttribute("commande", new Commande());
		model.addAttribute("commandelist", commandeMetierInterf.listCommande());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		return "commandepage";
	}
}
