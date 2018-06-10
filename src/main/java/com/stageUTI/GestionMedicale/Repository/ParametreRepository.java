package com.stageUTI.GestionMedicale.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stageUTI.GestionMedicale.Beans.Parametre;



@Repository
public interface ParametreRepository extends CrudRepository<Parametre, Integer> {
	

	  List<Parametre> findByValide(Integer valide);
}