package com.pat.formatter;


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
public class PatientFormatter implements Formatter<Patient> {

    @Override
    public String print(Patient t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Patient parse(String string, Locale locale) throws ParseException {
        Patient pa = new Patient();
        pa.setId(Integer.parseInt(string));
        return pa;
    }
    
}
