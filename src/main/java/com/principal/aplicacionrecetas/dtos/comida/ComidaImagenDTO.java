package com.principal.aplicacionrecetas.dtos.comida;

import java.sql.Blob;

import com.principal.aplicacionrecetas.entities.Categoria;
import com.principal.aplicacionrecetas.entities.Tipo;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComidaImagenDTO {

    private Long id;
    private String nombre;
    private int calificacion;
    private String imagen;
    private Tipo tipo;
    private String preparacion;
    private String ingredientes;
    private Categoria categoria;

}
