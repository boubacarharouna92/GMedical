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
import com.stageUTI.GestionMedicale.Beans.Patient;
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
	    public String AjoutSymptome(Model model) { 
		 
		 List<Symptome> symptomes =  (List<Symptome>) symptome_service.findByValide(1);
	        model.addAttribute("symptomes", symptomes);
	        
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
    public String AddSymptomeUser(Integer symptome,Integer consultation,Model model ) { 
		
		symptome_service.AjoutSymptomeConsultation(consultation,symptome);
		Symptome syn = (symptome_service.findById(symptome)).get();
		model.addAttribute("symptome", syn);
		return "Symptome/sp";
    }
	
	@GetMapping("/GetSP")
    public String GetSP(Integer consultation,Model model ) { 
		
		 Consultation cons = (consultation_service.findById(consultation)).get();
		model.addAttribute("symptomes", cons.getSymptomes());
		return "Symptome/liste_sp";
    }
	
	
	
	
	
	
	

}
