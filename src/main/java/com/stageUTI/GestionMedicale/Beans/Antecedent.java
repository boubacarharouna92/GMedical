package com.stageUTI.GestionMedicale.Beans;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Antecedent")
public class Antecedent {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	private String libelle;
	private String TypeAntecedent;
	
	@ManyToMany(mappedBy = "antecedents")
	private Set<DossierMedical> dossierMedicals;

	public Antecedent(String libelle, String typeAntecedent) {
		super();
		this.libelle = libelle;
		TypeAntecedent = typeAntecedent;
	}

	public Antecedent() {
		super();
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

	public String getTypeAntecedent() {
		return TypeAntecedent;
	}

	public void setTypeAntecedent(String typeAntecedent) {
		TypeAntecedent = typeAntecedent;
	}

	public Set<DossierMedical> getDossierMedicals() {
		return dossierMedicals;
	}

	public void setDossierMedicals(Set<DossierMedical> dossierMedicals) {
		this.dossierMedicals = dossierMedicals;
	}
	
	
}

