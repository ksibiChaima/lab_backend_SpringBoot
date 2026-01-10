package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Outil;
import com.example.demo.service.IOutilService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor

public class OutilRestController {
	IOutilService outilService;

    @GetMapping("/outils")
    public List<Outil> getAllOutils() {
        return outilService.findAllOutils();
    }

    @GetMapping("/outils/{id}")
    public Outil getOutilById(@PathVariable("id") Long id) {
        return outilService.findOutil(id);
    }

    @GetMapping("/outils/search/source")
    public List<Outil> searchBySource(@RequestParam("mc") String mc) {
        return outilService.chercherParSource(mc);
    }

   

    @PostMapping
    public Outil addOutil(@RequestBody Outil o) {
        return outilService.saveOutil(o);
    }

    @PutMapping("/outils/{id}")
    public Outil updateOutil(@PathVariable("id") Long id, @RequestBody Outil o) {
        o.setId(id);
        return outilService.updateOutil(o);
    }

    @DeleteMapping("/outils/{id}")
    public void deleteOutil(@PathVariable("id") Long id) {
        outilService.deleteOutil(id);
    }

}
