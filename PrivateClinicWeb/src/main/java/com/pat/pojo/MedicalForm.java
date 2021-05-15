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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Administrator
 */

@Entity
@Table(name = "medical_form")
public class MedicalForm implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    
    @NotEmpty(message = "{medicalForm.symptom.error.notNullMsg}")
    private String symptom;
    
    @Column(name = "examination_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{medicalForm.examinationDate.error.notNullMsg}")
    private Date examinationDate;
    
    @NotEmpty(message = "{medicalForm.diagnostic.error.notNullMsg}")
    private String diagnostic;
    
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    
    @Override
    public String toString() {
        return String.valueOf(id);
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

    /**
     * @return the symptom
     */
    public String getSymptom() {
        return symptom;
    }

    /**
     * @param symptom the symptom to set
     */
    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    /**
     * @return the examinationDate
     */
    public Date getExaminationDate() {
        return examinationDate;
    }

    /**
     * @param examinationDate the examinationDate to set
     */
    public void setExaminationDate(Date examinationDate) {
        this.examinationDate = examinationDate;
    }

    /**
     * @return the diagnostic
     */
    public String getDiagnostic() {
        return diagnostic;
    }

    /**
     * @param diagnostic the diagnostic to set
     */
    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    /**
     * @return the patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * @param patient the patient to set
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    
}
