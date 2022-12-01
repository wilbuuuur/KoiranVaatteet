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

	@Bean
	public CommandLineRunner demo(UserRepository urepository) {
		return (args) -> {
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C",
					"ADMIN");
			urepository.save(user1);
			urepository.save(user2);
		};
	}
}
