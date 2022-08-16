package org.example.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;

    @Column(name = "emp_name", nullable = false)
    private String empName;

    @Column(name = "email")
    private String empEmail;

    @Column(name = "address")
    private String address;
}
