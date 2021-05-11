/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.service.impl;

import com.pat.pojo.MedicalForm;
import com.pat.pojo.Patient;
import com.pat.repository.MedicalFormRepository;
import com.pat.repository.PatientRepository;
import com.pat.service.MedicalFormService;
import com.pat.service.PatientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class MedicalFormServiceImpl implements MedicalFormService{
    @Autowired
    private MedicalFormRepository medicalFormRepository;
    
    @Override
    public List<Object[]> getMedicalForms(String kw) {
        return this.medicalFormRepository.getMedicalForms(kw);
    }

    @Override
    public MedicalForm getMedicalFormId(int id) {
        return this.medicalFormRepository.getMedicalFormId(id);
    }

    @Override
    public boolean addOrUpdateMedicalForm(MedicalForm p) {
        return this.medicalFormRepository.addOrUpdateMedicalForm(p);
    }

    @Override
    public boolean deleteMedicalForm(int medicalFormId) {
        return this.medicalFormRepository.deleteMedicalForm(medicalFormId);
    }
    
}
