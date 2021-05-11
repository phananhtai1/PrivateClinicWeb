/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.repository.impl;

import com.pat.pojo.Employee;
import com.pat.repository.EmployeeRepository;
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
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional
    public List<Employee> getEmployees(String kw) {
        Session s = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        Root root = query.from(Employee.class);
        query.select(root);

        if (kw != null && !kw.isEmpty()) {
            String pattern = String.format("%%%s%%", kw);
            Predicate p1 = builder.like(root.get("fullname").as(String.class), pattern);
            Predicate p2 = builder.like(root.get("sex").as(String.class), pattern);
            Predicate p3 = builder.like(root.get("address").as(String.class), pattern);

            query = query.where(builder.or(p1, p2, p3));
        }

        Query q = s.createQuery(query);
        return q.getResultList();
    }

    @Override
    @Transactional
    public Employee getEmployeeId(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Override
    @Transactional
    public boolean addOrUpdateEmployee(Employee em) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            if(em.getId() > 0){
                session.update(em);
            }else{
                session.save(em);
            }
            return true;
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteEmployee(int employeeId) {
        try{
            Session session = this.sessionFactory.getObject().getCurrentSession();
            session.delete(session.get(Employee.class, employeeId));
            
            return true;
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    

}
