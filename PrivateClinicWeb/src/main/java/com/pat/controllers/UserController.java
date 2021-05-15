/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.controllers;

import com.pat.pojo.User;
import com.pat.service.EmployeeService;
import com.pat.service.UserService;
import com.pat.vadilator.WebValidator;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Administrator
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private WebValidator userValidator;
    @Autowired
    private EmployeeService employeeService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(userValidator);
    }

    @GetMapping(value = "/admin/login")
    public String loginView(Model model) {
//        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping(value = "/admin/register")
    public String registerView(Model model) {
        model.addAttribute("employee", this.employeeService.getEmployees(""));
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping(value = "/admin/register")
    public String registerProcess(Model model,
            @ModelAttribute(name = "user") @Valid User user,
            BindingResult result) {
        user.setUserRole("ROLE_USER");
        if (result.hasErrors()) {
            model.addAttribute("employee", this.employeeService.getEmployees(""));
            return "register";
        }
        if (!this.userService.addUser(user)) {
            model.addAttribute("employee", this.employeeService.getEmployees(""));
            model.addAttribute("errMsg", "Something Wrong!");
            return "register";
        }
        return "redirect:/admin/login";
    }
}
