package com.stageUTI.GestionMedicale.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stageUTI.GestionMedicale.Beans.Symptome;

@Repository
public interface SymptomeRepository extends CrudRepository<Symptome, Integer> {
	

	  List<Symptome> findByValide(Integer valide);

	List<Symptome> findByConsultation_Id(Integer consultation);
}