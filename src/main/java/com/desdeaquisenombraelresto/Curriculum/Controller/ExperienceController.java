package com.desdeaquisenombraelresto.Curriculum.Controller;

import com.desdeaquisenombraelresto.Curriculum.Model.Experience;
import com.desdeaquisenombraelresto.Curriculum.Service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {

    @Autowired
    private ExperienceService service;

    @GetMapping
    public List<Experience> getAllExperiences() {
        return service.getAllExperiences();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experience> getExperienceById(@PathVariable Long id) {
        Experience experience = service.getExperienceById(id);
        return experience != null ?
                ResponseEntity.ok(experience) :
                ResponseEntity.notFound().build();
    }

    @PostMapping
    public Experience createExperience(@RequestBody Experience experience) {
        return service.saveExperience(experience);
    }

    @PutMapping("/{id}")
    public Experience updateExperience(@PathVariable Long id, @RequestBody Experience experience) {
        experience.setId(id);
        return service.saveExperience(experience);
    }

    @DeleteMapping("/{id}")
    public void deleteExperience(@PathVariable Long id) {
        service.deleteExperience(id);
    }
}