package tiimi3.KoiranVaatteet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tiimi3.KoiranVaatteet.domain.User;
import tiimi3.KoiranVaatteet.domain.UserRepository;


@SpringBootApplication
public class KoiranVaatteetApplication {
	private static final Logger log = LoggerFactory.getLogger(KoiranVaatteetApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KoiranVaatteetApplication.class, args);
	}
}
