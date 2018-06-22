package com.stageUTI.GestionMedicale;

import com.stageUTI.GestionMedicale.Beans.Patient;
import com.stageUTI.GestionMedicale.Beans.RDV;
import com.stageUTI.GestionMedicale.Repository.PatientRepository;
import com.stageUTI.GestionMedicale.Repository.RDVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stageUTI.GestionMedicale.Beans.User;
import com.stageUTI.GestionMedicale.Service.UserService;

import java.sql.Time;
import java.util.Date;


@SpringBootApplication
public class GestionMedicaleApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;
	@Autowired
	private RDVRepository rdvRepository;
		@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(GestionMedicaleApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		User nouveauAdmin = new User("admin@gmail.com", "Admin", "123456");
		userService.createAdmin(nouveauAdmin);


		User nouvelleSecretaire = new User("secretaire@gmail.com", "Secretaire", "123456");
		userService.createSecretaire(nouvelleSecretaire);


		User nouveauMedecin = new User("medecin@gmail.com", "Medecin", "123456");
		userService.createMedecin(nouveauMedecin);

		RDV rdv = new RDV();
		rdv.setDateRdv(new Date());
		rdv.setHeureRdv(new Time(new Date().getTime()));

		Patient patient  = new Patient();
		patient.setValide(1);
		patient.setTelephone("5258965");
		patient.setAdresse("fina");
		patient.setNom("KONE");
		patient.setPrenom("guine");
		patientRepository.save(patient);

		rdv.setPatient(patient);
		rdvRepository.save(rdv);

		
		
	}

}
