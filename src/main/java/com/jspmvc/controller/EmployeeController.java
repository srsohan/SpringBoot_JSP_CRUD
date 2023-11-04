package com.jspmvc.controller;


import com.jspmvc.dto.EmployeeDTO;
import com.jspmvc.model.Employee;
import com.jspmvc.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.Get_all_employee();
        List<EmployeeDTO> employeeDtos = employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
        model.addAttribute("employees", employeeDtos);
        return "employee-list"; // Return the JSP view name
    }


    @GetMapping("/create")
    public String createEmployeeForm(Model model) {
        model.addAttribute("employee", new EmployeeDTO());
        return "employee-create"; // Return the JSP form for creating an employee
    }

    @PostMapping("/create")
    public String createEmployee(@ModelAttribute("employee") EmployeeDTO employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employeeService.Create_new_Employee(employee);
        return "redirect:/employees/list"; // Redirect to the list page
    }



    @GetMapping("/update/{id}")
    public String updateEmployeeForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.Get_employee_by_id(id);
        EmployeeDTO employeeDto = modelMapper.map(employee, EmployeeDTO.class);
        model.addAttribute("employee", employeeDto);
        return "employee-update"; // Return the JSP form for updating an employee
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(
            @PathVariable Long id,
            @ModelAttribute("employee") EmployeeDTO employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employee.setId(id);
        employeeService.Update_Employee(employee);
        return "redirect:/employees/list"; // Redirect to the list page
    }



    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.Delete_Employee(id);
        return "redirect:/employees/list"; // Redirect to the list page
    }



    @GetMapping("/welcome")
    public ModelAndView welcomeMessage() {
        System.out.println(this.getClass().getSimpleName() + ":=======>Showing Welcome Page.");
        return new ModelAndView("welcome"); // Here welcome is a jsp page name
    }

}
