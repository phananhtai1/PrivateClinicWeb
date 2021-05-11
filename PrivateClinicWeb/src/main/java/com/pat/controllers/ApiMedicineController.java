/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.controllers;

import com.pat.service.MedicineService;
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
public class ApiMedicineController {
    @Autowired
    private MedicineService medicineService;
    
    @DeleteMapping("/medicine/{medicineId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMedicine(@PathVariable(name = "medicineId") int medicineId) {
        this.medicineService.deleteMedicine(medicineId);
    }
    
}
