package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Evenement;
import com.example.demo.service.IEvenementService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor

public class EvenementRestController {

    private final IEvenementService evenementService;

    @GetMapping("/evenements")
    public List<Evenement> findEvenements() {
        return evenementService.findAllEvenements();
    }

    @GetMapping("/evenements/{id}")
    public Evenement findEvenement(@PathVariable Long id) {
        return evenementService.findEvenement(id);
    }

    @PostMapping("/evenements")
    public Evenement addEvenement(@RequestBody Evenement ev) {
        // ev.organisateurId doit être fourni dans le JSON
        return evenementService.saveEvenement(ev);
    }

    @PutMapping("/evenements/{id}")
    public Evenement updateEvenement(@PathVariable Long id, @RequestBody Evenement ev) {
        ev.setId(id);
        return evenementService.updateEvenement(ev);
    }

    @DeleteMapping("/evenements/{id}")
    public void deleteEvenement(@PathVariable Long id) {
        evenementService.deleteEvenement(id);
    }
}
