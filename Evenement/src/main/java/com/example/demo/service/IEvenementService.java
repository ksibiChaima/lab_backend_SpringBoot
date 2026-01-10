package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.entities.Evenement;

public interface IEvenementService {
	Evenement saveEvenement(Evenement e);
    Evenement updateEvenement(Evenement e);
    void deleteEvenement(Long id);
    Evenement findEvenement(Long id);
    List<Evenement> findAllEvenements();
    List<Evenement> chercherParTitre(String mc);
    List<Evenement> chercherParDate(Date date);
    List<Evenement> chercherParLieu(String lieu);
   

}
