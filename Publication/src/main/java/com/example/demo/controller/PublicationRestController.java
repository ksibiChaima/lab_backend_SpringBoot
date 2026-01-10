package com.example.demo.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Publication;
import com.example.demo.service.IPublicationService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor

public class PublicationRestController {
	IPublicationService publicationService;
	// Get all publications
    @RequestMapping(value = "/publications", method = RequestMethod.GET)
    public List<Publication> findAllPublications() {
        return publicationService.findAllPublications();
    }

    // Get publication by ID
    @GetMapping(value = "/publications/{id}")
    public Publication findPublicationById(@PathVariable("id") Long id) {
        return publicationService.findPublication(id);
    }

    // Search by title
    @GetMapping(value = "/publications/search/title")
    public List<Publication> findPublicationsByTitle(@RequestParam("mot") String mot) {
        return publicationService.chercherParTitre(mot);
    }

    // Search by type
    @GetMapping(value = "/publications/search/type")
    public List<Publication> findPublicationsByType(@RequestParam("type") String type) {
        return publicationService.findByType(type);
    }

  

    // Add a new publication
    @PostMapping(value = "/publications")
    public Publication addPublication(@RequestBody Publication p) {
        return publicationService.savePublication(p);
    }

    // Update an existing publication
    @PutMapping(value = "/publications/{id}")
    public Publication updatePublication(@PathVariable("id") Long id, @RequestBody Publication p) {
        p.setId(id);
        return publicationService.updatePublication(p);
    }

    // Delete a publication
    @DeleteMapping(value = "/publications/{id}")
    public void deletePublication(@PathVariable("id") Long id) {
        publicationService.deletePublication(id);
    }
}
