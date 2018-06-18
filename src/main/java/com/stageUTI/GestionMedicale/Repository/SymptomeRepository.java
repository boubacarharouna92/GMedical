package com.stageUTI.GestionMedicale.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stageUTI.GestionMedicale.Beans.Symptome;

@Repository
public interface SymptomeRepository extends CrudRepository<Symptome, Integer> {
	

	  List<Symptome> findByValide(Integer valide);
	  List<Symptome> findByConsultation_Id(Integer consultation);
	
	@Modifying(clearAutomatically=true)
	@Transactional
	@Query(value = "insert into consultation_symptomes(consultation_id,symptomes_id) values(:consultation,:symptome)",nativeQuery=true)
	public void AjoutSymptomeConsultation(@Param("consultation")Integer consultation,@Param("symptome")Integer symptome);
}