package com.example.rentalcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableWebSecurity
public class RentalcarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalcarApplication.class, args);
	}

////Decommentare solo nel caso in cui la tabella "Utenti" del DB fosse vuota e si volessero creare nuovi utenti
//	@Bean
//	CommandLineRunner run(UtenteService utenteService){
//		return args -> {
//				utenteService.addUtente(new Utente(null, "Edoardo", "Lissoni", "SuperUser",
//					"EdoLisso99", "123456", new ArrayList<>()));
//				utenteService.addUtente(new Utente(null, "Mario", "Rossi", "Customer",
//					"ItsMeMario", "654321", new ArrayList<>()));
//				utenteService.addUtente(new Utente(null, "Mario2", "Rossi", "Customer",
//					"ItsMeMario2", "654321", new ArrayList<>()));
//				utenteService.addUtente(new Utente(null, "Mario3", "Rossi", "Customer",
//					"ItsMeMario3", "654321", new ArrayList<>()));
//				utenteService.addUtente(new Utente(null, "Mario4", "Rossi", "Customer",
//					"ItsMeMario4", "654321", new ArrayList<>()));
//				utenteService.addUtente(new Utente(null, "Mario5", "Rossi", "Customer",
//					"ItsMeMario5", "654321", new ArrayList<>()));
//				utenteService.addUtente(new Utente(null, "Mario6", "Rossi", "Customer",
//					"ItsMeMario6", "654321", new ArrayList<>()));
//		};
//	}

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

	@Bean
	public WebMvcConfigurer getCorsConfig(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:4200")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
						.allowedHeaders("Access-Control-Allow-Origin");
			}
		};
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
