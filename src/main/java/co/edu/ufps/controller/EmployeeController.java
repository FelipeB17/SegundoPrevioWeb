package co.edu.ufps.controller;

import co.edu.ufps.entities.Employee;
import co.edu.ufps.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }

    @GetMapping("/{id}/with-salary")
    public ResponseEntity<Employee> findEmployeeWithSalary(@PathVariable Long id) {
        return employeeService.findEmployeeWithSalary(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/department")
    public ResponseEntity<Employee> removeEmployeeFromDepartment(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.removeEmployeeFromDepartment(id));
    }
}