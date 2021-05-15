/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.service;

import com.pat.pojo.MedicalForm;
import com.pat.pojo.Prescription;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface BillService {
    List<Object[]> getBills(Date fromDate, Date toDate);
    List<Object[]> getBillById(int billId);
    List<Object[]> getBillStatsByDate(Date fromDate, Date toDate);
    List<Object[]> getBillStatsByMonth(int fm, int tm);
    boolean deleteBill(int billId);
}
