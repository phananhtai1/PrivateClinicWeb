/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.service.impl;

import com.pat.pojo.Employee;
import com.pat.repository.EmployeeRepository;
import com.pat.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Override
    public List<Employee> getEmployees(String kw) {
        return this.employeeRepository.getEmployees(kw);
    }

    @Override
    public Employee getEmployeeId(int id) {
        return this.employeeRepository.getEmployeeId(id);
    }

    @Override
    public boolean addOrUpdateEmployee(Employee em) {
        return this.employeeRepository.addOrUpdateEmployee(em);
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        return this.employeeRepository.deleteEmployee(employeeId);
    }
    
}
