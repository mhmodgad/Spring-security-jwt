package com.security.security;

import com.security.security.domain.User;
import com.security.security.domain.Role;
import com.security.security.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService, PasswordEncoder passwordEncoder){
		return args ->{
			userService.saveUser(new User(null, "Ali", "ali","gad@gad.com", passwordEncoder.encode("1234"), Role.USER));
			userService.saveUser(new User(null, "Ahmed","Ahmed","gad1@gad.com", passwordEncoder.encode("1234"), Role.ADMIN));
			userService.saveUser(new User(null, "Mega","Ahmed","gad2@gad.com", passwordEncoder.encode("1234"),Role.USER));
			userService.saveUser(new User(null, "Mohamed","Ahmed","gad3@gad.com", passwordEncoder.encode("1234"), Role.ADMIN));
		};
	}
}
