package com.stageUTI.GestionMedicale.Beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medecin")
public class Medecin {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

}
