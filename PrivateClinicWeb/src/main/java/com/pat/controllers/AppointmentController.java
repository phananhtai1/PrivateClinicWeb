/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.controllers;

import com.pat.pojo.Appointment;
import com.pat.service.AppointmentService;
import com.pat.service.PatientService;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    
    @Autowired
    private PatientService patientService;
    
    @Autowired
    private SimpleDateFormat simpleDateFormat;
    
    
    @RequestMapping("/appointment")
    public String viewAppointment(Model model,
            @RequestParam(name = "fromDate", required = false) String fromDate,
            @RequestParam(name = "toDate", required = false) String toDate) {
        
        Date fr = null, to = null;
        try {
            fr = this.simpleDateFormat.parse(fromDate);
            to = this.simpleDateFormat.parse(toDate);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        List<Object[]> appointments = this.appointmentService.getAppointments(fr, to);
        model.addAttribute("appointment", appointments);
        
        return "appointment";
    }
    
    @RequestMapping("/appointment/addAppointment")
    public String addView(Model model){
        model.addAttribute("patient", this.patientService.getPatients(""));
        model.addAttribute("addAppointment", new Appointment());
        return "addAppointment";
    }
    
    @RequestMapping("/appointment/updateAppointment")
    public String updateView(Model model,
            @RequestParam(name = "appointmentId", required = false, defaultValue = "0") int id){
        if(id > 0){
            model.addAttribute("patient", this.patientService.getPatients(""));
            model.addAttribute("updateAppointment", this.appointmentService.getAppointmentId(id));
        }else{
            return "redirect:/appointment";
        }
        return "updateAppointment";
    }
    
    @PostMapping("/appointment/addAppointment/add")
    public String addAppointment(Model model,
            @ModelAttribute(value = "addAppointment") @Valid Appointment pa,
            BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("patient", this.patientService.getPatients(""));
            return "addAppointment";
        }
        if(!this.appointmentService.addOrUpdateAppointment(pa)){
            model.addAttribute("patient", this.patientService.getPatients(""));
            model.addAttribute("erroMsg", "Something Wrong!!!");
            return "addAppointment";
        }
        
        return "redirect:/appointment";
    }
    
    @PostMapping("/appointment/updateAppointment/update")
    public String updateAppointment(Model model,
            @ModelAttribute(value = "updateAppointment") @Valid Appointment pa,
            BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("patient", this.patientService.getPatients(""));
            return "updateAppointment";
        }
        if(!this.appointmentService.addOrUpdateAppointment(pa)){
            model.addAttribute("patient", this.patientService.getPatients(""));
            model.addAttribute("erroMsg", "Something Wrong!!!");
            return "updateAppointment";
        }
        
        return "redirect:/appointment";
    }
    
}
