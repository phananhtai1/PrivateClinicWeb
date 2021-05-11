/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.controllers;

import com.pat.pojo.MedicalForm;
import com.pat.pojo.Patient;
import com.pat.service.EmployeeService;
import com.pat.service.MedicalFormService;
import com.pat.service.PatientService;
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
public class MedicalFormController {

    @Autowired
    private MedicalFormService medicalFormService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/medicalForm")
    public String viewMedicalForm(Model model, @RequestParam(name = "kw", required = false) String kw) {
        if (kw != null) {
            List<Object[]> medicalForms = this.medicalFormService.getMedicalForms(kw);
            model.addAttribute("medicalForm", medicalForms);
        } else {
            List<Object[]> medicalForms = this.medicalFormService.getMedicalForms("");
            model.addAttribute("medicalForm", medicalForms);
        }
        return "medicalForm";
    }

    @RequestMapping("/medicalForm/addMedicalForm")
    public String addView(Model model) {
        model.addAttribute("patient", this.patientService.getPatients(""));
        model.addAttribute("employee", this.employeeService.getEmployees(""));
        model.addAttribute("addMedicalForm", new MedicalForm());
        return "addMedicalForm";
    }

    @RequestMapping("/medicalForm/updateMedicalForm")
    public String updateView(Model model,
            @RequestParam(name = "medicalFormId", required = false, defaultValue = "0") int id) {
        if (id > 0) {
            model.addAttribute("updateMedicalForm", this.medicalFormService.getMedicalFormId(id));
        } else {
            return "redirect:/medicalForm";
        }
        return "updateMedicalForm";
    }

    @PostMapping("/medicalForm/addMedicalForm/add")
    public String addMedicalForm(Model model,
            @ModelAttribute(value = "addMedicalForm") @Valid MedicalForm pa,
            BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("patient", this.patientService.getPatients(""));
            model.addAttribute("employee", this.employeeService.getEmployees(""));
            return "addMedicalForm";
        }
        if (!this.medicalFormService.addOrUpdateMedicalForm(pa)) {
            model.addAttribute("erroMsg", "Something Wrong!!!");
            model.addAttribute("patient", this.patientService.getPatients(""));
            model.addAttribute("employee", this.employeeService.getEmployees(""));
            return "addMedicalForm";
        }

        return "redirect:/medicalForm";
    }

    @PostMapping("/medicalForm/updateMedicalForm/update")
    public String updateMedicalForm(Model model,
            @ModelAttribute(value = "updateMedicalForm") @Valid MedicalForm pa,
            BindingResult result) {
        if (result.hasErrors()) {
            return "updateMedicalForm";
        }
        if (!this.medicalFormService.addOrUpdateMedicalForm(pa)) {
            model.addAttribute("erroMsg", "Something Wrong!!!");
            return "updateMedicalForm";
        }

        return "redirect:/medicalForm";
    }

}
