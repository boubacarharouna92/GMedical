package com.stageUTI.GestionMedicale.Beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "mesure_parametre")
public class mesure_parametre {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	private Integer valeur; 
	private Integer  valide=1;
	
	@ManyToOne
	private Consultation consultation; 
	
	@ManyToOne
	private Parametre parametre;

	
	public mesure_parametre(Integer valeur, Consultation consultation, Parametre parametre) {
		
		this.valeur = valeur;
		this.consultation = consultation;
		this.parametre = parametre;
	}

	public mesure_parametre(Integer valeur) {
		
		this.valeur = valeur;
	}

	public mesure_parametre() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getValeur() {
		return valeur;
	}

	public void setValeur(Integer valeur) {
		this.valeur = valeur;
	}

	public Integer getValide() {
		return valide;
	}

	public void setValide(Integer valide) {
		this.valide = valide;
	}

	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

	public Parametre getParametre() {
		return parametre;
	}

	public void setParametre(Parametre parametre) {
		this.parametre = parametre;
	}
	
	
	
	

}
