package com.desdeaquisenombraelresto.Curriculum.Model;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String nivel;  // Ej: Básico, Intermedio, Avanzado

    private String tipo;   // Ej: Técnica, Blanda, Idioma

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skill)) return false;
        return id != null && id.equals(((Skill) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
