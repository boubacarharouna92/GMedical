package com.stageUTI.GestionMedicale.Repository;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stageUTI.GestionMedicale.Beans.RDV;

@Repository
public interface RDVRepository extends CrudRepository<RDV, Integer> {

  List<RDV> findByValide(Integer valide);
  
  
}