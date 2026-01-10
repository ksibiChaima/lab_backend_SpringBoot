package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.OutilRepository;
import com.example.demo.entities.Outil;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class OutilServiceImpl implements IOutilService {
	OutilRepository outilRepository;
	

    @Override
    public Outil saveOutil(Outil o) {
        return outilRepository.save(o);
    }

    @Override
    public Outil updateOutil(Outil o) {
        return outilRepository.save(o);
    }

    @Override
    public void deleteOutil(Long id) {
        outilRepository.deleteById(id);
    }

    @Override
    public Outil findOutil(Long id) {
        return outilRepository.findById(id).orElse(null);
    }

    @Override
    public List<Outil> findAllOutils() {
        return outilRepository.findAll();
    }

    @Override
    public List<Outil> chercherParSource(String mc) {
        return outilRepository.chercher("%" + mc + "%");
    }

   
}
