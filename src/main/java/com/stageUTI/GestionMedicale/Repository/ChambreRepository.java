package com.stageUTI.GestionMedicale.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stageUTI.GestionMedicale.Beans.Chambre; 

@Repository
public interface ChambreRepository extends CrudRepository<Chambre, Integer> {
	

	  List<Chambre> findByValide(Integer valide);
}

  
  