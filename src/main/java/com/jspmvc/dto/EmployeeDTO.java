package com.jspmvc.dto;

import com.jspmvc.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String code;
    private String name;
    private Date dob;
    private Gender gender;
    private String mobile;
    private Long deptId;
}