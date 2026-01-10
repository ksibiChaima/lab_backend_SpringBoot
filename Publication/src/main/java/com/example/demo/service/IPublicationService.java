package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Publication;

public interface IPublicationService {
	Publication savePublication(Publication p);
    Publication updatePublication(Publication p);
    void deletePublication(Long id);
    Publication findPublication(Long id);
    List<Publication> findAllPublications();
    List<Publication> chercherParTitre(String mc);
  
    List<Publication> findByType(String type);
    

}
