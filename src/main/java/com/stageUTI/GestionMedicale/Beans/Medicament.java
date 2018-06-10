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
@Table(name = "medicament")
public class Medicament {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	private String libelle;
	private String typeMedicament;
	private String description;
	private Integer  valide=1;
	public Medicament(String libelle, String typeMedicament, String description) {
		
		this.libelle = libelle;
		this.typeMedicament = typeMedicament;
		this.description = description;
	}
	public Medicament() {
		
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
	public String getTypeMedicament() {
		return typeMedicament;
	}
	public void setTypeMedicament(String typeMedicament) {
		this.typeMedicament = typeMedicament;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getValide() {
		return valide;
	}
	public void setValide(Integer valide) {
		this.valide = valide;
	}
	
	
	
}
