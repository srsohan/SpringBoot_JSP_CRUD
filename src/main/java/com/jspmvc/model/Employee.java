package com.jspmvc.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 4)
    private String code;

    @Column(nullable = false, length = 35)
    private String name;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(length = 15)
    private String mobile;


    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JsonBackReference
    @JoinColumn(name = "dept_id", referencedColumnName = "id")
    private Department department;
}
