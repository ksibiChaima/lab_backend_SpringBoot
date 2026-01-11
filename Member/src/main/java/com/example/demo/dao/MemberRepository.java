package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;

public interface MemberRepository extends JpaRepository<Membre, Long> {
	
	@Query("select m from Membre m where m.nom like %:x%")
	List<Membre> chercher(@Param("x") String mc);

	Membre findByCin(String cin);
	List<Membre>findByNomStartingWith(String caractere);
	Membre findByEmail(String email);

	List<Membre> findByNom(String nom);

}
