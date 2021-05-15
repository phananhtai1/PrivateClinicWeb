/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.controllers;

import com.pat.pojo.Employee;
import com.pat.service.EmployeeService;
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
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    
    
    @RequestMapping("/admin/employee")
    public String viewEmployee(Model model, @RequestParam(name ="kw", required = false) String kw){
        if(kw != null){
            model.addAttribute("employee", this.employeeService.getEmployees(kw));
        }else{
            model.addAttribute("employee", this.employeeService.getEmployees(""));
        }
        return "employee";
    }
    
    @RequestMapping("/admin/employee/addEmployee")
    public String addView(Model model){
        model.addAttribute("addEmployee", new Employee());
        return "addEmployee";
    }
    
    @RequestMapping("/admin/employee/updateEmployee")
    public String updateView(Model model,
            @RequestParam(name = "employeeId", required = false, defaultValue = "0") int id){
        if(id > 0){
            model.addAttribute("updateEmployee", this.employeeService.getEmployeeId(id));
        }else{
            return "redirect:/employee";
        }
        return "updateEmployee";
    }
    
    @PostMapping("/admin/employee/addEmployee")
    public String addEmployee(Model model,
            @ModelAttribute(value = "addEmployee") @Valid Employee pa,
            BindingResult result){
        if(result.hasErrors()){
            return "addEmployee";
        }
        if(!this.employeeService.addOrUpdateEmployee(pa)){
            model.addAttribute("erroMsg", "Something Wrong!!!");
            return "addEmployee";
        }
        
        return "redirect:/admin/employee";
    }
    
    @PostMapping("/admin/employee/updateEmployee")
    public String updateEmployee(Model model,
            @ModelAttribute(value = "updateEmployee") @Valid Employee pa,
            BindingResult result){
        if(result.hasErrors()){
            return "updateEmployee";
        }
        if(!this.employeeService.addOrUpdateEmployee(pa)){
            model.addAttribute("erroMsg", "Something Wrong!!!");
            return "updateEmployee";
        }
        
        return "redirect:/admin/employee";
    }
    
}
