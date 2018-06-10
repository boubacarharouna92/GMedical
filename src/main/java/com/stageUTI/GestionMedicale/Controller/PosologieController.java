package com.stageUTI.GestionMedicale.Controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.stageUTI.GestionMedicale.Beans.Posologie;
import com.stageUTI.GestionMedicale.BeansForm.PosoligieForm;
import com.stageUTI.GestionMedicale.Repository.PosologieRepository;
import com.stageUTI.GestionMedicale.Repository.PosologieRepository;
@Controller
public class PosologieController {
	

	@Resource
	  private PosologieRepository posologie_service;
	
		/*
			Ajouter un  Posologie  
		 */
	
	 @GetMapping("/createPosologie")
	    public String createPosologie() { 	    
		 	return "Posologie/createPosologie";
	    }
	 
	 @PostMapping("/createPosologie")
	  public String ClasseSubmit(@Valid PosoligieForm form,BindingResult bindingResult, Model model) {
	    if (!bindingResult.hasErrors()) 
	    {
	        String libelle = form.getLibelle();
	        
	        try
	        {
	          Posologie posologie = new Posologie(libelle);
	          
	          posologie_service.save(posologie);
	          
	        }
		    catch(Exception e)
		    {
		      
		    }
	    }
	    else
	    {
	        
	        
	    }
	  
	    return "Posologie/createPosologie";
	      
	  }

}
