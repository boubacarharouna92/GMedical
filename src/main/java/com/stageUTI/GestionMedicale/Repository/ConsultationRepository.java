package com.stageUTI.GestionMedicale.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.stageUTI.GestionMedicale.Beans.Consultation;
@Repository
public interface ConsultationRepository extends CrudRepository<Consultation, Integer> {
	

	  List<Consultation> findByValide(Integer valide);
	  
	  @Query("SELECT p from Patient p")
	  List<Consultation> findConsultBy();
}