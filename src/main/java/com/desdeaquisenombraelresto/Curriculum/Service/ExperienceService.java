package com.desdeaquisenombraelresto.Curriculum.Service;

import com.desdeaquisenombraelresto.Curriculum.Model.Experience;
import com.desdeaquisenombraelresto.Curriculum.Repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository repository;

    public List<Experience> getAllExperiences() {
        return repository.findAll();
    }

    public Experience getExperienceById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Experience saveExperience(Experience experience) {
        return repository.save(experience);
    }

    public void deleteExperience(Long id) {
        repository.deleteById(id);
    }
}