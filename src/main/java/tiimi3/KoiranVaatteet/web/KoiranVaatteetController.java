package tiimi3.KoiranVaatteet.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tiimi3.KoiranVaatteet.domain.KoiranVaatteetRepository;
import tiimi3.KoiranVaatteet.domain.Vaate;
import tiimi3.KoiranVaatteet.domain.ValmistajaRepository;

@Controller
public class KoiranVaatteetController {
@Autowired
private KoiranVaatteetRepository vaateRepository;

@Autowired
private ValmistajaRepository valmistajaRepository;

@RequestMapping(value = ("/"), method = RequestMethod.GET)
public String etusivu() {
	return "etusivu";
}

@RequestMapping(value = "/vaatteet", method = RequestMethod.GET)
	public String list (Model model) {
	model.addAttribute("vaatteet", vaateRepository.findAll());
	return "vaatteet";
}

@RequestMapping(value = "/muokkaa/{id}", method = RequestMethod.GET)
@PreAuthorize("hasAuthority('ADMIN')")
public String editVaate(@PathVariable("id") Long vaateId, Model model) {
	model.addAttribute("vaate", vaateRepository.findById(vaateId));
	model.addAttribute("valmistajat", valmistajaRepository.findAll());
	return "muokkaa";
}

@RequestMapping(value = "/poista/{id}", method = RequestMethod.GET)
@PreAuthorize("hasAuthority('ADMIN')")
public String deleteVaate (@PathVariable("id") Long vaateId, Model model) {
	vaateRepository.deleteById(vaateId);
	return "redirect:../vaatteet";
}

@RequestMapping(value = "/lisaa")
@PreAuthorize("hasAuthority('ADMIN')")
public String addVaate (Model model){
	model.addAttribute("vaate", new Vaate());
	model.addAttribute("valmistajat", valmistajaRepository.findAll());
    return "lisaa";
}

@RequestMapping(value = "/tallenna", method = RequestMethod.POST)
public String save(@Valid Vaate vaate, BindingResult bindingResult){
	
	if (bindingResult.hasErrors()) {
		return "redirect:lisaa";
	}
	vaateRepository.save(vaate);
    return "redirect:vaatteet";
}

}
