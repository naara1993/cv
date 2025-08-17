package com.desdeaquisenombraelresto.Curriculum.Repository;

import com.desdeaquisenombraelresto.Curriculum.Model.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
    // Métodos personalizados pueden ir aquí
    // Ejemplo: List<ContactMessage> findByEmail(String email);
}