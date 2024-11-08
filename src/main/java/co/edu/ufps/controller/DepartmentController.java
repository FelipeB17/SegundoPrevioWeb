package co.edu.ufps.controller;

import co.edu.ufps.entities.Department;
import co.edu.ufps.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/{id}")
    public ResponseEntity<Department> findDepartmentById(@PathVariable Long id) {
        return departmentService.findDepartmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/employees")
    public ResponseEntity<Department> addEmployeesToDepartment(
            @PathVariable Long id,
            @RequestBody List<Long> employeeIds) {
        return ResponseEntity.ok(departmentService.addEmployeesToDepartment(id, employeeIds));
    }
}