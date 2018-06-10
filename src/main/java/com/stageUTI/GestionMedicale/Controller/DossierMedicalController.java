package com.stageUTI.GestionMedicale.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DossierMedicalController {
	
	 @GetMapping("/dossierM")
	    public String dossierM() { 	    
		 	return "DossierMedical/dossierMedical";
	    }
	
}
