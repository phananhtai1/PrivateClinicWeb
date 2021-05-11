/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.service.impl;

import com.pat.pojo.Patient;
import com.pat.repository.PatientRepository;
import com.pat.service.PatientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    private PatientRepository patientRepository;
    
    @Override
    public List<Patient> getPatients(String kw) {
        return this.patientRepository.getPatients(kw);
    }

    @Override
    public Patient getPatientId(int id) {
        return this.patientRepository.getPatientId(id);
    }

    @Override
    public boolean addOrUpdatePatient(Patient p) {
        return this.patientRepository.addOrUpdatePatient(p);
    }

    @Override
    public boolean deletePatient(int patientId) {
        return this.patientRepository.deletePatient(patientId);
    }
    
}
