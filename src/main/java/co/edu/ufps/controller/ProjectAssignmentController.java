package co.edu.ufps.controller;

import co.edu.ufps.entities.ProjectAssignment;
import co.edu.ufps.services.ProjectAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project-assignments")
public class ProjectAssignmentController {

    @Autowired
    private ProjectAssignmentService projectAssignmentService;

    @PostMapping
    public ResponseEntity<ProjectAssignment> assignEmployeeToProject(
            @RequestParam Long employeeId,
            @RequestParam Long projectId,
            @RequestParam Long roleId) {
        return ResponseEntity.ok(projectAssignmentService.assignEmployeeToProject(employeeId, projectId, roleId));
    }
}