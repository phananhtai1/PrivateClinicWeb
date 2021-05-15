/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.controllers;

import com.pat.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
public class ApiPatientController {
    
    @Autowired
    private PatientService patientService;
    
    @DeleteMapping("/admin/patient/{patientId}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePatient(@PathVariable(name = "patientId") int patientId){
        this.patientService.deletePatient(patientId);
    }
}
