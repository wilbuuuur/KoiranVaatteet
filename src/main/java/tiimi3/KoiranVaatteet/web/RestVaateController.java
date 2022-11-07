package tiimi3.KoiranVaatteet.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tiimi3.KoiranVaatteet.domain.KoiranVaatteetRepository;
import tiimi3.KoiranVaatteet.domain.Vaate;

@Controller
public class RestVaateController {
	
	@Autowired
	private KoiranVaatteetRepository repository;
	
	// REST etsii kaikki vaatteet
    @RequestMapping(value="/api/vaatteet", method = RequestMethod.GET)
    public @ResponseBody List<Vaate> listVaateRest() {	
        return (List<Vaate>) repository.findAll();
    }    

	// Rest etsii vaatteen id:llä
    @RequestMapping(value="/api/vaate/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Vaate> findVaateRest(@PathVariable("id") Long vaateId) {	
    	return repository.findById(vaateId);
    }   

}
