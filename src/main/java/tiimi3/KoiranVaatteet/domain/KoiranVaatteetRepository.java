package tiimi3.KoiranVaatteet.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface KoiranVaatteetRepository extends CrudRepository<Vaate, Long> {
	List<Vaate> findByName(String name);

}
