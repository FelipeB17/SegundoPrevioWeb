package co.edu.ufps.services;

import co.edu.ufps.entities.Employee;
import co.edu.ufps.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> findEmployeeWithSalary(Long id) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.getPosition().getSalary(); // Ensure salary is loaded
                    return employee;
                });
    }

    public Employee removeEmployeeFromDepartment(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setDepartment(null);
        return employeeRepository.save(employee);
    }
}