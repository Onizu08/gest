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

		/// ajout avec procedure

		// clientMetierInterf.addClientP(c.getClientNom(), c.getClientPrenom(),
		// c.getMail(), c.getClientTelephone(),
		// c.getAdresseClient(), c.getPostale(), c.getVille().getIdVille(),
		// c.getPays());

		// System.out.println("ajout réussi");

		// fin ajout avec procedure

		Client v = new Client();
		String pa = "Particulier";
		v.setClientType(pa);
		System.out.println("maka valeur" + c.getClientType());
		System.out.println("valeur apres modification " + v.getClientType());

		if (c.getClientType().toString().equals(v.getClientType().toString())) {
			System.out.println("1");
			System.out.println("valeur " + v.getClientType());
			clientMetierInterf.addClientP(c.getClientNom(), c.getClientPrenom(), c.getMail(), c.getClientTelephone(),
					c.getAdresseClient(), c.getPostale(), c.getVille().getIdVille(), c.getPays());
		} else {
			System.out.println("2" + v.getClientType());
			System.out.println("tsy mosu");

			clientMetierInterf.addSocieteC(c.getNomSociete(), c.getSiret(), c.getClientNom(), c.getClientPrenom(),
					c.getMail(), c.getClientTelephone(), c.getTelephonSocie(), c.getFax(), c.getAdresseClient(),
					c.getVille().getIdVille(), c.getPays(), c.getPostale());

		}
		// if (c.getClientId() == null) {
		// if (c.getClientNom() == "" || c.getClientPrenom() == "" ||
		// c.getDateNaissanceClient() == null
		// || c.getAdresseClient() == "" || c.getClientTelephone() == "" || c.getMail()
		// == ""
		// || c.getClientType() == "" || c.getDateDebutClient() == null ||
		// c.getMonantDu() == null
		// || c.getMontantAvoir() == null || c.getTauxRemise() == null) {
		//
		// model.addAttribute("error", "veuiller remplir les champs");
		// } else {
		// clientMetierInterf.ajoutClient(c);
		// }
		//
		// } else {
		// clientMetierInterf.updateClient(c);
		// }
		model.addAttribute("client", new Client());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		model.addAttribute("villelist", villemetierInterf.listVille());
		return "clientpages";
	}

	@RequestMapping(value = "/editClient")
	public String editClient(Integer clientId, Model model) {
		Client client = clientMetierInterf.getClient(clientId);
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
