package com.stageUTI.GestionMedicale.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.stageUTI.GestionMedicale.Beans.User;


@Controller
public class RegisterController {
	
	@Autowired
	private com.stageUTI.GestionMedicale.Service.UserService userService;
	
	@GetMapping("/register")
	public String registerFrom(Model model) {
		
		model.addAttribute("user", new User());
		return "views/registerForm";
		
	}
	
	@PostMapping("/register")
	public String registerUser( @Valid User user, BindingResult bindingResult,Model model) {
		
		if (bindingResult.hasErrors()) {
			return "views/registerForm";
		}
		
		if (userService.isUserPresent(user.getEmail())) {
			model.addAttribute("exist", true);
			return "views/registerForm";	
		}
		
		userService.createSecretaire(user);
		
		return "views/success";
		
		
		
	}

}
