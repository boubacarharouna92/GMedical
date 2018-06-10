package com.stageUTI.GestionMedicale.Beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName; 
    private String lastName; 
    private String email; 
    private Date dateNaissance; 
    private String lieuNaissance; 
    private String telephone;


}
