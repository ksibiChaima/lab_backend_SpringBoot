package com.example.demo;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.MemberRepository;
import com.example.demo.dao.OutilRepository;
import com.example.demo.entities.Membre;
import com.example.demo.entities.Outil;
import com.example.demo.service.IOutilService;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
@EnableDiscoveryClient
public class OutilApplication implements CommandLineRunner{
	OutilRepository outilRepository;
    IOutilService outilService;

	public static void main(String[] args) {
		SpringApplication.run(OutilApplication.class, args);
	}
	 public void run(String... args) throws Exception {
	      

	        // Créer et sauvegarder des outils
	        Outil o1 = new Outil(null, new Date(), "GitHub");
	        Outil o2 = new Outil(null, new Date(), "GitLab");
	        outilRepository.save(o1);
	        outilRepository.save(o2);

	        // Afficher tous les outils
	        System.out.println("\n=== Liste des outils ===");
	        outilRepository.findAll().forEach(o -> System.out.println(o.getSource()));

	        // Recherche personnalisée
	        System.out.println("\n=== Recherche d’outils contenant 'Git' ===");
	        outilRepository.chercher("%Git%").forEach(o -> System.out.println("Trouvé : " + o.getSource()));
	        
	        
	        System.out.println("===========test du OutilRestController ");
	        // 2️. Mettre à jour un outil
	        o1.setSource("GitHub Updated");
	        outilService.updateOutil(o1);
	        System.out.println("\n=== Outils après mise à jour ===");
	        outilService.findAllOutils().forEach(o -> System.out.println(o.getSource()));

	        // 3️. Rechercher par source
	        System.out.println("\n=== Recherche outils contenant 'Git' ===");
	        outilService.chercherParSource("Git").forEach(o -> System.out.println(o.getSource()));

	    

	      /*  // 5️. Supprimer un outil
	        outilService.deleteOutil(o2.getId());
	        System.out.println("\n=== Outils après suppression ===");
	        outilService.findAllOutils().forEach(o -> System.out.println(o.getSource()));
*/
	        // 6️.Simuler un "GET /outils/{id}" via service
	        System.out.println("\n=== Simuler GET /outils/{id} ===");
	        Outil oGet = outilService.findOutil(o1.getId());
	        System.out.println("Outil trouvé : " + oGet.getSource());

	        // 7️. Simuler un "POST /outils" avec un nouvel outil
	        Outil o3 = outilService.saveOutil(new Outil(null, new Date(), "Bitbucket"));
	        System.out.println("\n=== Après POST /outils ===");
	        outilService.findAllOutils().forEach(o -> System.out.println(o.getSource()));
	    }
	    }

