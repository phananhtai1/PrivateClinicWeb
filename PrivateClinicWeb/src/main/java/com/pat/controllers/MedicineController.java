/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.controllers;

import com.pat.pojo.Medicine;
import com.pat.service.MedicineService;
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
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @RequestMapping("/medicine") //mapping vao trang chu
    public String medicine(Model model, @RequestParam(name = "kw", required = false) String name) {

        if (name != null) {
            model.addAttribute("medicine", this.medicineService.getMedicines(name));
        } else {
            model.addAttribute("medicine", this.medicineService.getMedicines(""));
        }

        return "medicine";
    }

    @RequestMapping("/medicine/addMedi")
    public String addView(Model model) {
        model.addAttribute("addmedi", new Medicine());
        return "addMedi";
    }

    @RequestMapping("/medicine/updateMedi")
    public String updateView(Model model,
            @RequestParam(name = "mediId", required = false, defaultValue = "0") int id) {
        if (id > 0) {
            model.addAttribute("updateMedi", this.medicineService.getMedicineId(id));
        } else {
            return "redirect:/medicine";
        }
        return "updateMedi";
    }

    @PostMapping("/medicine/addMedi/add")
    public String addMedi(Model model,
            @ModelAttribute(value = "addmedi") @Valid Medicine me,
            BindingResult result) {
        if (result.hasErrors()) {
            return "addMedi";
        }

        if (!this.medicineService.addOrUpdateMedicine(me)) {
            model.addAttribute("erroMsg", "Something Wrong!!!");
            return "addMedi";
        }

        return "redirect:/medicine";
    }

    @PostMapping("/medicine/updateMedi/update")
    public String updateMedi(Model model,
            @ModelAttribute(value = "updateMedi") @Valid Medicine me,
            BindingResult result) {
        if (result.hasErrors()) {
            return "updateMedi";
        }

        if (!this.medicineService.addOrUpdateMedicine(me)) {
            model.addAttribute("erroMsg", "Something Wrong!!!");
            return "updateMedi";
        }

        return "redirect:/medicine";
    }
}
