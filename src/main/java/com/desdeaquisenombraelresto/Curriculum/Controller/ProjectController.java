package com.desdeaquisenombraelresto.Curriculum.Controller;

import com.desdeaquisenombraelresto.Curriculum.Model.Project;
import com.desdeaquisenombraelresto.Curriculum.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping
    public List<Project> getAllProjects() {
        return service.getAllProjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        Project project = service.getProjectById(id);
        return project != null ?
                ResponseEntity.ok(project) :
                ResponseEntity.notFound().build();
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return service.saveProject(project);
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project project) {
        project.setId(id);
        return service.saveProject(project);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        service.deleteProject(id);
    }
}