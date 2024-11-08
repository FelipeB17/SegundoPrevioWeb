package co.edu.ufps.controller;

import co.edu.ufps.entities.Project;
import co.edu.ufps.entities.ProjectAssignment;
import co.edu.ufps.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> listAllProjects() {
        return ResponseEntity.ok(projectService.listAllProjects());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project projectDetails) {
        return ResponseEntity.ok(projectService.updateProject(id, projectDetails));
    }

    @GetMapping("/{id}/employees-with-roles")
    public ResponseEntity<List<ProjectAssignment>> listEmployeesWithRolesInProject(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.listEmployeesWithRolesInProject(id));
    }
}