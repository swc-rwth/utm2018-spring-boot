package de.rwth.swc.bibliography;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import core.Bibliography;
import tools.AdminTool;

@SpringBootApplication
@Configuration
public class BibliographySpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliographySpringApplication.class, args);
	}
	
	@Bean
	public Bibliography createBibliography(){
		return new Bibliography();
	}
	
	@Bean 
	public AdminTool createAdminTool() {
		AdminTool admin = new AdminTool();
		admin.setBibliography(createBibliography());
		return admin;
		
	}
}
