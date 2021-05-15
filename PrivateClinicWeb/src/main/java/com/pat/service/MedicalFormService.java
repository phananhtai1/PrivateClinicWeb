/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.service;

import com.pat.pojo.MedicalForm;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface MedicalFormService {
    List<Object[]> getMedicalForms(Date fromDate, Date toDate);
    MedicalForm getMedicalFormId(int id);
    boolean addOrUpdateMedicalForm(MedicalForm mf);
    boolean deleteMedicalForm(int medicalFormId);
    List<Object[]> getInfoPatientByMFId(int id);
    List<MedicalForm> getMedicalForm();
    List<Object[]> getPatientByDate(Date fromDate, Date toDate);
}
