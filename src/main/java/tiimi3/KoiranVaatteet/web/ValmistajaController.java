package tiimi3.KoiranVaatteet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tiimi3.KoiranVaatteet.domain.ValmistajaRepository;

@Controller
public class ValmistajaController {
	@Autowired
	private ValmistajaRepository vrepository;
	
	@RequestMapping(value = "valmistajat", method = RequestMethod.GET)
	public String valmistajat(Model model) {
		model.addAttribute("valmistjat", vrepository.findAll());
		return "valmistajat";
	}
	

}
