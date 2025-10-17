package com.api.employee.service;

import com.api.employee.entity.Employee;
import com.api.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    // constructor injection (best practice)
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    // CREATE employee
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    // READ all employees
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // READ one employee by ID
    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    }

    // UPDATE employee
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existing = getEmployeeById(id);
        existing.setName(updatedEmployee.getName());
        existing.setEmail(updatedEmployee.getEmail());
        existing.setDepartment(updatedEmployee.getDepartment());
        return repository.save(existing);
    }

    // DELETE employee
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }


    public void deleteEmployee1(Long id) {
        repository.deleteById(id);
    }
}