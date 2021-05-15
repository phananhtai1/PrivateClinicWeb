/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.repository.impl;

import com.pat.pojo.Medicine;
import com.pat.pojo.Prescription;
import com.pat.repository.PrescriptionRepository;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
public class PrescriptionRepositoryImpl implements PrescriptionRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional
    public List<Object[]> getPrescriptions() {
        Session s = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root medicineRoot = query.from(Medicine.class);
        Root prescriptionRoot = query.from(Prescription.class);

        query.where(builder.equal(prescriptionRoot.get("medicine"), medicineRoot.get("id")));

        query.multiselect(prescriptionRoot.get("id"),
                prescriptionRoot.get("medicalForm"),
                medicineRoot.get("name").as(String.class),
                prescriptionRoot.get("quantity"),
                prescriptionRoot.get("usage").as(String.class));
        query.groupBy(prescriptionRoot.get("id"),
                prescriptionRoot.get("medicalForm"),
                medicineRoot.get("name").as(String.class),
                prescriptionRoot.get("quantity"),
                prescriptionRoot.get("usage").as(String.class));

        Query q = s.createQuery(query);
        return q.getResultList();
    }

    @Override
    @Transactional
    public Prescription getPrescriptionId(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Prescription.class, id);
    }

    @Override
    @Transactional
    public boolean addOrUpdatePrescription(Prescription pr) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            if (pr.getId() > 0) {
                session.update(pr);
            } else {
                session.save(pr);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deletePrescription(int prescriptionId) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            session.delete(session.get(Prescription.class, prescriptionId));

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    @Transactional
    public List<Object[]> getInfoPrescriptionByMFId(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root prescriptionRoot = query.from(Prescription.class);
        Root medicineRoot = query.from(Medicine.class);

        query.where(builder.equal(prescriptionRoot.get("medicine"), medicineRoot.get("id")),
                builder.equal(prescriptionRoot.get("medicalForm"), id));

        query.multiselect(medicineRoot.get("name").as(String.class),
                medicineRoot.get("price"),
                prescriptionRoot.get("quantity"),
                prescriptionRoot.get("usage").as(String.class),
                medicineRoot.get("unit").as(String.class));
        query.groupBy(medicineRoot.get("name").as(String.class),
                medicineRoot.get("price"),
                prescriptionRoot.get("quantity"),
                prescriptionRoot.get("usage").as(String.class),
                medicineRoot.get("unit").as(String.class));
        Query q = s.createQuery(query);
        return q.getResultList();
    }

}
