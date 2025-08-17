package com.desdeaquisenombraelresto.Curriculum.Service;

import com.desdeaquisenombraelresto.Curriculum.Model.Skill;
import com.desdeaquisenombraelresto.Curriculum.Repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository repository;

    public List<Skill> getAllSkills() {
        return repository.findAll();
    }

    public List<Skill> getSkillsByType(String type) {
        return repository.findByTipo(type);
    }

    public Skill getSkillById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Skill saveSkill(Skill skill) {
        return repository.save(skill);
    }

    public void deleteSkill(Long id) {
        repository.deleteById(id);
    }
}