/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Administrator
 */
@Controller
@ControllerAdvice
public class HomeControllers {
    @RequestMapping("/") //mapping vao trang chu
    public String index(Model model){

        return "index";
    }
    @RequestMapping("/admin") //mapping vao trang chu
    public String indexAdmin(Model model){

        return "indexAdmin";
    }
}
