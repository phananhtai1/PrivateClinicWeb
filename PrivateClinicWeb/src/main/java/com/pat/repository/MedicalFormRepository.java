/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.repository;

import com.pat.pojo.MedicalForm;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface MedicalFormRepository {
    List<Object[]> getMedicalForms(Date fromDate, Date toDate);
    MedicalForm getMedicalFormId(int id);
    boolean addOrUpdateMedicalForm(MedicalForm mf);
    boolean deleteMedicalForm(int medicalFormId);
    List<MedicalForm> getMedicalForm();
    List<Object[]> getInfoPatientByMFId(int id);
    List<Object[]> getPatientByDate(Date fromDate, Date toDate);
    
}
