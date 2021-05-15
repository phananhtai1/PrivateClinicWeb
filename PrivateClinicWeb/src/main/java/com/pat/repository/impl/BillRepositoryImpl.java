/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.repository.impl;

import com.pat.pojo.Bill;
import com.pat.pojo.MedicalForm;
import com.pat.pojo.Medicine;
import com.pat.pojo.Patient;
import com.pat.pojo.Prescription;
import com.pat.repository.BillRepository;
import com.pat.repository.PrescriptionRepository;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Repository
public class BillRepositoryImpl implements BillRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional
    public List<Object[]> getBills(Date fromDate, Date toDate) {
        Session s = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root billRoot = query.from(Bill.class);
        Root medicalFormRoot = query.from(MedicalForm.class);
        Root patientRoot = query.from(Patient.class);
        query.where(builder.equal(billRoot.get("medicalForm"), medicalFormRoot.get("id")),
                builder.equal(medicalFormRoot.get("patient"), patientRoot.get("id")));
        
        query.multiselect(billRoot.get("id"),
                billRoot.get("medicalForm"),
                patientRoot.get("fullname").as(String.class),
                billRoot.get("charge").as(BigDecimal.class),
                billRoot.get("medicineCost").as(BigDecimal.class),
                billRoot.get("totalAmount").as(BigDecimal.class),
                medicalFormRoot.get("examinationDate").as(Date.class));     
        query.groupBy(billRoot.get("id"),
                billRoot.get("medicalForm"),
                patientRoot.get("fullname").as(String.class),
                billRoot.get("charge").as(BigDecimal.class),
                billRoot.get("medicineCost").as(BigDecimal.class),
                billRoot.get("totalAmount").as(BigDecimal.class),
                medicalFormRoot.get("examinationDate").as(Date.class));      
        
        if (fromDate != null && toDate != null) {
            Predicate p1 = builder.greaterThanOrEqualTo(
                    medicalFormRoot.get("examinationDate").as(Date.class), fromDate);
            Predicate p2 = builder.lessThanOrEqualTo(
                    medicalFormRoot.get("examinationDate").as(Date.class), toDate);
            query = query.having(p1, p2);
        }
        
        Query q = s.createQuery(query);
        return q.getResultList();
    }

    @Override
    @Transactional
    public List<Object[]> getBillById(int billId) {
        Session s = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root billRoot = query.from(Bill.class);
        Root medicalFormRoot = query.from(MedicalForm.class);
        query.where(builder.equal(billRoot.get("medicalForm"), medicalFormRoot.get("id")),
                builder.equal(billRoot.get("id"), billId));
        
        query.multiselect(billRoot.get("id"),
                billRoot.get("medicalForm"),
                billRoot.get("charge").as(BigDecimal.class),
                billRoot.get("medicineCost").as(BigDecimal.class),
                billRoot.get("totalAmount").as(BigDecimal.class),
                medicalFormRoot.get("examinationDate").as(Date.class));     
        query.groupBy(billRoot.get("id"),
                billRoot.get("medicalForm"),
                billRoot.get("charge").as(BigDecimal.class),
                billRoot.get("medicineCost").as(BigDecimal.class),
                billRoot.get("totalAmount").as(BigDecimal.class),
                medicalFormRoot.get("examinationDate").as(Date.class));      
        
        Query q = s.createQuery(query);
        return q.getResultList();
    }

    @Override
    @Transactional
    public List<Object[]> getBillStatsByDate(Date fromDate, Date toDate) {
        Session s = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root billRoot = query.from(Bill.class);
        Root medicalFormRoot = query.from(MedicalForm.class);
        Root patientRoot = query.from(Patient.class);
        query.where(builder.equal(billRoot.get("medicalForm"), medicalFormRoot.get("id")),
                builder.equal(medicalFormRoot.get("patient"), patientRoot.get("id")));
        
        query.multiselect(medicalFormRoot.get("examinationDate").as(Date.class),
                builder.count(medicalFormRoot.get("patient")),
                builder.sum(billRoot.get("totalAmount").as(BigDecimal.class)));    
        query.groupBy(medicalFormRoot.get("examinationDate").as(Date.class));      
        
        if (fromDate != null && toDate != null) {
            Predicate p1 = builder.greaterThanOrEqualTo(
                    medicalFormRoot.get("examinationDate").as(Date.class), fromDate);
            Predicate p2 = builder.lessThanOrEqualTo(
                    medicalFormRoot.get("examinationDate").as(Date.class), toDate);
            query = query.having(p1, p2);
        }
        
        Query q = s.createQuery(query);
        return q.getResultList();
    }

    @Override
    @Transactional
    public List<Object[]> getBillStatsByMonth(int fm, int tm) {
        Session s = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root billRoot = query.from(Bill.class);
        Root medicalFormRoot = query.from(MedicalForm.class);
        Root patientRoot = query.from(Patient.class);
        query.where(builder.equal(billRoot.get("medicalForm"), medicalFormRoot.get("id")),
                builder.equal(medicalFormRoot.get("patient"), patientRoot.get("id")));
        
        query.multiselect(builder.function("MONTH", Integer.class, medicalFormRoot.get("examinationDate").as(Date.class)),
                builder.count(medicalFormRoot.get("patient")),
                builder.sum(billRoot.get("totalAmount").as(BigDecimal.class)));    
        query.groupBy(builder.function("MONTH", Integer.class, medicalFormRoot.get("examinationDate").as(Date.class)));      
        
        if (fm > 0 && tm > 0) {
            Predicate p1 = builder.greaterThanOrEqualTo(
                    builder.function("MONTH", Integer.class, medicalFormRoot.get("examinationDate")), fm);
            Predicate p2 = builder.lessThanOrEqualTo(
                    builder.function("MONTH", Integer.class, medicalFormRoot.get("examinationDate")), tm);
            query = query.where(builder.and(p1, p2));
        }
        
        Query q = s.createQuery(query);
        return q.getResultList();
    }

    @Override
    @Transactional
    public boolean deleteBill(int billId) {
        try{
            Session session = this.sessionFactory.getObject().getCurrentSession();
            session.delete(session.get(Bill.class, billId));
            
            return true;
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        
        return false;
    }


    
}
