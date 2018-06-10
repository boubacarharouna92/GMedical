package com.stageUTI.GestionMedicale.BeansForm;

public class AntecedentForm {
	
	private String libelle;
	private String TypeAntecedent;
	public AntecedentForm(String libelle, String typeAntecedent) {
		super();
		this.libelle = libelle;
		TypeAntecedent = typeAntecedent;
	}
	public AntecedentForm() {
		super();
		// TODO Auto-generated constructor stub
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
	
	

}
