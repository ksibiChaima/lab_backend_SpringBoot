package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;


import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@Getter @Setter

@NoArgsConstructor 
@AllArgsConstructor
//@RequiredArgsConstructor
public class Outil implements Serializable {
	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Temporal(TemporalType.DATE)
	    private Date date;
	    private String source;

	 
	

}
