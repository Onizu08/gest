//package mg.uha.miage.controller;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import mg.uha.miage.entities.Societe;
//import mg.uha.miage.metier.interf.SocieteMetierInterf;
//
//@Controller
//@RequestMapping(value = "/Societe")
//public class SocieteController {
//
//	@Autowired
//	private SocieteMetierInterf societeMetierInterf;
//
//	@RequestMapping(value = "/index")
//	public String index(Model model) {
//		model.addAttribute("societe", new Societe());
//		model.addAttribute("societelist", societeMetierInterf.listSociete());
//		return "socitepage";
//	}
//
//	@RequestMapping(value = "/saveSociete")
//	public String saveSociete(@Valid Societe soce, Model model, BindingResult bindingResult) {
//		if (bindingResult.hasErrors()) {
//			model.addAttribute("societelist", societeMetierInterf.listSociete());
//			return "socitepage";
//		}if(soce.getSocieteId()!=null) {
//			societeMetierInterf.updateSociete(soce);
//		}else {
//			if(soce.getNomSociete()==""||soce.getAdresseSoceite()==||soce.getTelephoneSociete()==""||soce.)
//		}
//		model.addAttribute("societe", new Societe());
//		model.addAttribute("societelist", societeMetierInterf.listSociete());
//		return "socitepage";
//	}
//
//}
