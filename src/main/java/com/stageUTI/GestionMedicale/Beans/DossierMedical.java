package com.stageUTI.GestionMedicale.Beans;


import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DossierMedical")

public class DossierMedical {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	private String NumDossier;
	
	@ManyToOne
	private Consultation consultation; 
	
	 @ManyToMany
	 private Set<Antecedent> antecedents;

	public DossierMedical(String numDossier) {
		super();
		NumDossier = numDossier;
	}

	public DossierMedical() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumDossier() {
		return NumDossier;
	}

	public void setNumDossier(String numDossier) {
		NumDossier = numDossier;
	}
	

	  @JoinTable(name = "antecedent_dossier", joinColumns = @JoinColumn(name = "antecedent_id"), inverseJoinColumns = @JoinColumn(name = "DossierMedical_id"))
	  
	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

	public Set<Antecedent> getAntecedents() {
		return antecedents;
	}

	public void setAntecedents(Set<Antecedent> antecedents) {
		this.antecedents = antecedents;
	}
	 
}

