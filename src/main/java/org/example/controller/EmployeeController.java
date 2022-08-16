package org.example.controller;

import org.example.entity.Employee;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeeDetails")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/saveEmployee")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
        Integer id = service.saveEmployee(employee);
        return new ResponseEntity<>("Employee with '"+id+"' has been saved", HttpStatus.OK);
    }

    @GetMapping("/employeeList")
    public ResponseEntity<List<Employee>> getAllEmployeeDetails(){
        List<Employee> list = service.getAllEmployees();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/getEmployeeById/{empId}")
    public ResponseEntity<Employee> getEmployeeById( @PathVariable("empId") Integer empId){
        Employee emp = service.getEmployeeById(empId);
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

    @PutMapping("/updateEmployee/{empId}")
    public ResponseEntity<String> updateEmployee(@PathVariable("empId") Integer empId, @RequestBody Employee employee){
        Employee empFromDb = service.getEmployeeById(empId);
        empFromDb.setEmpName(employee.getEmpName());
        empFromDb.setEmpEmail(employee.getEmpEmail());
        empFromDb.setAddress(employee.getAddress());
        Integer id = service.saveEmployee(empFromDb);
        return new ResponseEntity<>("Employee with '"+id+"' has been updated",HttpStatus.OK);
    }

    @DeleteMapping("deleteEmployee/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("empId") Integer empId){
        service.deleteEmployee(empId);
        return new ResponseEntity<>("Employee with '"+empId+"' has been deleted",HttpStatus.OK);
    }
}
