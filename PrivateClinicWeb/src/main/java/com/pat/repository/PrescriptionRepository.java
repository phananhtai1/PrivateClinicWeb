/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.repository;


import com.pat.pojo.Prescription;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface PrescriptionRepository {
    List<Object[]> getPrescriptions();
    Prescription getPrescriptionId(int id);
    boolean addOrUpdatePrescription(Prescription pr);
    boolean deletePrescription(int prescriptionId);
    List<Object[]> getInfoPrescriptionByMFId(int id);
//    List<Object[]> getInfoPatientByMFId(int id);
}
