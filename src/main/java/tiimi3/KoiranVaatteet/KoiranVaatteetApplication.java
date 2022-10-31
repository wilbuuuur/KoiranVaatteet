package tiimi3.KoiranVaatteet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tiimi3.KoiranVaatteet.domain.KoiranVaatteetRepository;
import tiimi3.KoiranVaatteet.domain.Vaate;


@SpringBootApplication
public class KoiranVaatteetApplication {
	private static final Logger log = LoggerFactory.getLogger(KoiranVaatteetApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KoiranVaatteetApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(KoiranVaatteetRepository vaateRepository) {
		return (args) -> {
			log.info("save vaatteet");
			vaateRepository.save(new Vaate("vaate", "paita", 99.99, "joku"));
		};
	}
	

}
