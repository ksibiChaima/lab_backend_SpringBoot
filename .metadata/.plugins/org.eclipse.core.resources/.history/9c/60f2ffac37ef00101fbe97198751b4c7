package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @DiscriminatorValue("ens")
@NoArgsConstructor
@Getter
@Setter

public class EnseignantChercheur extends Membre {
	private static final long serialVersionUID = 1L;
	@Temporal(TemporalType.DATE)
	private String grade;
	private String etablissement;
	
	@Builder
	public EnseignantChercheur(String cin, String nom, String prenom, Date dateNaissance,
            String cv, String email, String password,
            String grade, String etablissement) {
		super(cin, nom, prenom, dateNaissance, cv, email, password);
		this.grade = grade;
		this.etablissement = etablissement;
}

}
