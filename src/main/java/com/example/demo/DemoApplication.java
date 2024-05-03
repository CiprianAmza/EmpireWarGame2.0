package com.example.demo;

import com.example.demo.building.Farm;
import com.example.demo.building.Warehouse;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@EntityScan(basePackageClasses = User.class)
@SpringBootApplication
@EnableScheduling
public class DemoApplication {
	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
		Farm farm = new Farm();
		Warehouse warehouse = new Warehouse();

	}
}
