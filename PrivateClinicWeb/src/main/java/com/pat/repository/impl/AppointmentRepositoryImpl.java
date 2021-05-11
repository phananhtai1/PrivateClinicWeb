/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.repository.impl;

import com.pat.pojo.Appointment;
import com.pat.pojo.Patient;
import com.pat.repository.AppointmentRepository;
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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Repository
public class AppointmentRepositoryImpl implements AppointmentRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Object[]> getAppointments(Date fromDate, Date toDate) {
        Session s = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root appointmentRoot = query.from(Appointment.class);
        Root patientRoot = query.from(Patient.class);
        query.where(builder.equal(appointmentRoot.get("patient"), patientRoot.get("id")));
        
        query.multiselect(appointmentRoot.get("id"),
                patientRoot.get("fullname").as(String.class),
                appointmentRoot.get("content").as(String.class ),
                appointmentRoot.get("appointmentDate").as(Date.class));     
        query.groupBy(appointmentRoot.get("id"),
                patientRoot.get("fullname").as(String.class),
                appointmentRoot.get("content").as(String.class ),
                appointmentRoot.get("appointmentDate").as(Date.class));
        
        if (fromDate != null && toDate != null) {
            Predicate p1 = builder.greaterThanOrEqualTo(
                    appointmentRoot.get("appointmentDate").as(Date.class), fromDate);
            Predicate p2 = builder.lessThanOrEqualTo(
                    appointmentRoot.get("appointmentDate").as(Date.class), toDate);
            query = query.having(p1, p2);
        }
        
        query.orderBy(builder.desc(appointmentRoot.get("id").as(Integer.class)));
        Query q = s.createQuery(query);
        return q.getResultList();
    }

    @Override
    @Transactional
    public Appointment getAppointmentId(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Appointment.class, id);
    }

    @Override
    @Transactional
    public boolean addOrUpdateAppointment(Appointment ap) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            if(ap.getId() > 0){
                session.update(ap);
            }else{
                session.save(ap);
            }
            return true;
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteAppointment(int appointmentId) {
        try{
            Session session = this.sessionFactory.getObject().getCurrentSession();
            session.delete(session.get(Appointment.class, appointmentId));
            
            return true;
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        
        return false;
    }

}
