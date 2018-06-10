package com.stageUTI.GestionMedicale.Beans;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
@Entity
@Table(name = "ordonnance")
public class Ordonnance {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	private Date dateOrd;
	private Integer valide=1; 
	
	
	@ManyToOne
	private Consultation consultation;


	public Ordonnance(Date dateOrd) {
		
		this.dateOrd = dateOrd;
	}


	public Ordonnance() {
		
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDateOrd() {
		return dateOrd;
	}


	public void setDateOrd(Date dateOrd) {
		this.dateOrd = dateOrd;
	}


	public Integer getValide() {
		return valide;
	}


	public void setValide(Integer valide) {
		this.valide = valide;
	}


	public Consultation getConsultation() {
		return consultation;
	}


	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}
	
	

}
