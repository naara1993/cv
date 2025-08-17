package com.desdeaquisenombraelresto.Curriculum.Service;

import com.desdeaquisenombraelresto.Curriculum.Model.Education;
import com.desdeaquisenombraelresto.Curriculum.Repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EducationService {

    @Autowired
    private EducationRepository repository;

    public List<Education> getAllEducation() {
        return repository.findAll();
    }

    public Education getEducationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Education saveEducation(Education education) {
        return repository.save(education);
    }

    public void deleteEducation(Long id) {
        repository.deleteById(id);
    }
}