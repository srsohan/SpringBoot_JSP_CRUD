package com.jspmvc.service;

import com.jspmvc.model.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> Get_all_employee();

    public Employee Get_employee_by_id(Long id);

    public Employee Create_new_Employee(Employee employee);

    public Employee Update_Employee(Employee employee);

    public String Delete_Employee(Long id);
}

