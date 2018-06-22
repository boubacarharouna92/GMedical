package com.stageUTI.GestionMedicale.Controller;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.stageUTI.GestionMedicale.Beans.Chambre;
import com.stageUTI.GestionMedicale.Beans.Consultation;
import com.stageUTI.GestionMedicale.Beans.Hospitalisation;
import com.stageUTI.GestionMedicale.Beans.Consultation;
import com.stageUTI.GestionMedicale.Beans.Patient;
import com.stageUTI.GestionMedicale.BeansForm.ChambreForm;
import com.stageUTI.GestionMedicale.BeansForm.ConsultForm;
import com.stageUTI.GestionMedicale.BeansForm.HospitalisationForm;
import com.stageUTI.GestionMedicale.Repository.HospitalisationRepository;
import com.stageUTI.GestionMedicale.BeansForm.ConsultForm;


@Controller
public class HospitalisationController {


    @Resource
    private HospitalisationRepository hospitalisation_service;


    @GetMapping("/AjouterHospitalisation")
    public String AjouterHospitalisation() {
        return "Hospitalisation/AjouterHospitalisation";
    }

    @PostMapping("/AjouterHospitalisation")
    public String ClasseSubmit(@Valid HospitalisationForm form, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {

            Date dateHospitalisation = form.getDateHospitalisation();
            Date dateSorti = form.getDateSorti();
            String motif = form.getMotif();

            try {
                Hospitalisation hospitalisation = new Hospitalisation(dateHospitalisation, dateSorti, motif);

                hospitalisation_service.save(hospitalisation);

            } catch (Exception e) {

            }
        } else {


        }

        return "Hospitalisation/AjouterHospitalisation";

    }

    /* Liste des hospitalisation*/

    @GetMapping("/listeHospitalisation")
    public String hospitalisation_servicehowRegion(Model model) {
        try {
            List<Hospitalisation> hospitalisations = (List<Hospitalisation>) hospitalisation_service.findByValide(1);
            model.addAttribute("hospitalisations", hospitalisations);
        } catch (Exception e) {

        }
        return "Hospitalisation/listeHospitalisation";
    }

    @GetMapping("/editerHospitalisation/{id}")
    public String showediterHospitalisation(HospitalisationForm form, @PathVariable("id") Integer id, Model model) {
        model.addAttribute("form", form);
        try {
            List<Hospitalisation> hospitalisations = (List<Hospitalisation>) hospitalisation_service.findByValide(1);
            model.addAttribute("hospitalisations", hospitalisations);
            Hospitalisation hospitalisation = (hospitalisation_service.findById(id)).get();
            model.addAttribute("hospitalisation", hospitalisation);
            model.addAttribute("id_hospitalisation", id);
        } catch (Exception e) {

        }
        return "Hospitalisation/editerHospitalisation";

    }

    @PostMapping("/editerHospitalisation/{id}")
    public String HospitalisationRegionSubmit(@Valid HospitalisationForm form, BindingResult bindingResult, @PathVariable("id") Integer id, Model model) {
        //if (!bindingResult.hasErrors())
        if (true) {
            Date dateHospitalisation = form.getDateHospitalisation();
            Date dateSorti = form.getDateSorti();
            String motif = form.getMotif();


            try {
                Hospitalisation hospitalisation = (hospitalisation_service.findById(id)).get();
                hospitalisation.setDateHospitalisation(dateHospitalisation);
                hospitalisation.setDateSorti(dateSorti);
                hospitalisation.setMotif(motif);

                hospitalisation_service.save(hospitalisation);
                List<Hospitalisation> hospitalisations = (List<Hospitalisation>) hospitalisation_service.findByValide(1);
                model.addAttribute("hospitalisations", hospitalisations);
            } catch (Exception e) {

            }
        } else {
            try {
                List<Hospitalisation> hospitalisations = (List<Hospitalisation>) hospitalisation_service.findByValide(1);
                model.addAttribute("hospitalisations", hospitalisations);


            } catch (Exception e) {

            }

        }

        return "Hospitalisation/listeHospitalisation";

    }

    @GetMapping("/deleteHosp/{id}")
    public String showdeleteHosp(HospitalisationForm form, @PathVariable("id") Integer id, Model model) {
        model.addAttribute("form", form);
        try {
            Hospitalisation hospitalisation = (hospitalisation_service.findById(id)).get();
            hospitalisation.setValide(0);
            hospitalisation_service.save(hospitalisation);

            List<Hospitalisation> hospitalisations = (List<Hospitalisation>) hospitalisation_service.findByValide(1);
            model.addAttribute("hospitalisations", hospitalisations);

        } catch (Exception e) {

        }
        return "Hospitalisation/listeHospitalisation";

    }
}
