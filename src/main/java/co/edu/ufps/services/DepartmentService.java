package co.edu.ufps.services;

import co.edu.ufps.entities.Department;
import co.edu.ufps.entities.Employee;
import co.edu.ufps.repositories.DepartmentRepository;
import co.edu.ufps.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Department> findDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public Department addEmployeesToDepartment(Long departmentId, List<Long> employeeIds) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        
        List<Employee> employees = employeeRepository.findAllById(employeeIds);
        employees.forEach(employee -> employee.setDepartment(department));
        
        department.getEmployees().addAll(employees);
        return departmentRepository.save(department);
    }
}