package com.stageUTI.GestionMedicale.Beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Symptome")
public class Symptome {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	private String libelle;
	private Integer  valide=1;
	
	
	@ManyToMany(mappedBy = "symptomes")
	private Set<Consultation> consultation;

	public Symptome(String libelle) {
		
		this.libelle = libelle;
	}

	public Symptome() {
		
		// TODO Auto-generated constructor stub
	}

	

	
	public Symptome(String libelle, Set<Consultation> consultation) {
		super();
		this.libelle = libelle;
		this.consultation = consultation;
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

	public Set<Consultation> getConsultation() {
		return consultation;
	}

	public void setConsultation(Set<Consultation> consultation) {
		this.consultation = consultation;
	}
	
	
}
