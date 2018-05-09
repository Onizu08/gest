package mg.uha.miage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import mg.uha.miage.entities.Pays;
import mg.uha.miage.metier.interf.PaysMetierInterf;

@Controller
@RequestMapping(value = "/Pays")
public class PaysController {

	@Autowired
	private PaysMetierInterf paysMetierInterf;

	@RequestMapping(value = "/index")
	public String index(Model model, HttpServletRequest httpServletRequest) {

		model.addAttribute("test", new Pays());
		model.addAttribute("valeur", "modifier");
		model.addAttribute("payslist", paysMetierInterf.listPays());
		return "payspage";
	}

	@RequestMapping(value = "/savePays")
	public String savePays(@Valid Pays pays, Model model, BindingResult bindingResult,
			HttpServletRequest httpServletRequest) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("payslist", paysMetierInterf.listPays());
			return "payspage";
		}

		if (pays.getPaysId() == "") {
			paysMetierInterf.updatePays(pays);
		} else {
			Pays p;

			String[] partsId = pays.getPaysId().split(",");
			String[] partsLib = pays.getPaysLib().split(",");
			for (int i = 0; i < partsId.length; i++) {
				p = new Pays();
				p.setPaysId(partsId[i]);
				p.setPaysLib(partsLib[i]);
				paysMetierInterf.addPays(p);
			}

		}
		// if (pays.getPaysId() == "" || pays.getPaysLib() == "") {
		// model.addAttribute("error", "veuiller remplir les champs");
		// } else {
		//
		//
		//
		// // paysMetierInterf.addPays(pays);
		//
		// }
		// }
		model.addAttribute("Succes", "Pays ajout� avec succ�s");
		model.addAttribute("test", new Pays());
		model.addAttribute("payslist", paysMetierInterf.listPays());
		return "payspage";
	}

	@RequestMapping(value = "/editPays")
	public String editPays(String paysId, Model model, HttpServletRequest httpServletRequest) {
		Pays pays1 = paysMetierInterf.getPays(paysId);

		model.addAttribute("test", pays1);
		model.addAttribute("payslist", paysMetierInterf.listPays());
		return "payspage";
	}

	@RequestMapping(value = "/deletePays")
	public String deletePays(String paysId, Model model, HttpServletRequest httpServletRequest) {
		paysMetierInterf.deletePays(paysId);
		model.addAttribute("Succes", "Suppression effectu�e");
		model.addAttribute("test", new Pays());
		model.addAttribute("payslist", paysMetierInterf.listPays());
		return "payspage";
	}
}
