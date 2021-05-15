/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.controllers;

import com.pat.pojo.Patient;
import com.pat.service.PatientService;
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
public class PatientController {
    @Autowired
    private PatientService patientService;
    
    
    @RequestMapping("/admin/patient")
    public String viewPatient(Model model, @RequestParam(name ="kw", required = false) String kw){
        if(kw != null){
            model.addAttribute("patient", this.patientService.getPatients(kw));
        }else{
            model.addAttribute("patient", this.patientService.getPatients(""));
        }
        return "patient";
    }
    
    @RequestMapping("/admin/patient/addPatient")
    public String addView(Model model){
        model.addAttribute("addPatient", new Patient());
        return "addPatient";
    }
    
    @RequestMapping("/admin/patient/updatePatient")
    public String updateView(Model model,
            @RequestParam(name = "patientId", required = false, defaultValue = "0") String id){
        if(id != null){
            model.addAttribute("updatePatient", this.patientService.getPatientId(Integer.parseInt(id)));
        }else{
            return "redirect:/admin/patient";
        }
        return "updatePatient";
    }
    
    @PostMapping("/admin/patient/addPatient")
    public String addPatient(Model model,
            @ModelAttribute(value = "addPatient") @Valid Patient pa,
            BindingResult result){
        if(result.hasErrors()){
            return "addPatient";
        }
        if(!this.patientService.addOrUpdatePatient(pa)){
            model.addAttribute("erroMsg", "Something Wrong!!!");
            return "addPatient";
        }
        
        return "redirect:/admin/patient";
    }
    
    @PostMapping("/admin/patient/updatePatient")
    public String updatePatient(Model model,
            @ModelAttribute(value = "updatePatient") @Valid Patient pa,
            BindingResult result){
        if(result.hasErrors()){
            return "updatePatient";
        }
        if(!this.patientService.addOrUpdatePatient(pa)){
            model.addAttribute("erroMsg", "Something Wrong!!!");
            return "updatePatient";
        }
        
        return "redirect:/admin/patient";
    }
    
}
