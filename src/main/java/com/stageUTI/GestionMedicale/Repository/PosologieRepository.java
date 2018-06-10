package com.stageUTI.GestionMedicale.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stageUTI.GestionMedicale.Beans.Posologie;

@Repository
public interface PosologieRepository extends CrudRepository<Posologie, Integer> {
	

	  List<Posologie> findByValide(Integer valide);
}