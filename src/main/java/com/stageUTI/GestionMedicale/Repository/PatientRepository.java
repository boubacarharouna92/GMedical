package com.stageUTI.GestionMedicale.Repository;


import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stageUTI.GestionMedicale.Beans.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {

  List<Patient> findByValide(Integer valide);
  
 // @Query("SELECT p from Patient p where p.consultation=:x ")
 	//public  List<Patient> listPatients(@Param("x") boolean historic);
  
  
  @Query("SELECT p from Patient p where p.valide=:x ")
	public  List<Patient> listPatients(@Param("x")Integer valide);
   
  
}


