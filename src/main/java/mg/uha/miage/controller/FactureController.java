package mg.uha.miage.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import mg.uha.miage.entities.Facture;
import mg.uha.miage.metier.interf.ClientMetierInterf;
import mg.uha.miage.metier.interf.DeviseMetierInterf;
import mg.uha.miage.metier.interf.FactureMetierInterf;
import mg.uha.miage.metier.interf.UtilisateurMetierInterf;

@Controller
@RequestMapping(value = "/Facture")
public class FactureController {

	@Autowired
	private ClientMetierInterf clientMetierInterf;
	@Autowired
	private FactureMetierInterf factureMetierInterf;

	@Autowired
	private DeviseMetierInterf deviseMetierInterf;

	@Autowired
	private UtilisateurMetierInterf utilisateurMetierInterf;

	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("facture", new Facture());
		model.addAttribute("facturelist", factureMetierInterf.listFacture());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		model.addAttribute("deviselist", deviseMetierInterf.listDevise());
		model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUser());
		return "facturepage";
	}

	@RequestMapping(value = "/saveFacture")
	public String saveFacture(@Valid Facture fac, Model model, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("facturelist", factureMetierInterf.listFacture());
			model.addAttribute("clientlist", clientMetierInterf.listClient());
			model.addAttribute("deviselist", deviseMetierInterf.listDevise());
			model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUser());
			return "facturepage";
		}
		if (fac.getFactureId() != null) {
			factureMetierInterf.updateFacture(fac);
		} else {
			if (fac.getDateEcheance() == null || fac.getDateFacture() == null || fac.getFraisFacture() == null
					|| fac.getMontantFacture() == null || fac.getNbrPaiement() == null || fac.getNbrValidite() == null
					|| fac.getStatut() == "" || fac.getTypeFacture() == "") {
				model.addAttribute("error", "Veuiller remplir les champs");
			} else {
				factureMetierInterf.addFacture(fac);
			}
		}
		model.addAttribute("facture", new Facture());
		model.addAttribute("facturelist", factureMetierInterf.listFacture());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		model.addAttribute("deviselist", deviseMetierInterf.listDevise());
		model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUser());
		return "facturepage";
	}

	@RequestMapping(value = "/editFacture")
	public String editFacture(Integer factureId, Model model) {
		Facture f = factureMetierInterf.getFactureId(factureId);
		model.addAttribute("facture", f);
		model.addAttribute("facturelist", factureMetierInterf.listFacture());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		model.addAttribute("deviselist", deviseMetierInterf.listDevise());
		model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUser());
		return "facturepage";
	}

	@RequestMapping(value = "/deleteFacture")
	public String deleteFacture(Integer factureId, Model model) {
		factureMetierInterf.deleteFacture(factureId);
		model.addAttribute("facture", new Facture());
		model.addAttribute("facturelist", factureMetierInterf.listFacture());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		model.addAttribute("deviselist", deviseMetierInterf.listDevise());
		model.addAttribute("utilisateurlist", utilisateurMetierInterf.listUser());
		return "facturepage";
	}
}
