/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.repository;

import com.pat.pojo.MedicalForm;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface MedicalFormRepository {
    List<Object[]> getMedicalForms(String kw);
    MedicalForm getMedicalFormId(int id);
    boolean addOrUpdateMedicalForm(MedicalForm mf);
    boolean deleteMedicalForm(int medicalFormId);
}
