/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "medicine")
public class Medicine implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotEmpty(message = "{medicine.name.error.notNullMsg}")
    private String name;
    
    private String unit;
    
    
    @Min(value = 20000, message = "{medicine.price.error.minMsg}")
    @Max(value = 1000000000, message = "{medicine.price.error.maxMsg}")
    @NotNull(message = "{medicine.price.error.notNullMsg}")
    private BigDecimal price;
    
    @NotNull(message = "{medicine.manufacturingDate.error.notNullMsg}")
    @Column(name = "manufacturing_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date manufacturingDate;
    
    @NotNull(message = "{medicine.expiryDate.error.notNullMsg}")
    @Column(name = "expiry_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date expiryDate;
    
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return the manufacturingDate
     */
    public Date getManufacturingDate() {
        return manufacturingDate;
    }

    /**
     * @param manufacturingDate the manufacturingDate to set
     */
    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    /**
     * @return the expiryDate
     */
    public Date getExpiryDate() {
        return expiryDate;
    }

    /**
     * @param expiryDate the expiryDate to set
     */
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
    
}
