package com.principal.aplicacionrecetas.services;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.principal.aplicacionrecetas.entities.Categoria;
import com.principal.aplicacionrecetas.entities.Comida;
import com.principal.aplicacionrecetas.entities.Tipo;
import com.principal.aplicacionrecetas.repositories.CategoriaRepository;
import com.principal.aplicacionrecetas.repositories.ComidaRepository;
import com.principal.aplicacionrecetas.repositories.TipoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ComidaService {

    @Autowired
    private ComidaRepository comidaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private TipoRepository tipoRepository;

    @Value("${ruta.subida}")
    private String ruta;

    public Comida actualizar(Long id, Comida nuevosDatos) {
        Comida comida = comidaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        Categoria categoria = categoriaRepository.findById(nuevosDatos.getCategoria().getId())
                .orElseThrow(() -> new EntityNotFoundException());

        Tipo tipo = tipoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        if (nuevosDatos.getIngredientes().size() != 0) {
            comida.setIngredientes(nuevosDatos.getIngredientes());
        }

        if (nuevosDatos.getPreparacion().size() != 0) {
            comida.setPreparacion(nuevosDatos.getPreparacion());
        }

        if (nuevosDatos.getNombre() != null) {
            comida.setNombre(nuevosDatos.getNombre());
        }

        comida.setCategoria(categoria);

        comida.setTipo(tipo);

        return comidaRepository.save(comida);
    }

    public Comida crear(Comida nuevoRegistro, MultipartFile imagen) throws SerialException, SQLException {

        Categoria categoria = categoriaRepository.findById(nuevoRegistro.getCategoria().getId())
                .orElseThrow(() -> new EntityNotFoundException());

        Tipo tipo = tipoRepository.findById(nuevoRegistro.getTipo().getId())
                .orElseThrow(() -> new EntityNotFoundException());

        nuevoRegistro.setCategoria(categoria);

        nuevoRegistro.setTipo(tipo);

        if (imagen != null && !imagen.isEmpty()) {
            try {

                byte[] imagenBytes = imagen.getBytes();
                Blob blob = new javax.sql.rowset.serial.SerialBlob(imagenBytes);
                nuevoRegistro.setImagen(blob);
                
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Error al guardar la imagen", e);
            }
        }
        return comidaRepository.save(nuevoRegistro);
    }

    public void eliminar(Long id) {
        Comida comida = comidaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        comidaRepository.delete(comida);
    }

    public Comida encontrar(Long id) {
        return comidaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    public List<Comida> listar() {
        return comidaRepository.findAll();
    }



}
