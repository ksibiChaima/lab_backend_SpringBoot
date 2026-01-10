package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.EvenementRepository;
import com.example.demo.entities.Evenement;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor

public class EvenementServiceImpl implements IEvenementService {
	private EvenementRepository evenementRepository;

    @Override
    public Evenement saveEvenement(Evenement e) {
        return evenementRepository.save(e);
    }

    @Override
    public Evenement updateEvenement(Evenement e) {
        return evenementRepository.save(e);
    }

    @Override
    public void deleteEvenement(Long id) {
        evenementRepository.deleteById(id);
    }

    @Override
    public Evenement findEvenement(Long id) {
        return evenementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Evenement> findAllEvenements() {
        return evenementRepository.findAll();
    }

    @Override
    public List<Evenement> chercherParTitre(String mc) {
        return evenementRepository.chercher("%" + mc + "%");
    }

    @Override
    public List<Evenement> chercherParDate(Date date) {
        return evenementRepository.findByDate(date);
    }

    @Override
    public List<Evenement> chercherParLieu(String lieu) {
        return evenementRepository.findByLieu(lieu);
    }

   

}
