package org.example.service;

import org.example.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public Integer saveEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(Integer empId);

    public void deleteEmployee(Integer empId);

}
