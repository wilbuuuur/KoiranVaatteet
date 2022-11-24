package tiimi3.KoiranVaatteet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tiimi3.KoiranVaatteet.domain.KoiranVaatteetRepository;
import tiimi3.KoiranVaatteet.domain.Vaate;
import tiimi3.KoiranVaatteet.domain.ValmistajaRepository;
import tiimi3.KoiranVaatteet.domain.Valmistaja;

@RestController
public class RestVaateController {

	@Autowired
	private KoiranVaatteetRepository repository;
	
	@Autowired
	private ValmistajaRepository vrepo;

	@GetMapping("/rest/vaatteet")
	public Iterable<Vaate> getVaatteet() {
		return repository.findAll();
	}

	@PostMapping("/rest/vaatteet")
	Vaate newVaate(@RequestBody Vaate newVaate) {
		return repository.save(newVaate);

	}

	@PutMapping("/rest/vaatteet/{id}")
	Vaate editVaate(@RequestBody Vaate muokattuVaate, @PathVariable Long id) {
		muokattuVaate.setId(id);
		return repository.save(muokattuVaate);
	}

	@DeleteMapping("/rest/vaatteet/{id}")
	void deleteVaate(@PathVariable Long id) {
		repository.deleteById(id);

	}

	@GetMapping("/restFindVaateByName/{name}")
	Iterable<Vaate> findVaateByType(@PathVariable("name") String name) {
		System.out.println("restFindVaateByName metodissa");
		return repository.findByName(name);
	}
	
	@GetMapping("/rest/valmistajat")
	public Iterable<Valmistaja> getValmistajat() {
		return vrepo.findAll();
	}

	@PostMapping("/rest/valmistajat")
	Valmistaja newValmistaja(@RequestBody Valmistaja newValmistaja) {
		return vrepo.save(newValmistaja);

	}

	@PutMapping("/rest/valmistajat/{id}")
	Valmistaja editValmistaja(@RequestBody Valmistaja muokattuValmistaja, @PathVariable Long id) {
		muokattuValmistaja.setValmistajaid(id);
		return vrepo.save(muokattuValmistaja);
	}

	@DeleteMapping("/rest/valmistajat/{id}")
	void deleteValmistaja(@PathVariable Long id) {
		vrepo.deleteById(id);

	}

	@GetMapping("/restFindValmistajaByName/{name}")
	Iterable<Valmistaja> findValmistajaByName(@PathVariable("name") String name) {
		return vrepo.findByName(name);
	}
	
	

}
