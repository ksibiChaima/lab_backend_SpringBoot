package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.PublicationRepository;
import com.example.demo.entities.Publication;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class PublicationServiceImpl implements IPublicationService {

    PublicationRepository publicationRepository;

    @Override
    public Publication savePublication(Publication p) {
        return publicationRepository.save(p);
    }

    @Override
    public Publication updatePublication(Publication p) {
        return publicationRepository.save(p);
    }

    @Override
    public void deletePublication(Long id) {
        publicationRepository.deleteById(id);
    }

    @Override
    public Publication findPublication(Long id) {
        return publicationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Publication> findAllPublications() {
        return publicationRepository.findAll();
    }

    @Override
    public List<Publication> chercherParTitre(String mc) {
        return publicationRepository.chercher("%" + mc + "%");
    }

   

    @Override
    public List<Publication> findByType(String type) {
        return publicationRepository.findByType(type);
    }
    
}
