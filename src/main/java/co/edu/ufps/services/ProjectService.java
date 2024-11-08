package co.edu.ufps.services;

import co.edu.ufps.entities.Project;
import co.edu.ufps.entities.ProjectAssignment;
import co.edu.ufps.repositories.ProjectRepository;
import co.edu.ufps.repositories.ProjectAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectAssignmentRepository projectAssignmentRepository;

    public List<Project> listAllProjects() {
        return projectRepository.findAll();
    }

    public Project updateProject(Long id, Project projectDetails) {
        return projectRepository.findById(id)
                .map(project -> {
                    project.setName(projectDetails.getName());
                    project.setDescription(projectDetails.getDescription());
                    project.setStartDate(projectDetails.getStartDate());
                    project.setEndDate(projectDetails.getEndDate());
                    return projectRepository.save(project);
                })
                .orElseThrow(() -> new RuntimeException("Project not found with id " + id));
    }

    public List<ProjectAssignment> listEmployeesWithRolesInProject(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found with id " + projectId));
        return project.getProjectAssignments();
    }
}