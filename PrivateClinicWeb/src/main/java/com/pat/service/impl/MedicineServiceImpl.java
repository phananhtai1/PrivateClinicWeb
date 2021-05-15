/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.service.impl;

import com.pat.pojo.Medicine;
import com.pat.repository.MedicineRepository;
import com.pat.service.MedicineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class MedicineServiceImpl implements MedicineService{
    @Autowired
    private MedicineRepository medicineRepository;
    

    @Override
    public List<Medicine> getMedicines(String kw) {
        return this.medicineRepository.getMedicines(kw);
    }

    @Override
    public Medicine getMedicineId(int i) {
        return this.medicineRepository.getMedicineId(i);
    }

    @Override
    public boolean addOrUpdateMedicine(Medicine me) {
        return this.medicineRepository.addOrUpdateMedicine(me);
    }

    @Override
    public boolean deleteMedicine(int medicineId) {
        return this.medicineRepository.deleteMedicine(medicineId);
    }

    
}
