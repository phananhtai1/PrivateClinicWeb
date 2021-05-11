/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.repository;

import com.pat.pojo.Employee;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface EmployeeRepository {
    List<Employee> getEmployees(String kw);
    Employee getEmployeeId(int id);
    boolean addOrUpdateEmployee(Employee em);
    boolean deleteEmployee(int employeeId);
}
