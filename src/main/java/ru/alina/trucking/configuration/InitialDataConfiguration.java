package ru.alina.trucking.configuration;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import ru.alina.trucking.entities.Application;
import ru.alina.trucking.entities.User;
import ru.alina.trucking.entities.jpa.ApplicationRepository;
import ru.alina.trucking.services.UserService;



@Configuration
public class InitialDataConfiguration {
	
	@Bean
	CommandLineRunner init(UserService userService, 
			ApplicationRepository applicationRepository) {
		return new CommandLineRunner() {
			
			@Override
			@Transactional
			public void run(String... args) throws Exception {


				User user = userService.createUser(new User("user", "user", true));
				User serg = userService.createUser(new User("serg", "user", true));
				User maria = userService.createUser(new User("maria", "user", false));
				User user156 = userService.createUser(new User("user156", "user", true));
				User pikachu = userService.createUser(new User("pikachy", "user", true));

				User admin = userService.createUser(new User("admin", "admin", true), Arrays.asList("ROLE_USER", "ROLE_ADMIN"));
				
				String addressF1 = "Россия, Пермь, ул. Екатерининская, 12а";
				String addressF2 = "Россия, Пермь, ул. Ленина, 144";

				String addressT1 = "Россия, Нытва, пр. Ленина, 144";
				String addressT2 = "Россия, Краснокамск, пр. Майский, 144";

				String comment1 = "Картонные коробки";
				String comment2 = "Диван";

				String phone1 = "89933984765";
				String phone2 = "89433984765";

				String user1 = "Александр";
				String user2 = "Денис";

				
				Application app1 = new Application(user, addressF1, addressT1, 12.2, 100.30, comment1, phone1, user1 );
				Application app2 = new Application(user156, addressF2, addressT2, 70.0, 124.0, comment2, phone2, user2);
				applicationRepository.saveAll(Arrays.asList(app1, app2));

			}
		};
	}
}
