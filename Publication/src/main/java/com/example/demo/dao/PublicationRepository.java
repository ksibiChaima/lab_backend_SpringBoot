package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
	List<Publication> findByType(String type);
    List<Publication> findByDate(Date date);
    List<Publication> findByTitreContaining(String mot);
   


    @Query("select p from Publication p where p.titre like :x")
    List<Publication> chercher(@Param("x") String motCle);

}
