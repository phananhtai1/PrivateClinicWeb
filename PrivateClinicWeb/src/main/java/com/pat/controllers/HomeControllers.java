/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.controllers;

import com.pat.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Administrator
 */
@Controller
public class HomeControllers {
    @Autowired
    private MedicineService medicineService;
    
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("message", "Wellcome to our website");
        model.addAttribute("medicines", this.medicineService.getMedicines());
        
        return "index";
    }
}
