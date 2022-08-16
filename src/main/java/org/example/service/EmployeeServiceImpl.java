package org.example.service;

import org.example.controller.ResourceNotFoundException;
import org.example.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository repository;

    @Override
    public Integer saveEmployee(Employee employee) {
        return repository.save(employee).getEmpId();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) repository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer empId) {
        return repository.findById(empId).get();
    }

    @Override
    public void deleteEmployee(Integer empId) {
        // check whether an employee exist in a DB or not
        repository.findById(empId).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", empId));
        repository.deleteById(empId);
    }
}
