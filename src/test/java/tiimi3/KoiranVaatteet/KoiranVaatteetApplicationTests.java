package tiimi3.KoiranVaatteet;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import tiimi3.KoiranVaatteet.web.KoiranVaatteetController;
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class KoiranVaatteetApplicationTests {
	@Autowired 
	private KoiranVaatteetController koiranVaatteetController;
	@Test
	public void contextLoads() {
		assertThat(koiranVaatteetController).isNotNull();
	}

}
