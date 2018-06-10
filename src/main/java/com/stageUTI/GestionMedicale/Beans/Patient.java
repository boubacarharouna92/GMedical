package com.stageUTI.GestionMedicale.Beans;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String lieuNaissance;
    private String sexe; 
    private String telephone; 
    private String adresse; 
    private String profession; 
    private Integer  valide=1;
    private boolean consultation = false;
    
	public Patient(String nom, String prenom, Date dateNaissance, String lieuNaissance, String sexe,
			String telephone, String adresse, String profession) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.sexe = sexe;
		this.telephone = telephone;
		this.adresse = adresse;
		this.profession = profession;
		
	}
	
	
	public Patient(String nom, String prenom, Date dateNaissance, String lieuNaissance, String sexe, String telephone,
			String adresse, String profession, Integer valide, boolean consultation) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.sexe = sexe;
		this.telephone = telephone;
		this.adresse = adresse;
		this.profession = profession;
		this.valide = valide;
		this.consultation = consultation;
	}


	public boolean isConsultation() {
		return consultation;
	}


	public void setConsultation(boolean consultation) {
		this.consultation = consultation;
	}


	public Patient() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getLieuNaissance() {
		return lieuNaissance;
	}
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public Integer getValide() {
		return valide;
	}
	public void setValide(Integer valide) {
		this.valide = valide;
	}
	
	
    
   
    
}