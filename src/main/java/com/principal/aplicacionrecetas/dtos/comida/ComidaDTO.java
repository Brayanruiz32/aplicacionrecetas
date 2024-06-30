package com.principal.aplicacionrecetas.dtos.comida;

import java.util.List;

import com.principal.aplicacionrecetas.entities.Categoria;
import com.principal.aplicacionrecetas.entities.Tipo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ComidaDTO {
    private Long id;
    private String nombre;
    private int calificacion;
    private String imagenBase64;
    private List<String> preparacion;
    private List<String> ingredientes;
    private Categoria categoria;
    private Tipo tipo;

}