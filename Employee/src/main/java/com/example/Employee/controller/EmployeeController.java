package com.example.Employee.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.Employee.model.Employee;
import com.example.Employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee emp) {
        return service.createEmployee(emp);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Employee getById(@PathVariable Integer id) {
        return service.getEmployeeById(id);
    }

    // GET ALL
    @GetMapping("/all")
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public Employee update(@PathVariable Integer id, @RequestBody Employee emp) {
        return service.updateEmployee(id, emp);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        return service.deleteEmployee(id);
    }
}
