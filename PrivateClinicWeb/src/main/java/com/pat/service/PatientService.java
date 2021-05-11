/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.service;

import com.pat.pojo.Patient;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface PatientService {
    List<Patient> getPatients(String kw);
    Patient getPatientId(int id);
    boolean addOrUpdatePatient(Patient p);
    boolean deletePatient(int patientId);
}
