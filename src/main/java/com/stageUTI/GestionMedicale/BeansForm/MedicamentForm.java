package com.stageUTI.GestionMedicale.BeansForm;

public class MedicamentForm {
	
	private String libelle;
	private String typeMedicament;
	private String description;
	private Integer  valide=1;
	public MedicamentForm(String libelle, String typeMedicament, String description) {
		
		this.libelle = libelle;
		this.typeMedicament = typeMedicament;
		this.description = description;
	}
	public MedicamentForm() {
		
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
