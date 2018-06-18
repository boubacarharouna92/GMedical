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

import com.stageUTI.GestionMedicale.Beans.Chambre;
import com.stageUTI.GestionMedicale.Beans.Parametre;
import com.stageUTI.GestionMedicale.Beans.Parametre;
import com.stageUTI.GestionMedicale.BeansForm.ChambreForm;
import com.stageUTI.GestionMedicale.BeansForm.ParametreForm;
import com.stageUTI.GestionMedicale.BeansForm.ParametreForm;
import com.stageUTI.GestionMedicale.Repository.ParametreRepository;
import com.stageUTI.GestionMedicale.Repository.ParametreRepository;

@Controller
public class ParametreController {

	

	@Resource
	  private ParametreRepository parametre_service;
	
		/*
			Ajouter un  Parametre  
		 */
	
	 @GetMapping("/createParametre")
	    public String createParametre() { 	    
		 	return "Parametre/createParametre";
	    }
	 
	 @PostMapping("/createParametre")
	  public String ClasseSubmit(@Valid ParametreForm form,BindingResult bindingResult, Model model) {
	    if (!bindingResult.hasErrors()) 
	    {
	        
	        String libelle = form.getLibelle(); 
	       	        
	        try
	        {
	          Parametre parametre = new Parametre(libelle);
	          
	          parametre_service.save(parametre);
	          
	        }
		    catch(Exception e)
		    {
		      
		    }
	    }
	    else
	    {
	        
	        
	    }
	  
	    return "Parametre/createParametre";
	      
	  }
	
	
	  /*
		Liste 
	  */

	 @GetMapping("/parametreShow")
	 public String parametre_servicehowRegion(Model model) {
	 try
		{
	    		List<Parametre> parametres =  (List<Parametre>) parametre_service.findByValide(1);
	    		model.addAttribute("parametres", parametres);
		}
		catch(Exception e)
		{
			
		}
 		 return "Parametre/parametreShow";
	 }
	 
	 @GetMapping("/editerParametre/{id}")
	  public String showediterParametre(ParametreForm form,@PathVariable("id") Integer id, Model model) { 
	      model.addAttribute("form", form);
	      try
	      {
	        List<Parametre> parametres =  (List<Parametre>) parametre_service.findByValide(1);
	        model.addAttribute("parametres", parametres);
	        Parametre parametre =   (parametre_service.findById(id)).get();
	        model.addAttribute("parametre", parametre);
	        model.addAttribute("id_parametre", id);
	      }
	      catch(Exception e)
	      {
	      
	      }
	      return "Parametre/editerParametre";
	      
	  }
	  @GetMapping("/SupprimerParametre/{id}")
	  public String showSupprimerParametre(ParametreForm form,@PathVariable("id") Integer id, Model model) { 
	      model.addAttribute("form", form);
	      try
	      {
	    	  Parametre parametre = (parametre_service.findById(id)).get();
		        parametre.setValide(0);
		        parametre_service.save(parametre);
	        List<Parametre> parametres =  (List<Parametre>) parametre_service.findByValide(1);
	        model.addAttribute("parametres", parametres);
	       
	      }
	      catch(Exception e)
	      {
	      
	      }
	      return "Parametre/parametreShow";
	      
	  }
	  
	  @PostMapping("/editerParametre/{id}")
	  public String ParametreRegionSubmit(@Valid ParametreForm form,BindingResult bindingResult,@PathVariable("id") Integer id, Model model) {
	   // if (!bindingResult.hasErrors())
		 if (true)
	    {
	    	
	    	String libelle = form.getLibelle(); 
	    
	        try
	        {
		        Parametre parametre = (parametre_service.findById(id)).get();
		        parametre.setLibelle(libelle);
		       
		        
		        parametre_service.save(parametre);
		        List<Parametre> parametres =  (List<Parametre>) parametre_service.findByValide(1);
		        model.addAttribute("parametres", parametres);
		       
	        }
	        catch(Exception e)
	        {
	        
	        }
	  }

	    
	    else
	    {
	        try
	        {
	        	List<Parametre> Parametres =  (List<Parametre>) parametre_service.findByValide(1);
		        model.addAttribute("Parametres", Parametres);
		       
	        }
	        catch(Exception e)
	        {
	        
	        }
	   
	    }
	    
	    return "Parametre/parametreShow";
	    
	  }



	 
}
