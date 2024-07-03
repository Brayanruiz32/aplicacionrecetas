package com.principal.aplicacionrecetas.dtos.comida;

import com.principal.aplicacionrecetas.entities.Categoria;
import com.principal.aplicacionrecetas.entities.Tipo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComidaDTOAdmin {

    private String nombre;
    private Boolean imagenBoolean;
    private Tipo tipo;
    private Long id;
    private String preparacion;
    private String ingredientes;
    private Categoria categoria;
    private int calificacion;


}
