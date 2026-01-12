package com.example.demo;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.demo.dao.EvenementRepository;
import com.example.demo.dao.MemberRepository;
import com.example.demo.entities.Evenement;
import com.example.demo.entities.Membre;
import com.example.demo.service.IEvenementService;

import lombok.AllArgsConstructor;
@EnableDiscoveryClient
@SpringBootApplication
@AllArgsConstructor

public class EvenementApplication implements CommandLineRunner {
	  EvenementRepository evenementRepository ;
	  IEvenementService evenementService; 

	public static void main(String[] args) {
		SpringApplication.run(EvenementApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	    // On récupère un membre existant comme organisateur

	    // 1️. Créer des événements
	    Evenement ev1 = new Evenement(null, "Conférence IOT", new Date(), "ENIS");
	    Evenement ev2 = new Evenement(null, "Workshop BLOCKCHAIN", new Date(), "Sfax");

	    evenementRepository.save(ev1);
	    evenementRepository.save(ev2);

	    // 2️. Afficher tous les événements
	    System.out.println("\n=== Liste des événements ===");
	    evenementRepository.findAll().forEach(e ->
	            System.out.println(e.getTitre() + " à " + e.getLieu())
	    );

	    // 3️. Chercher par mot clé
	    System.out.println("\n=== Recherche d'événements contenant 'IA' ===");
	    evenementRepository.chercher("%IA%").forEach(e ->
	            System.out.println("Trouvé : " + e.getTitre())
	    );

	    // Création des événements via le service
	    Evenement ev3 = new Evenement(null, "Conférence IA", new Date(), "Tunis");
	    Evenement ev4 = new Evenement(null, "Workshop Sécurité", new Date(), "Sfax");

	    evenementService.saveEvenement(ev3);
	    evenementService.saveEvenement(ev4);

	    // Afficher tous les événements via le service
	    System.out.println("\n=== Liste des événements ===");
	    evenementService.findAllEvenements().forEach(e ->
	            System.out.println(e.getTitre() + " à " + e.getLieu())
	    );

	    // Chercher par mot clé via le service
	    System.out.println("\n=== Recherche d'événements contenant 'IA' ===");
	    evenementService.chercherParTitre("IA").forEach(e ->
	            System.out.println("Trouvé : " + e.getTitre())
	    );

	    // Chercher par lieu
	    System.out.println("\n=== Recherche d'événements à Tunis ===");
	    evenementService.chercherParLieu("Tunis").forEach(e ->
	            System.out.println("Trouvé : " + e.getTitre())
	    );

	    // Modifier un événement
	    ev1.setLieu("ISIMS");
	    evenementService.updateEvenement(ev1);
	    System.out.println("\n=== Après modification ===");
	    Evenement updatedEv = evenementService.findEvenement(ev1.getId());
	    System.out.println("Evénement modifié : " + (updatedEv != null ? updatedEv.getLieu() : "[non trouvé]"));

	  

	    // Tester la couche métier
	    Evenement ev = evenementService.findEvenement(ev1.getId());
	    if (ev != null) {
	        ev.setLieu("Bizerte");
	        evenementService.updateEvenement(ev);
	    }

	    // Suppression
	  //  evenementService.deleteEvenement(ev2.getId());
	}

}
