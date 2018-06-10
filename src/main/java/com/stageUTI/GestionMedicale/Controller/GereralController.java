 package com.stageUTI.GestionMedicale.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GereralController{

	 @GetMapping("/")
	    public String index() { 	    
		 	return "Patients/ListePatient";
	    }
}
