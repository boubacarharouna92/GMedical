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
import com.stageUTI.GestionMedicale.Beans.Patient;
import com.stageUTI.GestionMedicale.BeansForm.ChambreForm;
import com.stageUTI.GestionMedicale.BeansForm.PatientForm;
import com.stageUTI.GestionMedicale.Repository.ChambreRepository;

@Controller
public class ChambreController {

	@Resource
	  private ChambreRepository chambre_service;
	
	
	 @GetMapping("/AjoutChambre")
	    public String AjoutChambre() { 	    
		 	return "Chambres/AjoutChambre";
	    }
	 
	 @PostMapping("/AjoutChambre")
	  public String ClasseSubmit(@Valid ChambreForm form,BindingResult bindingResult, Model model) {
	    if (!bindingResult.hasErrors()) 
	    {
	        
	        String typeChambre = form.getTypeChambre();
	        Integer numChambre = form.getNumChambre();
	        Integer numLit = form.getNumLit();
	        
	        try
	        {
	          Chambre chambre = new Chambre(typeChambre,numChambre,numLit);
	          
	          chambre_service.save(chambre);
	          
	        }
		    catch(Exception e)
		    {
		      
		    }
	    }
	    else
	    {
	        
	        
	    }
	  
	    return "Chambres/AjoutChambre";
	      
	  }
	 
	 	/*
		Listes  
	  */
		
		@GetMapping("/ListeChambre")
		 public String chambre_servicehowRegion(Model model) {
			 try
				{
			    		List<Chambre> chambres =  (List<Chambre>) chambre_service.findByValide(1);
			    		model.addAttribute("chambres", chambres);
				}
				catch(Exception e)
				{
					
				}
		 		 return "Chambres/ListeChambre";
		 		 
		}	 
		 @GetMapping("/editChambre/{id}")
		  public String showeditChambre(ChambreForm form,@PathVariable("id") Integer id, Model model) { 
		      model.addAttribute("form", form);
		      try
		      {
		        List<Chambre> chambres =  (List<Chambre>) chambre_service.findByValide(1);
		        model.addAttribute("chambres", chambres);
		        Chambre chambre =   (chambre_service.findById(id)).get();
		        model.addAttribute("chambre", chambre);
		        model.addAttribute("id_chambre", id);
		      }
		      catch(Exception e)
		      {
		      
		      }
		      return "Chambres/editChambre";
		      
		  }
		 @PostMapping("/editChambre/{id}")
		  public String ChambreRegionSubmit(@Valid ChambreForm form,BindingResult bindingResult,@PathVariable("id") Integer id, Model model) {
		    //if (!bindingResult.hasErrors())
			 if (true)
		    {
		    	
			        String typeChambre = form.getTypeChambre(); 
			        Integer numChambre = form.getNumChambre();
			        Integer numLit = form.getNumLit();
			        
		    
		        try
		        {
			        Chambre chambre = (chambre_service.findById(id)).get();
			        chambre.setTypeChambre(typeChambre);
			        chambre.setNumChambre(numChambre);
			        chambre.setNumLit(numLit);
			        
			        chambre_service.save(chambre);
			        List<Chambre> chambres =  (List<Chambre>) chambre_service.findByValide(1);
			        model.addAttribute("chambres", chambres);
			       
		        }
		        catch(Exception e)
		        {
		        
		        }
		  }

		    
		    else
		    {
		       try
		        {
		        	 List<Chambre> chambres =  (List<Chambre>) chambre_service.findByValide(1);
				        model.addAttribute("chambres", chambres);
				       
			       
		        }
		        catch(Exception e)
		        {
		        
		        }
		   
		    }
		    
		    return "Chambres/ListeChambre";
		    
		  }
		 @GetMapping("/deleteChambre/{id}")
		  public String showdeleteChambre(ChambreForm form,@PathVariable("id") Integer id, Model model) { 
		      model.addAttribute("form", form);
		      try
		      {
		    	  Chambre chambre = (chambre_service.findById(id)).get();
			        chambre.setValide(0);
			        chambre_service.save(chambre);
		        List<Chambre> chambres =  (List<Chambre>) chambre_service.findByValide(1);
		        model.addAttribute("chambres", chambres);
		       
		      }
		      catch(Exception e)
		      {
		      
		      }
		      return "Chambres/ListeChambre";
		      
		  }
		
	
}