package com.stageUTI.GestionMedicale.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stageUTI.GestionMedicale.Beans.Hospitalisation;
import com.stageUTI.GestionMedicale.Beans.Ordonnance;

@Repository
public interface OrdonnanceRepository extends CrudRepository<Ordonnance, Integer> {
	

	  List<Ordonnance> findByValide(Integer valide);
}


