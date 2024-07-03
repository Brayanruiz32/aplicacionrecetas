package com.principal.aplicacionrecetas.dtos.comida;

import java.sql.Blob;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.principal.aplicacionrecetas.entities.Categoria;
import com.principal.aplicacionrecetas.entities.Tipo;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ComidaDTO {

    private String nombre;

    private Tipo tipo;
    private Long id;
    private String preparacion;
    private String ingredientes;
    private Categoria categoria;
    private int calificacion;

}