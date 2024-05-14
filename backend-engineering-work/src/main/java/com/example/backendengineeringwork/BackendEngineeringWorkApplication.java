package com.example.backendengineeringwork;

import com.example.backendengineeringwork.commands.user.RegisterUserCommand;
import com.example.backendengineeringwork.security.auth.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

import static com.example.backendengineeringwork.models.Role.ADMIN;

@SpringBootApplication
public class BackendEngineeringWorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendEngineeringWorkApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var admin = RegisterUserCommand.builder()
					.firstname("Admin")
					.lastname("Admin")
					.bornDate(LocalDate.of(2001,10,9))
					.city("Wroclaw")
					.postCode("00-000")
					.address("Zwierzynska 10")
					.mobilePhone("123456321")
					.email("admin@mail.com")
					.password("password")
					.role(ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());
		};
	}

}
