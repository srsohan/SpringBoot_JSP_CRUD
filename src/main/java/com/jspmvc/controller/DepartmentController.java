package com.jspmvc.controller;

import com.jspmvc.dto.DepartmentDto;
import com.jspmvc.model.Department;
import com.jspmvc.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/departments")

public class DepartmentController {

    @Autowired
    public DepartmentService departmentService;

    @Autowired
    private ModelMapper modelMapper;



    @GetMapping("/list")
    public String listDepartments(Model model) {
        List<Department> departments = departmentService.Get_all_department();
        List<DepartmentDto> departmentDtos = departments.stream()
                .map(department -> modelMapper.map(department, DepartmentDto.class))
                .collect(Collectors.toList());
        model.addAttribute("departments", departmentDtos);
        return "department-list"; // Return the JSP view name
    }


    @GetMapping("/create")
    public String createDepartmentForm(Model model) {
        model.addAttribute("department", new DepartmentDto());
        return "department-create"; // Return the JSP form for creating a department
    }

    @PostMapping("/create")
    public String createDepartment(@ModelAttribute("department") DepartmentDto departmentDto) {
        Department department = modelMapper.map(departmentDto, Department.class);
        departmentService.Create_new_department(department);
        return "redirect:/departments/list"; // Redirect to the list page
    }


    @GetMapping("/update/{id}")
    public String updateDepartmentForm(@PathVariable Long id, Model model) {
        Department department = departmentService.Get_department_by_id(id);
        DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
        model.addAttribute("department", departmentDto);
        return "department-update"; // Return the JSP form for updating a department
    }

    @PostMapping("/update/{id}")
    public String updateDepartment(
            @PathVariable Long id,
            @ModelAttribute("department") DepartmentDto departmentDto) {
        Department department = modelMapper.map(departmentDto, Department.class);
        department.setId(id);
        departmentService.Update_department(department);
        return "redirect:/departments/list"; // Redirect to the list page
    }


    @GetMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        departmentService.Delete_department(id);
        return "redirect:/departments/list"; // Redirect to the list page
    }








}
