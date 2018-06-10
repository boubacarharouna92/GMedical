package com.stageUTI.GestionMedicale.Controller;


import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.stageUTI.GestionMedicale.Beans.Hospitalisation;
import com.stageUTI.GestionMedicale.Beans.RDV;
import com.stageUTI.GestionMedicale.Beans.Hospitalisation;
import com.stageUTI.GestionMedicale.BeansForm.HospitalisationForm;
import com.stageUTI.GestionMedicale.BeansForm.RDVForm;
import com.stageUTI.GestionMedicale.BeansForm.HospitalisationForm;
import com.stageUTI.GestionMedicale.Repository.HospitalisationRepository;
import com.stageUTI.GestionMedicale.Repository.PatientRepository;
import com.stageUTI.GestionMedicale.Repository.RDVRepository;


@Controller
public class RDVController{

	@Resource
	  private RDVRepository rdv_service;
	
		/*
			Ajouter RDV
		 */
	
	 @GetMapping("/AjoutRDV")
	    public String AjoutRDV() { 	    
		 	return "RDV/AjoutRDV";
	    }
	 
	 @PostMapping("/AjoutRDV")
	  public String ClasseSubmit(@Valid RDVForm form,BindingResult bindingResult, Model model) {
	    if (!bindingResult.hasErrors()) 
	    {
	    	 Date dateRdv =form.getDateRdv();
	    	 Time heureRdv= form.getHeureRdv();
	    	 String MotifRdv=form.getMotifRdv();
	    	 
	        try
	        {
	        	RDV rdv = new RDV(dateRdv,heureRdv,MotifRdv);
	          
	        	rdv_service.save(rdv);
	          
	        }
		    catch(Exception e)
		    {
		      
		    }
	    }
	    else
	    {
	        
	        
	    }
	  
	    return "RDV/AjoutRDV";
	      
	  }
	 
	 /*
	 		Liste Hospitalisation 
	 */
	 
	 @GetMapping("/ListeRDV")
	    public String rdv_servicehowRegion(Model model) {
		 try
			{
		    		List<RDV> rdvs =  (List<RDV>) rdv_service.findByValide(1);
		    		model.addAttribute("rdvs", rdvs);
			}
			catch(Exception e)
			{
				
			}
	    		 return "RDV/ListeRDV";
	    }
	 
	 

	  @GetMapping("/ModifierRDV{id}")
	  public String showMofifierRDV(RDVForm form,@PathVariable("id") Integer id, Model model) { 
	      model.addAttribute("form", form);
	      try
	      {
	    	  List<RDV> rdvs =  (List<RDV>) rdv_service.findByValide(1);
	    		model.addAttribute("rdvs", rdvs);
	    		RDV rdv =   (rdv_service.findById(id)).get();
	        model.addAttribute("rdv", rdv);
	        model.addAttribute("id_rdv", id);
	      }
	      catch(Exception e)
	      {
	      
	      }
	      return "RDV/ModifierRDV";
	      
	  }
	  
	  @PostMapping("/ModifierRDV/{id}")
	  public String RDVRegionSubmit(@Valid RDVForm form,BindingResult bindingResult,@PathVariable("id") Integer id, Model model) {
	    if (!bindingResult.hasErrors()) 
	    {

	    	 Date dateRdv =form.getDateRdv();
	    	 Time heureRdv= form.getHeureRdv();
	    	 String motifRdv=form.getMotifRdv();
	        try
	        {
	        	RDV rdv = (rdv_service.findById(id)).get();
		       rdv.setDateRdv(dateRdv);
		       rdv.setHeureRdv(heureRdv);
		       rdv.setMotifRdv(motifRdv);
		        
		       rdv_service.save(rdv);


		    	  List<RDV> rdvs =  (List<RDV>) rdv_service.findByValide(1);
		    		model.addAttribute("rdvs", rdvs);
	        }
	        catch(Exception e)
	        {
	        
	        }
	  }

	    
	    else
	    {
	        try
	        {


		    	  List<RDV> rdv =  (List<RDV>) rdv_service.findByValide(1);
		    		model.addAttribute("rdv", rdv);
	        }
	        catch(Exception e)
	        {
	        
	        }
	   
	    }
	    
	    return "RDV/ListeRDV";
	    
	  }
}
	  
	      
	 




