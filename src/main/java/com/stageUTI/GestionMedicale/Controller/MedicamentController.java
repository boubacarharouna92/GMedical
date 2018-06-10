package com.stageUTI.GestionMedicale.Controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.stageUTI.GestionMedicale.Beans.Medicament;
import com.stageUTI.GestionMedicale.Beans.Parametre;
import com.stageUTI.GestionMedicale.BeansForm.MedicamentForm;
import com.stageUTI.GestionMedicale.BeansForm.ParametreForm;
import com.stageUTI.GestionMedicale.Repository.MedicamentRepository;
import com.stageUTI.GestionMedicale.Repository.ParametreRepository;

@Controller
public class MedicamentController {


	@Resource
	  private MedicamentRepository medicament_service;
	
		/*
			Ajouter un medicament
		 */
	
	 @GetMapping("/createMedicament")
	    public String createMedicament() { 	    
		 	return "Medicament/createMedicament";
	    }
	 
	 @PostMapping("/createMedicament")
	  public String ClasseSubmit(@Valid MedicamentForm form,BindingResult bindingResult, Model model) {
	    if (!bindingResult.hasErrors()) 
	    {
	        String libelle = form.getLibelle();
	        String typeMedicament = form.getTypeMedicament(); 
	        String description = form.getDescription(); 
	        
	        try
	        {
	          Medicament medicament = new Medicament(libelle,typeMedicament,description);
	          
	          medicament_service.save(medicament);
	          
	        }
		    catch(Exception e)
		    {
		      
		    }
	    }
	    else
	    {
	        
	        
	    }
	  
	    return "Medicament/createMedicament";
	      
	  }
	 
	  /*
		Liste 
	  */

	 @GetMapping("/medicamentShow")
	 public String medicament_servicehowRegion(Model model) {
	 try
		{
	    		List<Medicament> medicaments =  (List<Medicament>) medicament_service.findByValide(1);
	    		model.addAttribute("medicaments", medicaments);
		}
		catch(Exception e)
		{
			
		}
 		 return "Medicament/medicamentShow";
	 }
	 
	 @GetMapping("/editerMedicament/{id}")
	  public String showediterMedicament(MedicamentForm form,@PathVariable("id") Integer id, Model model) { 
	      model.addAttribute("form", form);
	      try
	      {
	        List<Medicament> medicaments =  (List<Medicament>) medicament_service.findByValide(1);
	        model.addAttribute("medicaments", medicaments);
	        Medicament medicament =   (medicament_service.findById(id)).get();
	        model.addAttribute("medicament", medicament);
	        model.addAttribute("id_medicament", id);
	      }
	      catch(Exception e)
	      {
	      
	      }
	      return "Medicament/editerMedicament";
	      
	  }
	  @GetMapping("/SupprimerMedicament/{id}")
	  public String showSupprimerMedicament(MedicamentForm form,@PathVariable("id") Integer id, Model model) { 
	      model.addAttribute("form", form);
	      try
	      {
	    	  Medicament medicament = (medicament_service.findById(id)).get();
		        medicament.setValide(0);
		        medicament_service.save(medicament);
	        List<Medicament> medicaments =  (List<Medicament>) medicament_service.findByValide(1);
	        model.addAttribute("medicaments", medicaments);
	       
	      }
	      catch(Exception e)
	      {
	      
	      }
	      return "Medicament/medicamentShow";
	      
	  }
	  
	  @PostMapping("/editerMedicament/{id}")
	  public String MedicamentRegionSubmit(@Valid MedicamentForm form,BindingResult bindingResult,@PathVariable("id") Integer id, Model model) {
	   // if (!bindingResult.hasErrors())
		 if (true)
	    {
	    	
	    	String libelle = form.getLibelle(); 
	    	String typeMedicament = form.getTypeMedicament(); 
	    	String description = form.getDescription(); 
	
	        try
	        {
		        Medicament medicament = (medicament_service.findById(id)).get();
		       medicament.setLibelle(libelle);
		       medicament.setTypeMedicament(typeMedicament);
		       medicament.setDescription(description);
		       medicament_service.save(medicament);
		        List<Medicament> medicaments =  (List<Medicament>) medicament_service.findByValide(1);
		        model.addAttribute("medicaments", medicaments);
		       
	        }
	        catch(Exception e)
	        {
	        
	        }
	  }

	    
	    else
	    {
	        try
	        {
	        	List<Medicament> medicaments =  (List<Medicament>) medicament_service.findByValide(1);
		        model.addAttribute("medicaments", medicaments);
		       
	        }
	        catch(Exception e)
	        {
	        
	        }
	   
	    }
	    
	    return "Medicament/medicamentShow";
	    
	  }


	
}
