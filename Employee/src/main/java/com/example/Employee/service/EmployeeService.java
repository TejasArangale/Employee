package com.example.Employee.service;

import java.util.List;
import com.example.Employee.model.Employee;

public interface EmployeeService {

    Employee createEmployee(Employee emp);

    Employee getEmployeeById(Integer id);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Integer id, Employee emp);

    String deleteEmployee(Integer id);
}
