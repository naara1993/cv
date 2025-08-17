package com.desdeaquisenombraelresto.Curriculum.Repository;

import com.desdeaquisenombraelresto.Curriculum.Model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    // Ejemplo: List<Experience> findByPuestoContainingIgnoreCase(String puesto);
}