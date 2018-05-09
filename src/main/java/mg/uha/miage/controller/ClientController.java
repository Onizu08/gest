package mg.uha.miage.controller;

import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import mg.uha.miage.entities.Client;
import mg.uha.miage.metier.interf.ClientMetierInterf;
import mg.uha.miage.metier.interf.VilleMetierInterf;

@Controller
@RequestMapping(value = "/Client")
public class ClientController {

	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
	private ClientMetierInterf clientMetierInterf;

	@Autowired
	private VilleMetierInterf villemetierInterf;

	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("client", new Client());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		model.addAttribute("villelist", villemetierInterf.listVille());

		return "clientpages";
	}

	@RequestMapping(value = "/saveClient")
	public String saveClient(@Valid Client c, Model model, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("clientlist", clientMetierInterf.listClient());
			model.addAttribute("villelist", villemetierInterf.listVille());
			return "clientpages";
		}
		if (c.getClientId() == null) {
			System.out.println("avant ajout" + c.getClientId());
			clientMetierInterf.ajoutClient(c);
		} else {
			System.out.println("avant modification" + c.getClientId());
			clientMetierInterf.updateClient(c);
		}
		model.addAttribute("client", new Client());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		model.addAttribute("villelist", villemetierInterf.listVille());
		return "clientpages";
	}

	@RequestMapping(value = "/editClient")
	public String editClient(Integer clientId, Model model) {
		Client client = clientMetierInterf.getClient(clientId);
		System.out.println("num client" + client.getClientId());
		model.addAttribute("client", client);
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		model.addAttribute("villelist", villemetierInterf.listVille());
		return "clientpages";
	}

	@RequestMapping(value = "/deleteClient")
	public String deleteClient(Integer clientId, Model model) {
		clientMetierInterf.deleteClient(clientId);
		model.addAttribute("client", new Client());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		model.addAttribute("villelist", villemetierInterf.listVille());
		return "clientpages";
	}
}
