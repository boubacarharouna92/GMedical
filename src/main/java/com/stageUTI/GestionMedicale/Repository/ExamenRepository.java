package com.stageUTI.GestionMedicale.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stageUTI.GestionMedicale.Beans.Examen;

@Repository
public interface ExamenRepository extends CrudRepository<Examen, Integer> {
	

	  List<Examen> findByValide(Integer valide);

	List<Examen> findByConsultation_Id(Integer consultation);
}