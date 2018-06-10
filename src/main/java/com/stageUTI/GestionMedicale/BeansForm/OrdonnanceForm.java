package com.stageUTI.GestionMedicale.BeansForm;

import java.util.Date;

public class OrdonnanceForm {

	private Date dateOrd;

	public OrdonnanceForm(Date dateOrd) {
		
		this.dateOrd = dateOrd;
	}

	public OrdonnanceForm() {
		
		// TODO Auto-generated constructor stub
	}

	public Date getDateOrd() {
		return dateOrd;
	}

	public void setDateOrd(Date dateOrd) {
		this.dateOrd = dateOrd;
	}
	
}
