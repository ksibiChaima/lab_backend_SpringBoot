package com.example.demo;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.demo.dao.MemberRepository;
import com.example.demo.dao.PublicationRepository;
import com.example.demo.entities.Membre;
import com.example.demo.entities.Publication;

import lombok.AllArgsConstructor;
@SpringBootApplication
@AllArgsConstructor
@EnableDiscoveryClient

public class PublicationApplication implements CommandLineRunner {
	PublicationRepository publicationRepository;
    MemberRepository membreRepository;

	public static void main(String[] args) {
		SpringApplication.run(PublicationApplication.class, args);
	}
	public void run(String... args) throws Exception {
        Membre auteur = membreRepository.findAll().stream().findFirst().orElse(null);

        // Créer des publications
        Publication p1 = new Publication(null, "Article", "Deep Learning Advances", "www.dl.com",
                new Date(), "pdf1.pdf");
        Publication p2 = new Publication(null, "Chapitre", "Security in IoV", "www.sec.com",
                new Date(), "pdf2.pdf");
        publicationRepository.save(p1);
        publicationRepository.save(p2);

        // Afficher toutes les publications
        System.out.println("\n=== Liste des publications ===");
        publicationRepository.findAll().forEach(p -> System.out.println(p.getTitre()));

        // Recherche personnalisée
        System.out.println("\n=== Recherche de publications contenant 'IoV' ===");
        publicationRepository.chercher("%IoV%").forEach(p -> System.out.println("Trouvé : " + p.getTitre()));
    }

}
