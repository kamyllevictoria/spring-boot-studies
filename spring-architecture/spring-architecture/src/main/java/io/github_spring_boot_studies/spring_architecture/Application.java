package io.github_spring_boot_studies.spring_architecture;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ConfigurationWarningsApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(Application.class);
		springApplicationBuilder.run(args);
		ConfigurableApplicationContext applicationContext = springApplicationBuilder.context();


	}

}
