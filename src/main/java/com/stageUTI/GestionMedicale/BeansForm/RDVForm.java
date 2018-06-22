package com.stageUTI.GestionMedicale.BeansForm;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class RDVForm {
	
    private Date dateRdv;
    private Time heureRdv;
    private String MotifRdv;
    private Integer  valide=1;
	public RDVForm(Date dateRdv, Time heureRdv, String motifRdv) {
		super();
		this.dateRdv = dateRdv;
		this.heureRdv = heureRdv;
		MotifRdv = motifRdv;
	}
	public RDVForm() {
		super();
	}
	public Date getDateRdv() {
		return dateRdv;
	}
	public void setDateRdv(Date dateRdv) {
		this.dateRdv = dateRdv;
	}
	public Time getHeureRdv() {
		return heureRdv;
	}
	public void setHeureRdv(Time heureRdv) {
		this.heureRdv = heureRdv;
	}
	public String getMotifRdv() {
		return MotifRdv;
	}
	public void setMotifRdv(String motifRdv) {
		MotifRdv = motifRdv;
	}

	public Integer getValide() {
		return valide;
	}

	public void setValide(Integer valide) {
		this.valide = valide;
	}
}
