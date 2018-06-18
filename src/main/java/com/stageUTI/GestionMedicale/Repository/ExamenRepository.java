package com.stageUTI.GestionMedicale.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stageUTI.GestionMedicale.Beans.Examen;

@Repository
public interface ExamenRepository extends CrudRepository<Examen, Integer> {
	

	  List<Examen> findByValide(Integer valide);

	  List<Examen> findByConsultation_Id(Integer consultation);
	  
	  
	  @Modifying(clearAutomatically=true)
		@Transactional
		@Query(value = "insert into consultation_examens(consultation_id,examens_id) values(:consultation,:examen)",nativeQuery=true)
		public void AjoutExamenConsultation(@Param("consultation")Integer consultation,@Param("examen")Integer examens);

	  	  
}