package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Outil;

public interface IOutilService {

	 Outil saveOutil(Outil o);
	    Outil updateOutil(Outil o);
	    void deleteOutil(Long id);
	    Outil findOutil(Long id);
	    List<Outil> findAllOutils();
	    List<Outil> chercherParSource(String mc);
	   
	    
	    
}
