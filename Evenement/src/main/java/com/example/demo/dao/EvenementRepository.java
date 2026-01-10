package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {
	
	List<Evenement> findByLieu(String lieu);
    List<Evenement> findByDate(Date date);

    @Query("select e from Evenement e where e.titre like :x")
    List<Evenement> chercher(@Param("x") String motCle);
  
   
    

}
