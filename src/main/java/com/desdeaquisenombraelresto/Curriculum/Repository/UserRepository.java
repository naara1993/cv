package com.desdeaquisenombraelresto.Curriculum.Repository;

import com.desdeaquisenombraelresto.Curriculum.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Método para buscar por email (útil para login)
    Optional<User> findByEmail(String email);

    // Ejemplo: Optional<User> findByNombre(String nombre);
}