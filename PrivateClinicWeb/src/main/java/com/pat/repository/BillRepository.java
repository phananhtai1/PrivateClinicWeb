/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.repository;


import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface BillRepository {
    List<Object[]> getBills(Date fromDate, Date toDate);
    List<Object[]> getBillById(int billId);
    List<Object[]> getBillStatsByDate(Date fromDate, Date toDate);
    List<Object[]> getBillStatsByMonth(int FromMonth, int toMonth);
    boolean deleteBill(int billId);
}
