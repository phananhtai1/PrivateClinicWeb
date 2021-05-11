/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.repository;

import com.pat.pojo.Appointment;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface AppointmentRepository {
    List<Object[]> getAppointments(Date fromDate, Date toDate);
    Appointment getAppointmentId(int id);
    boolean addOrUpdateAppointment(Appointment ap);
    boolean deleteAppointment(int appointmentId);
    
}
