package com.stageUTI.GestionMedicale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stageUTI.GestionMedicale.Beans.User;
import com.stageUTI.GestionMedicale.Service.UserService;



@SpringBootApplication
public class GestionMedicaleApplication implements CommandLineRunner {
	@Autowired
	private UserService userService; 
	
	public static void main(String[] args) {
		SpringApplication.run(GestionMedicaleApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		/*User nouveauAdmin = new User("admin@gmail.com", "Admin", "123456");
		userService.createAdmin(nouveauAdmin);
		
		
		User nouvelleSecretaire = new User("secretaire@gmail.com", "Secretaire", "123456");
		userService.createSecretaire(nouvelleSecretaire);
		
		
		User nouveauMedecin = new User("medecin@gmail.com", "Medecin", "123456");
		userService.createMedecin(nouveauMedecin);*/
		
		
		
	}

}
