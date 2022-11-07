package tiimi3.KoiranVaatteet;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import tiimi3.KoiranVaatteet.domain.Vaate;
import tiimi3.KoiranVaatteet.domain.ValmistajaRepository;
import tiimi3.KoiranVaatteet.domain.KoiranVaatteetRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class VaateRepositoryTest {
	@Autowired
	private KoiranVaatteetRepository vrepository;
	@Autowired 
	private ValmistajaRepository arepository;
	
	@Test 
	public void findByNameShouldReturnVaate() {
		List<Vaate> vaatteet= vrepository.findByName("vaate");
		
		assertThat(vaatteet).hasSize(1);
		assertThat(vaatteet.get(0).getType()).isEqualTo("paita");
	}
	@Test
	public void luoUusiVaate() {
		Vaate vaate= new Vaate("Coolbeans","paita",99.85,arepository.findByName("Hurtta").get(0));
		vrepository.save(vaate);
		assertThat(vaate.getId()).isNotNull();
	}
}
