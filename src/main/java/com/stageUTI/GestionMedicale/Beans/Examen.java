package com.stageUTI.GestionMedicale.Beans;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Examen")
public class Examen {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	private String libelle;
	private Integer  valide=1;
	
	@ManyToMany(mappedBy = "examens")
	private Set<Consultation> consultation;
	
	public Examen( String libelle) {
		
		
		this.libelle = libelle;
	}
	public Examen() {
		
	}
	public Examen(Examen exa, Consultation cons) {
		// TODO Auto-generated constructor stub
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
