package com.stageUTI.GestionMedicale.Beans;


import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RDV")
public class RDV {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date dateRdv;
    private Time heureRdv;
    private String MotifRdv;
    private Integer  valide=1;
	public RDV(Date dateRdv, Time heureRdv, String motifRdv) {
		super();
		this.dateRdv = dateRdv;
		this.heureRdv = heureRdv;
		MotifRdv = motifRdv;
	}
	public RDV() {
		super();
		// TODO Auto-generated constructor stub
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
    

}
