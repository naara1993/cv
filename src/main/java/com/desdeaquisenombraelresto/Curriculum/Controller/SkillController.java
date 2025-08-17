package com.desdeaquisenombraelresto.Curriculum.Controller;

import com.desdeaquisenombraelresto.Curriculum.Model.Skill;
import com.desdeaquisenombraelresto.Curriculum.Service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    @Autowired
    private SkillService service;

    @GetMapping
    public List<Skill> getAllSkills() {
        return service.getAllSkills();
    }

    @GetMapping("/type/{type}")
    public List<Skill> getSkillsByType(@PathVariable String type) {
        return service.getSkillsByType(type);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable Long id) {
        Skill skill = service.getSkillById(id);
        return skill != null ?
                ResponseEntity.ok(skill) :
                ResponseEntity.notFound().build();
    }

    @PostMapping
    public Skill createSkill(@RequestBody Skill skill) {
        return service.saveSkill(skill);
    }

    @PutMapping("/{id}")
    public Skill updateSkill(@PathVariable Long id, @RequestBody Skill skill) {
        skill.setId(id);
        return service.saveSkill(skill);
    }

    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id) {
        service.deleteSkill(id);
    }
}