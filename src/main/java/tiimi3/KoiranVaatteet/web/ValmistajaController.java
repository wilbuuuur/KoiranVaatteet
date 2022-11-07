package tiimi3.KoiranVaatteet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tiimi3.KoiranVaatteet.domain.ValmistajaRepository;

@Controller
public class ValmistajaController {
	@Autowired
	private ValmistajaRepository vrepository;
	

}
