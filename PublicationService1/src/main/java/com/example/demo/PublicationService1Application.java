package com.example.demo;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.dao.PublicationRepository;
import com.example.demo.entites.Publication;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class PublicationService1Application  implements CommandLineRunner{
	PublicationRepository publicationRepository ;
	RepositoryRestConfiguration configuration;

	public static void main(String[] args) {
		SpringApplication.run(PublicationService1Application.class, args);
	}
	 public void run(String... args) throws Exception {
		 configuration.exposeIdsFor(Publication.class);
		 //Création des publications
		 Publication pubs1 = 
				 Publication.builder()
				  .type("article")
				  .titre("an approach for   testing soa systems")
				  .dateApparition(new Date())
				  .lien("lien")
				  .sourcePdf("pdf")
				  .build();
		 Publication pubs2 = 
				 Publication.builder()
				  .type("code")
				  .titre("an approach for testing soa systems")
				  .dateApparition(new Date())
				  .lien("lien2")
				  .sourcePdf("pdf2")
				  .build();
		 Publication pubs3 = 
				 Publication.builder()
				  .type("code")
				  .titre("an approach for  testing soa systems")
				  .dateApparition(new Date())
				  .lien("lien3")
				  .sourcePdf("pdf3")
				  .build();
		
		 publicationRepository.save(pubs1);
		 publicationRepository.save(pubs2);
		 publicationRepository.save(pubs3);
		 }
}
