package com.desdeaquisenombraelresto.Curriculum.Service;

import com.desdeaquisenombraelresto.Curriculum.Model.Project;
import com.desdeaquisenombraelresto.Curriculum.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    public List<Project> getAllProjects() {
        return repository.findAll();
    }

    public Project getProjectById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Project saveProject(Project project) {
        return repository.save(project);
    }

    public void deleteProject(Long id) {
        repository.deleteById(id);
    }
}