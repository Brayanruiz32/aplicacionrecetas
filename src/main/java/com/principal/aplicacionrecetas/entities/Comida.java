package com.principal.aplicacionrecetas.entities;

import java.sql.Blob;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "comidas")
public class Comida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int calificacion;

    @Column(nullable = true)
    @Lob
    private Blob imagen;
    
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Column(columnDefinition = "TEXT")
    private String preparacion;
    
    @Column(columnDefinition = "TEXT")
    private String ingredientes;


    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    
}
