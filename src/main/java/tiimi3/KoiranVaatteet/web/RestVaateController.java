package tiimi3.KoiranVaatteet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tiimi3.KoiranVaatteet.domain.KoiranVaatteetRepository;
import tiimi3.KoiranVaatteet.domain.Vaate;

@Controller
public class RestVaateController {

	@Autowired
	private KoiranVaatteetRepository repository;

	@GetMapping("/api/vaatteet")
	public Iterable<Vaate> getVaatteet() {
		return repository.findAll();
	}

	@PostMapping("/api/vaatteet")
	Vaate newVaate(@RequestBody Vaate newVaate) {
		return repository.save(newVaate);

	}

	@PutMapping("/api/vaatteet/{id}")
	Vaate editVaate(@RequestBody Vaate muokattuVaate, @PathVariable Long id) {
		muokattuVaate.setId(id);
		return repository.save(muokattuVaate);
	}

	@DeleteMapping("api/cars/{id}")
	void deleteVaate(@PathVariable Long id) {
		repository.deleteById(id);

	}

	@GetMapping("/restFindVaateByName/{name}")
	Iterable<Vaate> findVaateByType(@PathVariable("name") String name) {
		System.out.println("restFindVaateByName metodissa");
		return repository.findByName(name);
	}
	// REST etsii kaikki vaatteet
	// @RequestMapping(value="/api/vaatteet", method = RequestMethod.GET)
	// public @ResponseBody List<Vaate> listVaateRest() {
	// return (List<Vaate>) repository.findAll();
	// }

	// Rest etsii vaatteen id:llä
	// @RequestMapping(value="/api/vaate/{id}", method = RequestMethod.GET)
	// public @ResponseBody Optional<Vaate> findVaateRest(@PathVariable("id") Long
	// vaateId) {
	// return repository.findById(vaateId);
	// }

}
