package com.pat.formatter;

import com.pat.pojo.MedicalForm;
import com.pat.pojo.Medicine;
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
public class MedicalFormFormatter implements Formatter<MedicalForm> {

    @Override
    public String print(MedicalForm mf, Locale locale) {
        return String.valueOf(mf.getId());
    }

    @Override
    public MedicalForm parse(String string, Locale locale) throws ParseException {
        MedicalForm mf = new MedicalForm();
        mf.setId(Integer.parseInt(string));
        return mf;
    }
    
}
