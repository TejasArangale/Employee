package com.example.Employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Employee.model.Employee;
import com.example.Employee.reposatary.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public Employee createEmployee(Employee emp) {
        return repo.save(emp);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    @Override
    public Employee updateEmployee(Integer id, Employee emp) {
        Employee existing = getEmployeeById(id);

        existing.setName(emp.getName());
        existing.setEmail(emp.getEmail());
        existing.setSalary(emp.getSalary());

        return repo.save(existing);
    }

    @Override
    public String deleteEmployee(Integer id) {
        repo.deleteById(id);
        return "Employee Deleted Successfully!";
    }
}
