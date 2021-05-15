/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.service.impl;

import com.pat.pojo.Prescription;
import com.pat.repository.PrescriptionRepository;
import com.pat.service.PrescriptionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class PrescriptionServiceImpl implements PrescriptionService{
    @Autowired
    private PrescriptionRepository prescriptionRepository;
    
    @Override
    public List<Object[]> getPrescriptions() {
        return this.prescriptionRepository.getPrescriptions();
    }

    @Override
    public Prescription getPrescriptionId(int id) {
        return this.prescriptionRepository.getPrescriptionId(id);
    }


    @Override
    public boolean deletePrescription(int prescriptionId) {
        return this.prescriptionRepository.deletePrescription(prescriptionId);
    }

    @Override
    public boolean addOrUpdatePrescription(Prescription pr) {
        return this.prescriptionRepository.addOrUpdatePrescription(pr);
    }

    @Override
    public List<Object[]> getInfoPrescriptionByMFId(int mfId) {
        return this.prescriptionRepository.getInfoPrescriptionByMFId(mfId);
    }
    
}
