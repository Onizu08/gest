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
import mg.uha.miage.metier.interf.PaysMetierInterf;
import mg.uha.miage.metier.interf.VilleMetierInterf;

@Controller
@RequestMapping(value = "/Client")
public class ClientController {

	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
	private ClientMetierInterf clientMetierInterf;

	@Autowired
	private VilleMetierInterf villemetierInterf;

	@Autowired
	private PaysMetierInterf paysMetierInterf;

	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("client", new Client());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		model.addAttribute("villelist", villemetierInterf.listVille());
		model.addAttribute("payslist", paysMetierInterf.listPays());
		// return "clientpages";

		return "exemplePage";

	}

	@RequestMapping(value = "/saveClient")
	public String saveClient(@Valid Client c, Model model, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("clientlist", clientMetierInterf.listClient());
			model.addAttribute("villelist", villemetierInterf.listVille());
			model.addAttribute("payslist", paysMetierInterf.listPays());
			return "exemplePage";
		}

		Client v = new Client();
		String pa = "Particulier";
		v.setClientType(pa);
		System.out.println("maka valeur" + c.getClientType());
		System.out.println("valeur apres modification " + v.getClientType());
		// anao ajout
		if (c.getClientId() == null) {

			// mande ajout client; mila modifien ny iste payse
			if (c.getClientType().toString().equals(v.getClientType().toString())) {

				System.out.println("valeur post" + c.getPostale());
				// clientMetierInterf.addClientP(c.getClientNom(),
				// c.getClientPrenom(), c.getMail(),
				// c.getClientTelephone(), c.getAdresseClient(), c.getPostale(),
				// c.getVille().getIdVille(),
				// c.getPays());
			} else {

				// ajout societe
				//
				// clientMetierInterf.addSocieteC(c.getNomSociete(),
				// c.getSiret(), c.getClientNom(), c.getClientPrenom(),
				// c.getMail(), c.getClientTelephone(), c.getTelephonSocie(),
				// c.getAdresseClient(), c.getPays(),
				// c.getPostale());
				// // c.getVille().getIdVille(),

				System.out.println("valeur nom " + c.getClientNom());
				System.out.println("valeur nomSoc " + c.getNomSociete());
				System.out.println("valeur post" + c.getPostale());

				//
				// clientMetierInterf.addSociete(c.getNomSociete(),
				// c.getSiret(), c.getClientNom(), c.getClientPrenom(),
				// c.getMail(), c.getClientTelephone(), c.getTelephonSocie(),
				// c.getAdresseClient(),
				// c.getPostale());
				System.out.println("Ajout effectué Societe");
			}
		}
		// debut modification
		else {
			System.out.println("modification");
		}
		model.addAttribute("client", new Client());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		model.addAttribute("villelist", villemetierInterf.listVille());
		model.addAttribute("payslist", paysMetierInterf.listPays());
		return "exemplePage";

	}

	@RequestMapping(value = "/editClient")
	public String editClient(Integer clientId, Model model) {
		Client client = clientMetierInterf.getClient(clientId);
		model.addAttribute("client", client);
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		model.addAttribute("villelist", villemetierInterf.listVille());
		return "exemplePage";
	}

	@RequestMapping(value = "/deleteClient")
	public String deleteClient(Integer clientId, Model model) {
		clientMetierInterf.deleteClient(clientId);
		model.addAttribute("client", new Client());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		model.addAttribute("villelist", villemetierInterf.listVille());
		// return "clientpages";
		return "exemplePage";
	}
}
