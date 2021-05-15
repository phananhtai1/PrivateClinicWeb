/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.repository.impl;

import com.pat.pojo.Medicine;
import com.pat.repository.MedicineRepository;
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
public class MedicineRepositoryImpl implements MedicineRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional
    public List<Medicine> getMedicines(String kw) {
        Session s = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Medicine> query = builder.createQuery(Medicine.class);
        Root root = query.from(Medicine.class);
        query.select(root);

        if (kw != null && !kw.isEmpty()) {
            String pattern = String.format("%%%s%%", kw);
            Predicate p1 = builder.like(root.get("name").as(String.class), pattern);
            Predicate p2 = builder.like(root.get("unit").as(String.class), pattern);
            query = query.where(builder.or(p1, p2));
        }

        Query q = s.createQuery(query);
        return q.getResultList();
    }

    @Override
    @Transactional
    public Medicine getMedicineId(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Medicine.class, id);
    }

    @Override
    @Transactional
    public boolean addOrUpdateMedicine(Medicine me) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            if (me.getId() > 0) {
                session.update(me);
            } else {
                session.save(me);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteMedicine(int medicineId) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            session.delete(session.get(Medicine.class, medicineId));

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
