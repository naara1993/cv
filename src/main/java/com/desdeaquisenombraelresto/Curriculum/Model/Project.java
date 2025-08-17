package com.desdeaquisenombraelresto.Curriculum.Model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(length = 2000)
    private String descripcion;

    private String tecnologias; // Podrías usar lista, pero String simple por ahora

    private String url;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getTecnologias() { return tecnologias; }
    public void setTecnologias(String tecnologias) { this.tecnologias = tecnologias; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        return id != null && id.equals(((Project) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
