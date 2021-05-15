/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.controllers;

import com.pat.pojo.Prescription;
import com.pat.service.MedicalFormService;
import com.pat.service.MedicineService;
import com.pat.service.PrescriptionService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Administrator
 */
@Controller
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private MedicalFormService medicalFormService;

    @Autowired
    private MedicineService medicineService;

    @RequestMapping("/admin/prescription")
    public String viewPrescription(Model model) {
        List<Object[]> prescriptions = this.prescriptionService.getPrescriptions();
        model.addAttribute("prescription", prescriptions);
        return "prescription";
    }

    @RequestMapping("/admin/prescription/addPrescription")
    public String addView(Model model,
            @RequestParam(name = "medicalFormId", required = false, defaultValue = "0") int mfId) {
        if(mfId > 0){
            model.addAttribute("infoPatient", this.medicalFormService.getInfoPatientByMFId(mfId));
        }else{
            model.addAttribute("medicalForm", this.medicalFormService.getMedicalForm());
        }
        
        model.addAttribute("medicine", this.medicineService.getMedicines(""));
        model.addAttribute("addPrescription", new Prescription());
        return "addPrescription";
    }

    @PostMapping("/admin/prescription/addPrescription")
    public String addPrescription(Model model,
            @RequestParam(name = "medicalFormId", required = false, defaultValue = "0") int mfId,
            @ModelAttribute(value = "addPrescription") @Valid Prescription pr,
            BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("medicine", this.medicineService.getMedicines(""));
            model.addAttribute("medicalForm", this.medicalFormService.getMedicalForm());
            return "addPrescription";    
        }
        if (!this.prescriptionService.addOrUpdatePrescription(pr)) {
            model.addAttribute("erroMsg", "Something Wrong!!!");
            model.addAttribute("medicine", this.medicineService.getMedicines(""));
            model.addAttribute("medicalForm", this.medicalFormService.getMedicalForm());
            return "addPrescription";    
        }
        return "redirect:/admin/prescription";
    }

}
