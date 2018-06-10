package com.stageUTI.GestionMedicale.BeansForm;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



public class ConsultForm {
	
	
	private Date DateConsultation;
	private String Motif; 
	private Integer  valide=1;
	
	
	
	public ConsultForm(Date dateConsultation, String motif) {
		
		DateConsultation = dateConsultation;
		Motif = motif;
	}
	public ConsultForm() {
		
		// TODO Auto-generated constructor stub
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
	

}
