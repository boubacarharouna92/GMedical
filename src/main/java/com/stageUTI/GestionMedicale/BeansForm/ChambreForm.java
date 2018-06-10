package com.stageUTI.GestionMedicale.BeansForm;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class ChambreForm {

	private String typeChambre; 
	private Integer numChambre; 
	private Integer numLit;
	private Integer  valide=1;
	public ChambreForm(String typeChambre, Integer numChambre, Integer numLit) {
		
		this.typeChambre = typeChambre;
		this.numChambre = numChambre;
		this.numLit = numLit;
	}
	public ChambreForm() {
	
	}
	
	public String getTypeChambre() {
		return typeChambre;
	}
	public void setTypeChambre(String typeChambre) {
		this.typeChambre = typeChambre;
	}
	public Integer getNumChambre() {
		return numChambre;
	}
	public void setNumChambre(Integer numChambre) {
		this.numChambre = numChambre;
	}
	public Integer getNumLit() {
		return numLit;
	}
	public void setNumLit(Integer numLit) {
		this.numLit = numLit;
	}
	public Integer getValide() {
		return valide;
	}
	public void setValide(Integer valide) {
		this.valide = valide;
	}
	
}
