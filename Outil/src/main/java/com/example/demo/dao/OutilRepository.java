package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Outil;

public interface OutilRepository extends JpaRepository<Outil, Long> {
	
	 List<Outil> findByDate(Date date);
	    List<Outil> findBySourceContaining(String mot);

	    @Query("select o from Outil o where o.source like :x")
	    List<Outil> chercher(@Param("x") String motCle);
	 

}
