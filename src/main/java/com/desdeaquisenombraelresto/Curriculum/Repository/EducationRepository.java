package com.desdeaquisenombraelresto.Curriculum.Repository;

import com.desdeaquisenombraelresto.Curriculum.Model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
    // Ejemplo: List<Education> findByInstitucion(String institucion);
}