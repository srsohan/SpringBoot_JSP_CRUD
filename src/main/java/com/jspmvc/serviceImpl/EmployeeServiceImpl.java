package com.jspmvc.serviceImpl;

import javax.persistence.EntityNotFoundException;

import com.jspmvc.model.Employee;
import com.jspmvc.repository.EmployeeRepository;
import com.jspmvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> Get_all_employee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee Get_employee_by_id(Long id) {
        return employeeRepository.findById(id).get();
    }


    @Override
    public Employee Create_new_Employee(Employee employee) {
        return employeeRepository.save(employee);
    }


    @Override
    public Employee Update_Employee(Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employee.getId())
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        // Update the fields of the existing employee
        existingEmployee.setCode(employee.getCode());
        existingEmployee.setName(employee.getName());
        existingEmployee.setDob(employee.getDob());
        existingEmployee.setGender(employee.getGender());
        existingEmployee.setMobile(employee.getMobile());
        existingEmployee.setDepartment(employee.getDepartment());

        return employeeRepository.save(existingEmployee);
    }


    @Override
    public String Delete_Employee(Long id) {
        employeeRepository.deleteById(id);
        return "Employee deleted successfully!";
    }

}
