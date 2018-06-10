package com.stageUTI.GestionMedicale.Beans;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Hospitalisation")
public class Hospitalisation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	private Date dateHospitalisation; 
	private Date dateSorti; 
	private String motif;
	private Integer  valide=1;
	
	@ManyToOne
	private Consultation consultation; 
	
	@ManyToOne
	private Chambre chambre;

	public Hospitalisation(Date dateHospitalisation, Date dateSorti, String motif) {
		super();
		this.dateHospitalisation = dateHospitalisation;
		this.dateSorti = dateSorti;
		this.motif = motif;
	}

	public Hospitalisation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	
	
}
