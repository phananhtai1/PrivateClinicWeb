/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "patient")
public class Patient implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Size(min = 4, max = 45, message = "{patient.fullname.error.sizeMsg}")
    private String fullname;
    
    @Pattern(regexp = "\\d{10}", message = "{patient.phone.error.invalidMsg}")
    private String phone;
    
     @NotEmpty(message = "{patient.address.error.notNullMsg}")
    private String address;
     
     
    private String sex;
    
    
    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{patient.birthDate.error.notNullMsg}")
    private Date birthDate;
    
    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private List<Appointment> appointments;
    
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
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    /**
     * @return the appointments
     */
    public List<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * @param appointments the appointments to set
     */
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
