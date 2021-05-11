/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.service.impl;

import com.pat.pojo.Appointment;
import com.pat.repository.AppointmentRepository;
import com.pat.service.AppointmentService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    private AppointmentRepository appointmentRepository;
    
    @Override
    public List<Object[]> getAppointments(Date fromDate, Date toDate) {
        return this.appointmentRepository.getAppointments(fromDate, toDate);
    }

    @Override
    public Appointment getAppointmentId(int id) {
        return this.appointmentRepository.getAppointmentId(id);
    }

    @Override
    public boolean addOrUpdateAppointment(Appointment ap) {
        return this.appointmentRepository.addOrUpdateAppointment(ap);
    }

    @Override
    public boolean deleteAppointment(int appointmentId) {
        return this.appointmentRepository.deleteAppointment(appointmentId);
    }
    
}
