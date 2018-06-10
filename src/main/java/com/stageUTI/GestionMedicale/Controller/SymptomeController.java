package com.stageUTI.GestionMedicale.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.stageUTI.GestionMedicale.Beans.Consultation;
import com.stageUTI.GestionMedicale.Beans.Symptome;
import com.stageUTI.GestionMedicale.Beans.Symptome;
import com.stageUTI.GestionMedicale.Beans.Symptome;
import com.stageUTI.GestionMedicale.BeansForm.SymptomeForm;
import com.stageUTI.GestionMedicale.Repository.ConsultationRepository;
import com.stageUTI.GestionMedicale.Repository.SymptomeRepository;




@Controller 
public class SymptomeController {
	
	@Resource
	  private SymptomeRepository symptome_service;
	
	@Resource
	  private ConsultationRepository consultation_service;
	 

	 @GetMapping("/AjoutSymptome")
	    public String AjoutSymptome() { 	    
		 	return "Symptome/AjoutSymptome";
	    }
	@PostMapping("/AjoutSymptome")
	  public String ClasseSubmit(@Valid SymptomeForm form,BindingResult bindingResult, Model model) {
	    if (!bindingResult.hasErrors()) 
	    {
	        String libelle = form.getLibelle(); 
	        
	        try
	        {
	          Symptome symptome = new Symptome(libelle);
	          
	          symptome_service.save(symptome);
	          
	        }
		    catch(Exception e)
		    {
		      
		    }
	    }
	    else
	    {
	        
	        
	    }
	  
	    return "Symptome/AjoutSymptome";
	      
	  }
	
	@GetMapping("/AddSymptomeUser")
    public String AddSymptomeUser(String libelle,Integer consultation,Model model ) { 
		/*Symptome symp = (symptome_service.findById(libelle)).get();*/
		
		Consultation cons = (consultation_service.findById(consultation)).get();
		Set<Consultation> consultations = new HashSet();
		consultations.add(cons);
		Symptome symp =  new Symptome(libelle,consultations);
		//Symptome symps = new Symptome(symp,cons);
		symptome_service.save(symp);
		List<Symptome> list_sp = symptome_service.findByConsultation_Id(consultation);
		model.addAttribute("list_sp", list_sp);
		
		return "Symptome/sp";
    }
	
	
	
	
	
	
	

}
