package com.stageUTI.GestionMedicale.Beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Posologie")
public class Posologie {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	private String libelle;
	private Integer valide=1; 
	
	@ManyToOne
	private Medicament medicament; 
	
	@ManyToOne
	private Ordonnance ordonnance;

	public Posologie(String libelle) {
		
		this.libelle = libelle;
	}

	public Posologie() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Integer getValide() {
		return valide;
	}

	public void setValide(Integer valide) {
		this.valide = valide;
	}

	public Medicament getMedicament() {
		return medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

	public Ordonnance getOrdonnance() {
		return ordonnance;
	}

	public void setOrdonnance(Ordonnance ordonnance) {
		this.ordonnance = ordonnance;
	}
	
	
	
	
	
}
