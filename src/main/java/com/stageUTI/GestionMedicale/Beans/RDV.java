package com.stageUTI.GestionMedicale.Beans;


import java.sql.Time;
import java.util.Date;

import javax.persistence.*;

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

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Medecin medecin;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValide() {
        return valide;
    }

    public void setValide(Integer valide) {
        this.valide = valide;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
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
