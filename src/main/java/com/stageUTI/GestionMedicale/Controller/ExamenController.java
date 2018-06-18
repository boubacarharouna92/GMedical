package com.stageUTI.GestionMedicale.Controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.stageUTI.GestionMedicale.Beans.Consultation;
import com.stageUTI.GestionMedicale.Beans.Examen;
import com.stageUTI.GestionMedicale.Beans.Symptome;
import com.stageUTI.GestionMedicale.BeansForm.ExamenForm;
import com.stageUTI.GestionMedicale.BeansForm.SymptomeForm;
import com.stageUTI.GestionMedicale.Repository.ConsultationRepository;
import com.stageUTI.GestionMedicale.Repository.ExamenRepository;

@Controller
public class ExamenController {
	
	@Resource
	  private ExamenRepository examen_service;
	
	@Resource
	  private ConsultationRepository consultation_service;
	
	@GetMapping("/AjoutExamen")
    public String AjoutExamen(Model model) { 	 
		
		List<Examen> examens =  (List<Examen>) examen_service.findByValide(1);
	    model.addAttribute("examens", examens);
		
	 	return "Examen/AjoutExamen";
    }
@PostMapping("/AjoutExamen")
  public String ClasseSubmit(@Valid ExamenForm form,BindingResult bindingResult, Model model) {
  
	if (!bindingResult.hasErrors()) 
    {
        String libelle = form.getLibelle(); 
        
        try
        {
          Examen examen = new Examen(libelle);
          
        examen_service.save(examen);
          
        }
	    catch(Exception e)
	    {
	      
	    }
    }
    else
    {
        
        
    }
  
    return "Examen/AjoutExamen";
      
  }
	
					
		@GetMapping("/AddExamenUser")
		public String AddExamenUser(Integer examen,Integer consultation,Model model ) { 
			
			examen_service.AjoutExamenConsultation(consultation,examen);
			Examen exa = (examen_service.findById(examen)).get();
			model.addAttribute("examen", exa);
			return "Examen/exp";
		}
		
		@GetMapping("/Getexm")
		public String Getexm(Integer consultation,Model model ) { 
			
			 Consultation cons = (consultation_service.findById(consultation)).get();
			model.addAttribute("examens", cons.getExamens());
			return "Examen/liste_examen";
		}
		



}
