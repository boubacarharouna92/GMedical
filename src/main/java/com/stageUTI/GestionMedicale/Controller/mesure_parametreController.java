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

import com.stageUTI.GestionMedicale.Beans.Consultation;
import com.stageUTI.GestionMedicale.Beans.Parametre;
import com.stageUTI.GestionMedicale.Beans.mesure_parametre;
import com.stageUTI.GestionMedicale.BeansForm.ParametreForm;
import com.stageUTI.GestionMedicale.BeansForm.mesure_parametreForm;
import com.stageUTI.GestionMedicale.Repository.ConsultationRepository;
import com.stageUTI.GestionMedicale.Repository.ParametreRepository;
import com.stageUTI.GestionMedicale.Repository.mesure_parametreRepository;

@Controller
public class mesure_parametreController {


	@Resource
	  private mesure_parametreRepository mesureParametre_service;
	
	@Resource
	  private ConsultationRepository consultation_service;

	@Resource
	private ParametreRepository parametre_service;
	
		
	@GetMapping("/AjouterMesure")
    public String AjouterMesure(Model model ) { 
		
		//////////////// la modification se trouve ici//////////////////////////////////////
		List<Parametre> listeParametre = (List<Parametre>) parametre_service.findAll();
		
		model.addAttribute("listPatametre", listeParametre);
		
	 	return "MesureParametre/AjouterMesure";
    }
	
	@GetMapping("/AddParametreUser")
    public String AddParametreUser(Integer valeur,Integer parametre,Integer consultation,Model model ) { 
		Parametre param = (parametre_service.findById(parametre)).get();
		Consultation cons = (consultation_service.findById(consultation)).get();
		mesure_parametre mp = new mesure_parametre(valeur,cons,param);
		mesureParametre_service.save(mp);
		List<mesure_parametre> list_pv = mesureParametre_service.findByConsultation_Id(consultation);
		model.addAttribute("list_pv", list_pv);
		
		return "MesureParametre/pv";
    }
	
	@GetMapping("/GetParametreUser")
    public String GetParametreUser(Integer consultation,Model model ) { 
		
		List<mesure_parametre> list_pv = mesureParametre_service.findByConsultation_Id(consultation);
		model.addAttribute("list_pv", list_pv);
		
		return "MesureParametre/pv";
    }
	 
	 @PostMapping("/AjouterMesure")
	  public String ClasseSubmit(@Valid mesure_parametreForm form,BindingResult bindingResult, Model model) {
	    if (!bindingResult.hasErrors()) 
	    {
	        Integer valeur = form.getValeur(); 
	        
	        try
	        {
	          mesure_parametre mesure_parametres = new mesure_parametre(valeur);
	          
	          mesureParametre_service.save(mesure_parametres);
	          
	        }
		    catch(Exception e)
		    {
		      
		    }
	    }
	    else
	    {
	        
	        
	    }
	  
	    return "MesureParametre/ListeMesure";
	      
	  }
	 /*
		Liste 
	  */

	 @GetMapping("/listeMesure")
	 public String mesure_parametre_servicehowRegion(Model model) {
	 try
		{
	    		List<mesure_parametre> mesure_parametres =  (List<mesure_parametre>) mesureParametre_service.findByValide(1);
	    		model.addAttribute("mesure_parametres", mesure_parametres);
		}
		catch(Exception e)
		{
			
		}
		 return "MesureParametre/listeMesure";
	 }
	 
	 @GetMapping("/editerMesure/{id}")
	  public String showediterMesure(mesure_parametreForm form,@PathVariable("id") Integer id, Model model) { 
	      model.addAttribute("form", form);
	      try
	      {
	        List<mesure_parametre> mesure_parametres =  (List<mesure_parametre>) mesureParametre_service.findByValide(1);
	        model.addAttribute("mesure_parametres", mesure_parametres);
	        mesure_parametre mesure_parametre =   (mesureParametre_service.findById(id)).get();
	        model.addAttribute("mesure_parametre", mesure_parametre);
	        model.addAttribute("id_mesure_parametre", id);
	      }
	      catch(Exception e)
	      {
	      
	      }
	      return "MesureParametre/editerMesure";
	      
	  }
	  @GetMapping("/SupprimerMesure/{id}")
	  public String showSupprimerMesure(mesure_parametreForm form,@PathVariable("id") Integer id, Model model) { 
	      model.addAttribute("form", form);
	      try
	      {
	    	  mesure_parametre mesure_parametre = (mesureParametre_service.findById(id)).get();
		        mesure_parametre.setValide(0);
		        mesureParametre_service.save(mesure_parametre);
	        List<mesure_parametre> mesure_parametres =  (List<mesure_parametre>) mesureParametre_service.findByValide(1);
	        model.addAttribute("mesure_parametres", mesure_parametres);
	       
	      }
	      catch(Exception e)
	      {
	      
	      }
	      return "MesureParametre/listeMesure";
	      
	  }
	  
	  @PostMapping("/editerMesure/{id}")
	  public String ParametreRegionSubmit(@Valid mesure_parametreForm form,BindingResult bindingResult,@PathVariable("id") Integer id, Model model) {
	   // if (!bindingResult.hasErrors())
		 if (true)
	    {
	    	
	    	Integer valeur = form.getValeur(); 
	    	
	    
	        try
	        {
		        mesure_parametre mesure_parametre = (mesureParametre_service.findById(id)).get();
		        mesure_parametre.setValeur(valeur);
		       
		        
		        mesureParametre_service.save(mesure_parametre);
		        List<mesure_parametre> mesure_parametres =  (List<mesure_parametre>) mesureParametre_service.findByValide(1);
		        model.addAttribute("mesure_parametres", mesure_parametres);
		       
	        }
	        catch(Exception e)
	        {
	        
	        }
	  }

	    
	    else
	    {
	        try
	        {
	        	List<mesure_parametre> mesure_parametres =  (List<mesure_parametre>) mesureParametre_service.findByValide(1);
		        model.addAttribute("mesure_parametres", mesure_parametres);
		       
	        }
	        catch(Exception e)
	        {
	        
	        }
	   
	    }
	    
	    return "MesureParametre/listeMesure";
	    
	  }


	
}
