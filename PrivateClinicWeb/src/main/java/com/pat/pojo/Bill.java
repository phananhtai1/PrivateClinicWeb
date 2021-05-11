/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */

@Entity
@Table(name = "bill")
public class Bill implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private BigDecimal charge;
    
    @Column(name = "medicine_cost")
    private BigDecimal medicineCost;
    
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    
    @ManyToOne
    @JoinColumn(name = "medical_form_id")
    private MedicalForm medicalForm;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the charge
     */
    public BigDecimal getCharge() {
        return charge;
    }

    /**
     * @param charge the charge to set
     */
    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    /**
     * @return the medicineCost
     */
    public BigDecimal getMedicineCost() {
        return medicineCost;
    }

    /**
     * @param medicineCost the medicineCost to set
     */
    public void setMedicineCost(BigDecimal medicineCost) {
        this.medicineCost = medicineCost;
    }

    /**
     * @return the totalAmount
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount the totalAmount to set
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return the medicalForm
     */
    public MedicalForm getMedicalForm() {
        return medicalForm;
    }

    /**
     * @param medicalForm the medicalForm to set
     */
    public void setMedicalForm(MedicalForm medicalForm) {
        this.medicalForm = medicalForm;
    }
    
    
}
