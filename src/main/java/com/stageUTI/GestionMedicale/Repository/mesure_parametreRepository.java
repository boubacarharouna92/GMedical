package com.stageUTI.GestionMedicale.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stageUTI.GestionMedicale.Beans.Parametre;
import com.stageUTI.GestionMedicale.Beans.mesure_parametre;

@Repository
public interface mesure_parametreRepository extends CrudRepository<mesure_parametre, Integer> {
	

	  List<mesure_parametre> findByValide(Integer valide);
	  List<mesure_parametre> findByConsultation_Id(Integer id);
}