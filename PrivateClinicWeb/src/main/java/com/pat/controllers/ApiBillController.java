/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.controllers;

import com.pat.service.BillService;
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
public class ApiBillController {
    @Autowired
    private BillService billService;
    
    @DeleteMapping("/admin/bill/{billId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBill(@PathVariable(name = "billId") int billId){
        this.billService.deleteBill(billId);
    }
}
