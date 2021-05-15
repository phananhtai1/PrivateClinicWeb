package com.pat.formatter;


import com.pat.pojo.Prescription;
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
public class PrescriptionFormatter implements Formatter<Prescription> {

    @Override
    public String print(Prescription pres, Locale locale) {
        return String.valueOf(pres.getId());
    }

    @Override
    public Prescription parse(String string, Locale locale) throws ParseException {
        Prescription pres = new Prescription();
        pres.setId(Integer.parseInt(string));
        return pres;
    }
    
}
