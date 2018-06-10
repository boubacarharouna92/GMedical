package com.stageUTI.GestionMedicale.Controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.stageUTI.GestionMedicale.Beans.Patient;
import com.stageUTI.GestionMedicale.BeansForm.PatientForm;
import com.stageUTI.GestionMedicale.Repository.PatientRepository;


@Controller
public class PatientController{

	@Resource
	  private PatientRepository patient_service;
	
		/*
			Ajouter un  patient  
		 */
	
	 @GetMapping("/AjoutPatient")
	    public String AjoutPatient() { 	    
		 	return "Patients/ListePatient";
	    }
	 
	 @PostMapping("/AjoutPatient")
	  public String ClasseSubmit(@Valid PatientForm form,BindingResult bindingResult, Model model) {
	    if (!bindingResult.hasErrors()) 
	    {
	        String nom = form.getNom();
	        String prenom = form.getPrenom(); 
	        Date dateNaissance = form.getDateNaissance(); 
	        String lieuNaissance = form.getLieuNaissance(); 
	        String sexe = form.getSexe(); 
	        String telephone = form.getTelephone(); 
	        String adresse = form.getAdresse(); 
	        String profession = form.getProfession(); 
	        
	        try
	        {
	          Patient patient = new Patient(nom,prenom,dateNaissance,lieuNaissance,sexe,telephone,adresse,profession);
	          
	          patient_service.save(patient);
	          
	        }
		    catch(Exception e)
		    {
		      
		    }
	    }
	    else
	    {
	        
	        
	    }
	  
	    return "redirect:/ListePatient"; 
	      
	  }
	 
	 /*
	 		Liste des patients  
	 */
	 
	 @GetMapping("/ListePatient")
	    public String spatient_servicehowRegion(Model model) {
		 try
			{
		    		List<Patient> patients =  (List<Patient>) patient_service.listPatients(1);
		    		model.addAttribute("patients", patients);
			}
			catch(Exception e)
			{
				
			}
	    		 return "Patients/ListePatient";
	    }
	 
	 

	  @GetMapping("/ModifierPatient/{id}")
	  public String showMofifierPatient(PatientForm form,@PathVariable("id") Integer id, Model model) { 
	      model.addAttribute("form", form);
	      try
	      {
	        List<Patient> patients =  (List<Patient>) patient_service.findByValide(1);
	        model.addAttribute("patients", patients);
	        Patient patient =   (patient_service.findById(id)).get();
	        model.addAttribute("patient", patient);
	        model.addAttribute("id_patient", id);
	      }
	      catch(Exception e)
	      {
	      
	      }
	      return "Patients/ModifierPatient";
	      
	  }
	  @GetMapping("/SupprimerPatient/{id}")
	  public String showSupprimerPatient(PatientForm form,@PathVariable("id") Integer id, Model model) { 
	      model.addAttribute("form", form);
	      try
	      {
	    	  Patient patient = (patient_service.findById(id)).get();
		        patient.setValide(0);
		        patient_service.save(patient);
	        List<Patient> patients =  (List<Patient>) patient_service.findByValide(1);
	        model.addAttribute("patients", patients);
	       
	      }
	      catch(Exception e)
	      {
	      
	      }
	      return "redirect:/ListePatient";
	      
	  }
	  
	  @PostMapping("/ModifierPatient/{id}")
	  public String PatientRegionSubmit(@Valid PatientForm form,BindingResult bindingResult,@PathVariable("id") Integer id, Model model) {
	   // if (!bindingResult.hasErrors())
		 if (true)
	    {
	    	
	    	String nom = form.getNom();
	        String prenom = form.getPrenom(); 
	        Date dateNaissance = form.getDateNaissance(); 
	        String lieuNaissance = form.getLieuNaissance(); 
	        String sexe = form.getSexe(); 
	        String telephone = form.getTelephone(); 
	        String adresse = form.getAdresse(); 
	        String profession = form.getProfession(); 
	    
	        try
	        {
		        Patient patient = (patient_service.findById(id)).get();
		        patient.setNom(nom);
		        patient.setPrenom(prenom);
		        patient.setDateNaissance(dateNaissance);
		        patient.setLieuNaissance(lieuNaissance);
		        patient.setSexe(sexe);
		        patient.setTelephone(telephone);
		        patient.setAdresse(adresse);
		        patient.setProfession(profession);
		        
		        patient_service.save(patient);
		        List<Patient> patients =  (List<Patient>) patient_service.findByValide(1);
		        model.addAttribute("patients", patients);
		       
	        }
	        catch(Exception e)
	        {
	        
	        }
	  }

	    
	    else
	    {
	        try
	        {
	        	List<Patient> patients =  (List<Patient>) patient_service.findByValide(1);
		        model.addAttribute("patients", patients);
		       
	        }
	        catch(Exception e)
	        {
	        
	        }
	   
	    }
	    
		 return "redirect:/ListePatient";
	    
	  }
}