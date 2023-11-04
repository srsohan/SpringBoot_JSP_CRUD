package com.jspmvc.service;



import com.jspmvc.model.Department;

import java.util.List;

public interface DepartmentService {


    public List<Department> Get_all_department();

    public Department Get_department_by_id(Long id);

    public Department Create_new_department(Department department);

    public Department Update_department(Department department);

    public String Delete_department(Long id);


}
