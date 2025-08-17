package com.desdeaquisenombraelresto.Curriculum.Repository;

import com.desdeaquisenombraelresto.Curriculum.Model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findByTipo(String type);
    // Ejemplo: List<Skill> findByTipo(String tipo);
}