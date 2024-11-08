package co.edu.ufps.services;

import co.edu.ufps.entities.Employee;
import co.edu.ufps.entities.Project;
import co.edu.ufps.entities.ProjectAssignment;
import co.edu.ufps.entities.Role;
import co.edu.ufps.repositories.EmployeeRepository;
import co.edu.ufps.repositories.ProjectAssignmentRepository;
import co.edu.ufps.repositories.ProjectRepository;
import co.edu.ufps.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectAssignmentService {

    @Autowired
    private ProjectAssignmentRepository projectAssignmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private RoleRepository roleRepository;

    public ProjectAssignment assignEmployeeToProject(Long employeeId, Long projectId, Long roleId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        ProjectAssignment assignment = new ProjectAssignment();
        assignment.setEmployee(employee);
        assignment.setProject(project);
        assignment.setRole(role);

        return projectAssignmentRepository.save(assignment);
    }
}