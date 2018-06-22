package com.stageUTI.GestionMedicale.Controller;



import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.stageUTI.GestionMedicale.Beans.Chambre;
import com.stageUTI.GestionMedicale.Beans.Consultation;
import com.stageUTI.GestionMedicale.Beans.Parametre;
import com.stageUTI.GestionMedicale.Beans.Consultation;
import com.stageUTI.GestionMedicale.Beans.Patient;
import com.stageUTI.GestionMedicale.BeansForm.ChambreForm;
import com.stageUTI.GestionMedicale.BeansForm.ConsultForm;
import com.stageUTI.GestionMedicale.BeansForm.ParametreForm;
import com.stageUTI.GestionMedicale.BeansForm.PatientForm;
import com.stageUTI.GestionMedicale.Repository.ConsultationRepository;
import com.stageUTI.GestionMedicale.Repository.ParametreRepository;
import com.stageUTI.GestionMedicale.Repository.PatientRepository;
import com.stageUTI.GestionMedicale.Repository.mesure_parametreRepository;
import com.stageUTI.GestionMedicale.BeansForm.ConsultForm;


@Controller 
public class ConsultationController {

	
	@Resource
	  private ConsultationRepository consultation_service;
	
	@Resource
	  private PatientRepository patient_service;

	@Resource
	  private ParametreRepository parametre_service;
	
	@Resource
	  private mesure_parametreRepository mesureParametre_service;


	
	
	@GetMapping("/consultation")
    public String consultation() { 	    
	 	return "Consultation/consultation";
	 	
	}
	
	@GetMapping("/ajout")
    public String ajout() { 	    
	 	return "Consultation/ajout";
	 	
	}
	
	
	
	 @GetMapping("/consultation/{id}")
	  public String showconsultation(@PathVariable("id") Integer id, Model model) { 
	     
	        Consultation consultation =   (consultation_service.findById(id)).get();
	        model.addAttribute("consultation", consultation);
	        model.addAttribute("id_consultation", id);
	        model.addAttribute("patient",consultation.getPatient()); 
	      
	      return "Consultation/consultation";
	      
	  }
	 
	 
	 
	 @GetMapping("/viewPatient")
	  public String viewPatient (Integer id_patient, Model model) {
		Optional<Patient> patientOptional = patient_service.findById(id_patient);
		Patient patient = (Patient) patientOptional.get();  
		
		System.out.println(patient.getNom());
		System.out.println(patient.getPrenom());
		model.addAttribute("patient",patient); 
		
		 
		 
		 return "Consultation/consultation"; 		 
		 
		 
		 
	 }
	 
	
	 @GetMapping("/AjouterConsult")
	    public String AjouterConsult() { 	    
		 	return "Consultation/AjouterConsult";
	    }
	 
	 @GetMapping("/AjoutConsultation/{id}")
	  public String ajoutConsultation(ConsultForm form,@PathVariable("id") Integer id, Model model, HttpSession session) { 
	      //model.addAttribute("form", form);
		 
		 session.setAttribute("idPatient", id);
	      
	     return"Consultation/AjouterConsult";
	  }
	  
	 
	 
	 @PostMapping("/AjouterConsult")
	  public String ClasseSubmit(@Valid ConsultForm form,BindingResult bindingResult, Model model, HttpSession session) {
		 
		 	List<Patient> patients =  (List<Patient>) patient_service.findByValide(1);
	        model.addAttribute("patients", patients);
				    if (!bindingResult.hasErrors()) 
				    {
				        
				        
				        String Motif = form.getMotif(); 
				        
				        try
				        {
				        	Integer idPatient = (Integer) session.getAttribute("idPatient");
				        	Patient patient = (patient_service.findById(idPatient)).get();
					        patient.setValide(2);
					        patient_service.save(patient);

					        Consultation consultation = new Consultation();
					        consultation.setDateConsultation(new Date());
					        consultation.setPatient(patient); 
					        consultation.setMotif(Motif);
					        consultation_service.save(consultation);
				          
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
		Listes  
		 */
		
		@GetMapping("/listeConsult")
		 public String consultation_servicehowRegion(Model model) {
			 try
				{
			    		List<Consultation> consultations =  (List<Consultation>) consultation_service.findByValide(1);
			    		model.addAttribute("consultations", consultations);

				}
				catch(Exception e)
				{
					
				}
		 		 return "Consultation/listeConsult";
		 		 
		}	
		 @GetMapping("/editConsult/{id}")
		  public String showeditConsult(ConsultForm form,@PathVariable("id") Integer id, Model model) { 
		      model.addAttribute("form", form);
		      try
		      {
		        List<Consultation> consultations =  (List<Consultation>) consultation_service.findByValide(1);
		        model.addAttribute("consultations", consultations);
		        Consultation consultation =   (consultation_service.findById(id)).get();
		        model.addAttribute("consultation", consultation);
		        model.addAttribute("id_consultation", id);
		      }
		      catch(Exception e)
		      {
		      
		      }
		      return "Consultation/editConsult";
		      
		  }
		 @PostMapping("/editConsult/{id}")
		  public String ConsultationRegionSubmit(@Valid ConsultForm form,BindingResult bindingResult,@PathVariable("id") Integer id, Model model) {
		    //if (!bindingResult.hasErrors())
			 if (true)
		    {
		    	
				 Date dateConsultation = form.getDateConsultation(); 
			     String motif = form.getMotif(); 
			        
		    
		        try
		        {
			        Consultation consultation = (consultation_service.findById(id)).get();
			        consultation.setDateConsultation(dateConsultation);
			        consultation.setMotif(motif);
			        
			        
			        consultation_service.save(consultation);
			        List<Consultation> consultations =  (List<Consultation>) consultation_service.findByValide(1);
			        model.addAttribute("consultations", consultations);
			       
		        }
		        catch(Exception e)
		        {
		        
		        }
		  }

		    
		    else
		    {
		       try
		        {
		    	   List<Consultation> consultations =  (List<Consultation>) consultation_service.findByValide(1);
			        model.addAttribute("consultations", consultations);
			       
				       
			       
		        }
		        catch(Exception e)
		        {
		        
		        }
		   
		    }
			 
			 return "Consultation/listeConsult";
			    
		  }
		 
		/* @GetMapping("/AjoutConsultation/{id}")
		  public String showAjoutConsultation(ConsultForm form,@PathVariable("id") Integer id, Model model) { 
		      model.addAttribute("form", form);
		      
		      String Motif = form.getMotif();
		      
		      try
		      {
		    	  
		    	  Patient patient = (patient_service.findById(id)).get();
			        patient.setValide(0);
			        patient_service.save(patient);
			        
			        Consultation consultation = new Consultation();
			        
			        consultation.setDateConsultation(new Date());
			        consultation.setPatient(patient); 
			        consultation.setMotif(Motif);
			        consultation_service.save(consultation); 
			        
			     
		        List<Patient> patients =  (List<Patient>) patient_service.findByValide(1);
		        model.addAttribute("patients", patients);
		       
		      }
		      catch(Exception e)
		      {
		      
		      }
		      return "Consultation/AjouterConsult";
		      
		  }*/
		  
		 
		 
		 
		 
		 @GetMapping("/deleteConsult/{id}")
		  public String showdeleteConsult(ConsultForm form,@PathVariable("id") Integer id, Model model) { 
		      model.addAttribute("form", form);
		      try
		      {
		    	  Consultation consultation = (consultation_service.findById(id)).get();
			        consultation.setValide(0);
			        consultation_service.save(consultation);
			        List<Consultation> consultations =  (List<Consultation>) consultation_service.findByValide(1);
			        model.addAttribute("consultations", consultations);
		      }
		      catch(Exception e)
		      {
		      
		      }
		      return "Consultation/listeConsult";
		      
		  }
	 
	
	
}
