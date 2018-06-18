package com.stageUTI.GestionMedicale.Controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	
	
	@GetMapping("/")
	public String showLoginForm() {
		
		
		return "views/loginForm";
	}
	
	
	@RequestMapping("/default")
	public String defaultAfterLogin(HttpServletRequest request) {
		if(request.isUserInRole("ROLE_SECRETAIRE")) {
			return "redirect:/ListePatient/"; 
		}
		
		if(request.isUserInRole("ROLE_MEDECIN")) {
			return "redirect:/listeConsult/"; 
		}
		return "redirect:/ListePatient/";
	}
	 
	

}
