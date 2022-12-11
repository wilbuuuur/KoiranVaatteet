package tiimi3.KoiranVaatteet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tiimi3.KoiranVaatteet.domain.KoiranVaatteetRepository;
import tiimi3.KoiranVaatteet.domain.Valmistaja;
import tiimi3.KoiranVaatteet.domain.ValmistajaRepository;

@Controller
public class ValmistajaController {
	@Autowired
	private ValmistajaRepository vrepository;
	
	@Autowired
	private KoiranVaatteetRepository kvrepository;
	
	@RequestMapping(value = "/valmistajat", method = RequestMethod.GET)
	public String valmistajat(Model model) {
		model.addAttribute("valmistajat", vrepository.findAll());
		return "valmistajat";
	}
	
	@RequestMapping(value = "/valmistajat/poista/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteValmistaja(@PathVariable("id") Long valmistajaid, Model model) {
		vrepository.deleteById(valmistajaid);
		return "redirect:../../valmistajat";
	}
	
	@RequestMapping(value = "/valmistajat/lisaa", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addValmistaja(Model model) {
		model.addAttribute("valmistaja", new Valmistaja());
		return "lisaavalmistaja";
	}
	
	@RequestMapping(value = "/valmistajat/tallenna", method = RequestMethod.POST)
	public String saveValmistaja(Valmistaja valmistaja){
	    vrepository.save(valmistaja);
	    return "redirect:../valmistajat";
	}
	
	@RequestMapping(value = "/valmistajanvaatteet/{id}", method = RequestMethod.GET)
	public String vaatteetByvalmistaja(@PathVariable("id") Long Id, Model model) {
		Valmistaja valmistaja = vrepository.findByValmistajaid(Id);
		model.addAttribute("vaatteet", kvrepository.findByValmistaja(valmistaja));
		return "vaatteet";
	}
}
