package com.mithilesh.test;

import com.mithilesh.test.entity.ThemeParkRide;
import com.mithilesh.test.repository.ThemeParkRideRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringWebTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebTestApplication.class, args);
	}

	@Bean
	public CommandLineRunner sampleDataloader(ThemeParkRideRepo themeParkRideRepo) {
		return (args) -> {
			themeParkRideRepo.save(new ThemeParkRide("TeaCup", "Spinning ride in a giant tea-cup.", 2, 4));
			themeParkRideRepo.save(new ThemeParkRide("Leviathan", "Steel roller coaster at Canada's Wonderland in Vaughan, Ontario, Canada.", 5, 2));
			themeParkRideRepo.save(new ThemeParkRide("Behemoth", "Behemoth is a steel roller coaster located at Canada's Wonderland in Vaughan, Ontario.", 5, 2));
		};
	}

}
