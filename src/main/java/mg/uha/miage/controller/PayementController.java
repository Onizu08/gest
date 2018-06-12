package mg.uha.miage.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import mg.uha.miage.entities.Payer;
import mg.uha.miage.metier.interf.ClientMetierInterf;
import mg.uha.miage.metier.interf.FactureMetierInterf;
import mg.uha.miage.metier.interf.PayementMetierInterf;

@Controller
@RequestMapping(value = "/Payement")
@Transactional
public class PayementController {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private PayementMetierInterf payementMetierInterf;

	@Autowired
	private FactureMetierInterf factureMetierInterf;

	@Autowired
	private ClientMetierInterf clientMetierInterf;

	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("payement", new Payer());
		model.addAttribute("payementlist", payementMetierInterf.listPayement());
		model.addAttribute("facturelist", factureMetierInterf.listFacture());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		return "payementpage";
	}

	@RequestMapping(value = "/savePayement")
	public String savePayement(@Valid Payer payer, Model model, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("payementlist", payementMetierInterf.listPayement());
			model.addAttribute("facturelist", factureMetierInterf.listFacture());
			model.addAttribute("clientlist", clientMetierInterf.listClient());

			return "payementpage";
		}
		if (payer.getPaymentId() != null) {
			payementMetierInterf.updatePayement(payer);
		} else {
			if (payer.getDatePrevu() == null || payer.getMontantPayement() == null || payer.getMontantPrevu() == null) {
				model.addAttribute("error", "Veuiller remplir les formulaires");
			} else {
				payementMetierInterf.addPayement(payer);
			}
		}

		model.addAttribute("payement", new Payer());
		model.addAttribute("payementlist", payementMetierInterf.listPayement());
		model.addAttribute("facturelist", factureMetierInterf.listFacture());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		return "payementpage";
	}

	@RequestMapping(value = "/editPayement")
	public String editPayement(Integer paymentId, Model model) {
		Payer p = payementMetierInterf.getPayement(paymentId);
		model.addAttribute("payement", p);
		model.addAttribute("payementlist", payementMetierInterf.listPayement());
		model.addAttribute("facturelist", factureMetierInterf.listFacture());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		return "payementpage";
	}

	@RequestMapping(value = "/deletePayement")
	public String deletePayement(Integer payementId, Model model) {
		payementMetierInterf.deletePayement(payementId);
		model.addAttribute("payement", new Payer());
		model.addAttribute("payementlist", payementMetierInterf.listPayement());
		model.addAttribute("facturelist", factureMetierInterf.listFacture());
		model.addAttribute("clientlist", clientMetierInterf.listClient());
		return "payementpage";
	}

}
