package mg.uha.miage.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import mg.uha.miage.entities.Client;
import mg.uha.miage.metier.interf.ClientMetierInterf;

@Controller
@RequestMapping(value = "/Client")
public class ClientController {

	@Autowired
	private ClientMetierInterf clientMetierInterf;

	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("client", new Client());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		return "clientpages";
	}

	@RequestMapping(value = "/saveClient")
	public String saveClient(@Valid Client c, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("clientlist", clientMetierInterf.listClient());
			return "clientpages";
		}
		if (c.getClientId() != null) {
			clientMetierInterf.updateClient(c);
		} else {
			clientMetierInterf.ajoutClient(c);
		}
		model.addAttribute("client", new Client());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		return "clientpages";
	}

	@RequestMapping(value = "/editClient")
	public String editClient(Integer clientId, Model model) {
		Client c = clientMetierInterf.getClient(clientId);
		model.addAttribute("client", c);
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		return "clientpages";
	}

	@RequestMapping(value = "/deleteClient")
	public String deleteClient(Integer clientId, Model model) {
		clientMetierInterf.deleteClient(clientId);
		model.addAttribute("client", new Client());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		return "clientpages";
	}
}
