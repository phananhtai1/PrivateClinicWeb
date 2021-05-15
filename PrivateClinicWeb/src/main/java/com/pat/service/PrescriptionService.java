/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.service;

import com.pat.pojo.MedicalForm;
import com.pat.pojo.Prescription;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface PrescriptionService {
    List<Object[]> getPrescriptions();
    Prescription getPrescriptionId(int id);
    boolean addOrUpdatePrescription(Prescription pr);
    boolean deletePrescription(int prescriptionId);
    List<Object[]> getInfoPrescriptionByMFId(int mfId);
//    List<Object[]> getInfoPatientByMFId(int id);
}
