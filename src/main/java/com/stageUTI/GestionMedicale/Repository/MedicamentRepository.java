package com.stageUTI.GestionMedicale.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stageUTI.GestionMedicale.Beans.Medicament;
import com.stageUTI.GestionMedicale.Beans.Parametre;

@Repository
public interface MedicamentRepository extends CrudRepository<Medicament, Integer> {
	

	  List<Medicament> findByValide(Integer valide);
}


