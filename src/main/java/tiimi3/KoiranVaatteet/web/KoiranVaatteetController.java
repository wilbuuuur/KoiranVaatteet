package tiimi3.KoiranVaatteet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tiimi3.KoiranVaatteet.domain.KoiranVaatteetRepository;

@Controller
public class KoiranVaatteetController {
@Autowired
private KoiranVaatteetRepository vaateRepository;

@RequestMapping(value = "/vaatteet", method = RequestMethod.GET)
	public String list (Model model) {
	model.addAttribute("vaatteet", vaateRepository.findAll());
	return "vaatteet";
}

@RequestMapping(value = "/poista/{id}", method = RequestMethod.GET)
public String deleteVaate (@PathVariable("id") Long vaateId, Model model) {
	vaateRepository.deleteById(vaateId);
	return "redirect:../vaatteet";
}

}
