package com.example.demo.beans;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data

public class PublicationBean {
	
	
    private Long id;
    private String type;
    private String titre;
    private String lien;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String sourcePdf;

}
