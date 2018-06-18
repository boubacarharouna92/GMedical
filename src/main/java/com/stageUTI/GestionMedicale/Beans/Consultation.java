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
@Table(name = "Consultation")
public class Consultation {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	private Date DateConsultation;
	private String Motif; 
	private Integer  valide=1;
	
	@ManyToOne
	private Patient patient;
	
	@ManyToOne
	private Medecin medecin;
	
	 @ManyToMany
	 private Set<Symptome> symptomes;
	 
	 @ManyToMany
	 private Set<Examen> examens;
	
	public Consultation(String motif) {
		
		
		Motif = motif;
	}
	public Consultation() {
		
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDateConsultation() {
		return DateConsultation;
	}
	public void setDateConsultation(Date dateConsultation) {
		DateConsultation = dateConsultation;
	}
	public String getMotif() {
		return Motif;
	}
	public void setMotif(String motif) {
		Motif = motif;
	}
	public Integer getValide() {
		return valide;
	}
	public void setValide(Integer valide) {
		this.valide = valide;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Medecin getMedecin() {
		return medecin;
	}
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	public Set<Symptome> getSymptomes() {
		return symptomes;
	}
	public void setSymptomes(Set<Symptome> symptomes) {
		this.symptomes = symptomes;
	}
	public Set<Examen> getExamens() {
		return examens;
	}
	public void setExamens(Set<Examen> examens) {
		this.examens = examens;
	}
	
	
	
	
	
}
