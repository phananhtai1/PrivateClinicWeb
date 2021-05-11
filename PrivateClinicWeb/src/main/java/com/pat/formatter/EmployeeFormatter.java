package com.pat.formatter;


import com.pat.pojo.Employee;
import com.pat.pojo.Patient;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
@Component
public class EmployeeFormatter implements Formatter<Employee> {

    @Override
    public String print(Employee em, Locale locale) {
        return String.valueOf(em.getId());
    }

    @Override
    public Employee parse(String string, Locale locale) throws ParseException {
        Employee em = new Employee();
        em.setId(Integer.parseInt(string));
        return em;
    }
    
}
