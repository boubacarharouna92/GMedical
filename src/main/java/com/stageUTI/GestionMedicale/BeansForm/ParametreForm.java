package com.stageUTI.GestionMedicale.BeansForm;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ParametreForm {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	private String libelle;
	private Integer Valide=1;
	public ParametreForm(String libelle) {
		
		this.libelle = libelle;
	}
	public ParametreForm() {
		
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
		return Valide;
	}
	public void setValide(Integer valide) {
		Valide = valide;
	} 
	
}
