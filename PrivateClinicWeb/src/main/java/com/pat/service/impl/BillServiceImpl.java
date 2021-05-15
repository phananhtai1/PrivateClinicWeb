/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.service.impl;

import com.pat.pojo.Prescription;
import com.pat.repository.BillRepository;
import com.pat.service.BillService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class BillServiceImpl implements BillService{
    @Autowired
    private BillRepository billRepository;
    
    @Override
    public List<Object[]> getBills(Date fromDate, Date toDate) {
        return this.billRepository.getBills(fromDate, toDate);
    }

    @Override
    public List<Object[]> getBillById(int billId) {
        return this.billRepository.getBillById(billId);
    }

    @Override
    public List<Object[]> getBillStatsByDate(Date fd, Date td) {
        return this.billRepository.getBillStatsByDate(fd, td);
    }

    @Override
    public List<Object[]> getBillStatsByMonth(int fm, int tm) {
        return this.billRepository.getBillStatsByMonth(fm, tm);
    }

    @Override
    public boolean deleteBill(int i) {
       return this.billRepository.deleteBill(i);
    }

}
