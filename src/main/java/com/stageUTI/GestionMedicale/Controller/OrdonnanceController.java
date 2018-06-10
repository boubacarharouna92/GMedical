package com.stageUTI.GestionMedicale.Controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.stageUTI.GestionMedicale.Beans.Ordonnance;
import com.stageUTI.GestionMedicale.Beans.Parametre;
import com.stageUTI.GestionMedicale.BeansForm.OrdonnanceForm;
import com.stageUTI.GestionMedicale.BeansForm.ParametreForm;
import com.stageUTI.GestionMedicale.Repository.OrdonnanceRepository;
import com.stageUTI.GestionMedicale.Repository.ParametreRepository;
@Controller
public class OrdonnanceController {

		@Resource
		  private OrdonnanceRepository ordonnance_service;
		
			/*
				Ajouter un  Ordonnance  
			 */
		
		 @GetMapping("/createOrdonnance")
		    public String createOrdonnance() { 	    
			 	return "Ordonnance/createOrdonnance";
		    }
		 
		 @PostMapping("/createOrdonnance")
		  public String ClasseSubmit(@Valid OrdonnanceForm form,BindingResult bindingResult, Model model) {
		    if (!bindingResult.hasErrors()) 
		    {
		        Date dateOrd = form.getDateOrd(); 
		        
		        try
		        {
		          Ordonnance ordonnance = new Ordonnance(dateOrd);
		          
		          ordonnance_service.save(ordonnance);
		          
		        }
			    catch(Exception e)
			    {
			      
			    }
		    }
		    else
		    {
		        
		        
		    }
		  
		    return "Ordonnance/createOrdonnance";
		      
		  }
		 
	

}
