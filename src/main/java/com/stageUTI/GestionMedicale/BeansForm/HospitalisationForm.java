package com.stageUTI.GestionMedicale.BeansForm;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.stageUTI.GestionMedicale.Beans.Chambre;
import com.stageUTI.GestionMedicale.Beans.Consultation;

public class HospitalisationForm {

	
	private Date dateHospitalisation; 
	private Date dateSorti; 
	private String motif;
	private Integer  valide=1;
	public HospitalisationForm(Date dateHospitalisation, Date dateSorti, String motif) {
		
		this.dateHospitalisation = dateHospitalisation;
		this.dateSorti = dateSorti;
		this.motif = motif;
	}
	public HospitalisationForm() {
		
		// TODO Auto-generated constructor stub
	}
	public Date getDateHospitalisation() {
		return dateHospitalisation;
	}
	public void setDateHospitalisation(Date dateHospitalisation) {
		this.dateHospitalisation = dateHospitalisation;
	}
	public Date getDateSorti() {
		return dateSorti;
	}
	public void setDateSorti(Date dateSorti) {
		this.dateSorti = dateSorti;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public Integer getValide() {
		return valide;
	}
	public void setValide(Integer valide) {
		this.valide = valide;
	}
	
	
	
	
}
