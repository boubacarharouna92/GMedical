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
	
	@GetMapping("/examen")
    public String examen() { 	    
	 	return "Symptome/examen";
    }
@PostMapping("/examen")
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
  
    return "Symptome/examen";
      
  }

@GetMapping("/AddExamenUser")
public String AddExamenUser(Integer libelle,Integer consultation,Model model ) { 
	Examen exa = (examen_service.findById(libelle)).get();
	Consultation cons = (consultation_service.findById(consultation)).get();
	Examen exams = new Examen(exa,cons);
	examen_service.save(exams);
	List<Examen> list_sp = examen_service.findByConsultation_Id(consultation);
	model.addAttribute("list_sp", list_sp);
	
	return "Symptome/sp";
}



}
