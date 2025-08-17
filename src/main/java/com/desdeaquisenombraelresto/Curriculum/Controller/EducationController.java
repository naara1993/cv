package com.desdeaquisenombraelresto.Curriculum.Controller;

import com.desdeaquisenombraelresto.Curriculum.Model.Education;
import com.desdeaquisenombraelresto.Curriculum.Service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/education")
public class EducationController {

    @Autowired
    private EducationService service;

    @GetMapping
    public List<Education> getAllEducation() {
        return service.getAllEducation();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Education> getEducationById(@PathVariable Long id) {
        Education education = service.getEducationById(id);
        return education != null ?
                ResponseEntity.ok(education) :
                ResponseEntity.notFound().build();
    }

    @PostMapping
    public Education createEducation(@RequestBody Education education) {
        return service.saveEducation(education);
    }

    @PutMapping("/{id}")
    public Education updateEducation(@PathVariable Long id, @RequestBody Education education) {
        education.setId(id); // Asegurar que se actualiza el registro correcto
        return service.saveEducation(education);
    }

    @DeleteMapping("/{id}")
    public void deleteEducation(@PathVariable Long id) {
        service.deleteEducation(id);
    }
}