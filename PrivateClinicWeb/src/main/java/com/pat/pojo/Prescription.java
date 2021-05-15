/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "prescription")
public class Prescription implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id")
    private int id;
    private int quantity;
    @Column(name = "[usage]")
    private String usage;
    
    @ManyToOne
    @JoinColumn(name = "medical_form_id")
    private MedicalForm medicalForm;
    
    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;
    
    @Override
    public String toString() {
        return String.valueOf(id);
    }
    

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the usage
     */
    public String getUsage() {
        return usage;
    }

    /**
     * @param usage the usage to set
     */
    public void setUsage(String usage) {
        this.usage = usage;
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

    /**
     * @return the medicine
     */
    public Medicine getMedicine() {
        return medicine;
    }

    /**
     * @param medicine the medicine to set
     */
    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

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

    
}
