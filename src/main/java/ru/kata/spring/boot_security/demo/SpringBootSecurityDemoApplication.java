package ru.kata.spring.boot_security.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.Arrays;
import java.util.Set;

@SpringBootApplication
public class SpringBootSecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunnerBean(UserService userService, RoleRepository roleRepository) {


		return (args) -> {
			Role roleUser = new Role("ROLE_USER");
			Role roleAdmin = new Role("ROLE_ADMIN");
			roleRepository.save(roleAdmin);
			roleRepository.save(roleUser);
			Arrays.asList(new User("admin", "admin", (byte) 22, "admin@bk.ru", "1111", Set.of(roleAdmin, roleUser)),
							new User("user", "user", (byte) 20, "user@bk.ru", "2222", Set.of(roleUser)))
					.forEach(userService::addUser);
		};
	}
}
