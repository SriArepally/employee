package com.radiant.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

    @Autowired
    public EmployeeDAO employeeDAO;

    @GetMapping(path="/", produces = "application/json")
    public Employees getEmployees() {
        return employeeDAO.getEmployees();
    }

    @PostMapping(path="/addEmployee", consumes="application/json", produces="application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        Integer id = employeeDAO.getEmployees().getEmployeeList().size() +1;
        employee.setId(id);
        employeeDAO.addEmployee(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
