package com.stageUTI.GestionMedicale.BeansForm;

import javax.persistence.ManyToOne;

import com.stageUTI.GestionMedicale.Beans.Consultation;
import com.stageUTI.GestionMedicale.Beans.Parametre;

public class mesure_parametreForm {
	
	 
		private Integer valeur; 
				
		
		public mesure_parametreForm(Integer valeur) {
			
			this.valeur = valeur;
		}

		public mesure_parametreForm() {
			
		}
		public Integer getValeur() {
			return valeur;
		}

		public void setValeur(Integer valeur) {
			this.valeur = valeur;
		}

		
		
		
		
		


}
