package com.principal.aplicacionrecetas.dtos.comida;

import org.springframework.web.multipart.MultipartFile;

import com.principal.aplicacionrecetas.entities.Categoria;
import com.principal.aplicacionrecetas.entities.Tipo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComidaRequestDTO {
    private String nombre;
    private String tipo;

    private String preparacion;
    private String ingredientes;
    private String categoria;
}
