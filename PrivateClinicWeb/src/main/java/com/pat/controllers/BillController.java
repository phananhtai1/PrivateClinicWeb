/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.controllers;

import com.pat.pojo.MedicalForm;
import com.pat.pojo.Prescription;
import com.pat.service.BillService;
import com.pat.service.MedicalFormService;
import com.pat.service.MedicineService;
import com.pat.service.PrescriptionService;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Administrator
 */
@Controller
public class BillController {

    @Autowired
    private BillService billService;

    @Autowired
    private MedicalFormService medicalFormService;

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private SimpleDateFormat simpleDateFormat;

    @RequestMapping("/admin/billStats")
    public String bllStats(Model model,
            @RequestParam(name = "fromDate", required = false) String fromDate,
            @RequestParam(name = "toDate", required = false) String toDate) {

        Date fr = null, to = null;
        try {
            fr = this.simpleDateFormat.parse(fromDate);
            to = this.simpleDateFormat.parse(toDate);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        
        List<Object[]> statsByDate = this.billService.getBillStatsByDate(fr, to);
        List<BigDecimal> amounts = new ArrayList<>();
        List<Date> labelDate = new ArrayList<>();
        for (Object[] d : statsByDate) {
            amounts.add((BigDecimal) d[2]);
        }

        for (Object[] b : statsByDate) {
            labelDate.add((Date) b[0]);
        }

        model.addAttribute("amounts", amounts);
        model.addAttribute("statsByDate", statsByDate);
        model.addAttribute("labelDate", labelDate);
        return "billStats";
    }

    @RequestMapping("/admin/billStatsMonth")
    public String patientStats(Model model,
            @RequestParam(name = "fromMonth", required = false, defaultValue = "0") int fromMonth,
            @RequestParam(name = "toMonth", required = false, defaultValue = "0") int toMonth) {

        List<Object[]> billStatsMonth = this.billService.getBillStatsByMonth(fromMonth, toMonth);
        List<BigDecimal> amounts = new ArrayList<>();
        List<Integer> labelMonth = new ArrayList<>();
        
        for (Object[] d : billStatsMonth) {
            amounts.add((BigDecimal) d[2]);
        }
        
        for (Object[] b : billStatsMonth) {
            labelMonth.add((Integer) b[0]);
        }
        model.addAttribute("dataStats", billStatsMonth);
        model.addAttribute("amounts", amounts);
        model.addAttribute("labelMonth", labelMonth);

        return "billStatsMonth";
    }

    @RequestMapping("/admin/bill")
    public String viewBill(Model model,
            @RequestParam(name = "fromDate", required = false) String fromDate,
            @RequestParam(name = "toDate", required = false) String toDate) {

        Date fr = null, to = null;
        try {
            fr = this.simpleDateFormat.parse(fromDate);
            to = this.simpleDateFormat.parse(toDate);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        List<Object[]> bills = this.billService.getBills(fr, to);
        model.addAttribute("bills", bills);
        return "bill";
    }

    @RequestMapping("/admin/bill/billDetail")
    public String viewBillDetail(Model model,
            @RequestParam(name = "billId", required = false) int billId,
            @RequestParam(name = "mfId", required = false) int mfId) {

        model.addAttribute("infoPatient", this.medicalFormService.getInfoPatientByMFId(mfId));
        model.addAttribute("infoPrescription", this.prescriptionService.getInfoPrescriptionByMFId(mfId));
        model.addAttribute("infoBill", this.billService.getBillById(billId));

        return "billDetail";
    }

}
