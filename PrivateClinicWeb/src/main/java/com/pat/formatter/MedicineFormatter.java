package com.pat.formatter;

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
public class MedicineFormatter implements Formatter<Medicine> {

    @Override
    public String print(Medicine t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Medicine parse(String string, Locale locale) throws ParseException {
        Medicine medi = new Medicine();
        medi.setId(Integer.parseInt(string));
        return medi;
    }
    
}
