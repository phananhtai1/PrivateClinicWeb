/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.repository.impl;

import com.pat.pojo.Employee;
import com.pat.pojo.MedicalForm;
import com.pat.pojo.Medicine;
import com.pat.pojo.Patient;
import com.pat.pojo.Prescription;
import com.pat.repository.MedicalFormRepository;
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
public class MedicalFormRepositoryImpl implements MedicalFormRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional
    public List<Object[]> getMedicalForms(Date fromDate, Date toDate) {
        Session s = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root medicalFormRoot = query.from(MedicalForm.class);
        Root patientRoot = query.from(Patient.class);
        Root employeeRoot = query.from(Employee.class);
        
        query.where(builder.equal(medicalFormRoot.get("patient"), patientRoot.get("id")),
                builder.equal(medicalFormRoot.get("employee"), employeeRoot.get("id")));
        
        query.multiselect(medicalFormRoot.get("id"),
                patientRoot.get("fullname").as(String.class),
                employeeRoot.get("fullname").as(String.class),
                medicalFormRoot.get("symptom").as(String.class ),
                medicalFormRoot.get("diagnostic").as(String.class ),
                medicalFormRoot.get("examinationDate").as(Date.class));
//                builder.count(medicalFormRoot.get("id")));     
        query.groupBy(medicalFormRoot.get("id"),
                patientRoot.get("fullname").as(String.class),
                employeeRoot.get("fullname").as(String.class),
                medicalFormRoot.get("symptom").as(String.class ),
                medicalFormRoot.get("diagnostic").as(String.class ),
                medicalFormRoot.get("examinationDate").as(Date.class)); 
        
        if (fromDate != null && toDate != null) {
            Predicate p1 = builder.greaterThanOrEqualTo(
                    medicalFormRoot.get("examinationDate").as(Date.class), fromDate);
            Predicate p2 = builder.lessThanOrEqualTo(
                    medicalFormRoot.get("examinationDate").as(Date.class), toDate);
            query = query.having(p1, p2);
        }
        
        query.orderBy(builder.desc(medicalFormRoot.get("id").as(Integer.class)));
        Query q = s.createQuery(query);
        return q.getResultList();
    }
    
    @Override
    @Transactional
    public List<MedicalForm> getMedicalForm() {
        Session s = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<MedicalForm> query = builder.createQuery(MedicalForm.class);
        Root root = query.from(MedicalForm.class);
        query.select(root);
        Query q = s.createQuery(query);
        return q.getResultList();
    }

    @Override
    @Transactional
    public MedicalForm getMedicalFormId(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(MedicalForm.class, id);
    }

    @Override
    @Transactional
    public boolean addOrUpdateMedicalForm(MedicalForm p) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            if(p.getId() > 0){
                session.update(p);
            }else{
                session.save(p);
            }
            return true;
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteMedicalForm(int medicalFormId) {
        try{
            Session session = this.sessionFactory.getObject().getCurrentSession();
            session.delete(session.get(MedicalForm.class, medicalFormId));
            
            return true;
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        
        return false;
    }

    @Override
    @Transactional
    public List<Object[]> getInfoPatientByMFId(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root medicalFormRoot = query.from(MedicalForm.class);
        Root patientRoot = query.from(Patient.class);
        Root employeeRoot = query.from(Employee.class);
        
        query.where(builder.equal(medicalFormRoot.get("patient"), patientRoot.get("id")),
                builder.equal(medicalFormRoot.get("employee"), employeeRoot.get("id")),
                builder.equal(medicalFormRoot.get("id"), id));
        
        query.multiselect(patientRoot.get("id"),
                patientRoot.get("fullname").as(String.class),
                patientRoot.get("birthDate").as(Date.class ),
                patientRoot.get("sex").as(String.class ),
                patientRoot.get("address").as(String.class),
                patientRoot.get("phone").as(String.class),
                medicalFormRoot.get("id"),
                medicalFormRoot.get("symptom").as(String.class ),
                medicalFormRoot.get("diagnostic").as(String.class ),
                medicalFormRoot.get("examinationDate").as(Date.class),
                employeeRoot.get("fullname").as(String.class));     
        query.multiselect(patientRoot.get("id"),
                patientRoot.get("fullname").as(String.class),
                patientRoot.get("birthDate").as(Date.class ),
                patientRoot.get("sex").as(String.class ),
                patientRoot.get("address").as(String.class),
                patientRoot.get("phone").as(String.class),
                medicalFormRoot.get("id"),
                medicalFormRoot.get("symptom").as(String.class ),
                medicalFormRoot.get("diagnostic").as(String.class ),
                medicalFormRoot.get("examinationDate").as(Date.class),
                employeeRoot.get("fullname").as(String.class));    
        Query q = s.createQuery(query);
        return q.getResultList();
    }

    @Override
    @Transactional
    public List<Object[]> getPatientByDate(Date fromDate, Date toDate) {
        Session s = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root medicalFormRoot = query.from(MedicalForm.class);
        Root patientRoot = query.from(Patient.class);
        
        query.where(builder.equal(medicalFormRoot.get("patient"), patientRoot.get("id")));
        
        query.multiselect(medicalFormRoot.get("examinationDate").as(Date.class),
                builder.count(medicalFormRoot.get("patient")));     
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

}
