package com.stageUTI.GestionMedicale.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stageUTI.GestionMedicale.Beans.Chambre;
import com.stageUTI.GestionMedicale.Beans.Hospitalisation;

@Repository
public interface HospitalisationRepository extends CrudRepository<Hospitalisation, Integer> {
	

	  List<Hospitalisation> findByValide(Integer valide);
}
