/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.repository;

import com.pat.pojo.Medicine;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface MedicineRepository {
    List<Medicine> getMedicines(String kw);
    Medicine getMedicineId(int id);
    boolean addOrUpdateMedicine(Medicine me);
    boolean deleteMedicine(int medicineId);
}
