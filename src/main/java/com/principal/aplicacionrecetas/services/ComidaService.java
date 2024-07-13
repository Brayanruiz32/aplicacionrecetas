package com.principal.aplicacionrecetas.services;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.principal.aplicacionrecetas.dtos.comida.ComidaDTO;
import com.principal.aplicacionrecetas.entities.Categoria;
import com.principal.aplicacionrecetas.entities.Comida;
//import com.principal.aplicacionrecetas.entities.Tipo;
import com.principal.aplicacionrecetas.repositories.CategoriaRepository;
import com.principal.aplicacionrecetas.repositories.ComidaRepository;
//import com.principal.aplicacionrecetas.repositories.TipoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ComidaService {

    @Autowired
    private ComidaRepository comidaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    // @Autowired
    // private TipoRepository tipoRepository;
   
    private ModelMapper modelMapper = new ModelMapper();


    @Value("${ruta.subida}")
    private String ruta;

    public Comida actualizar(Long id, Comida nuevosDatos){
        Comida comida = comidaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        Categoria categoria = categoriaRepository.findById(nuevosDatos.getCategoria().getId())
                .orElseThrow(() -> new EntityNotFoundException());
        comida.setCategoria(categoria);
        
        if (nuevosDatos.getIngredientes() != null) {
            comida.setIngredientes(nuevosDatos.getIngredientes());
        }
        if (nuevosDatos.getPreparacion() != null) {
            comida.setPreparacion(nuevosDatos.getPreparacion());
        }
        if (nuevosDatos.getNombre() != null) {
            comida.setNombre(nuevosDatos.getNombre());
        }
        if (nuevosDatos.getTipo() != null) {
            comida.setTipo(nuevosDatos.getTipo());
        }

        // if (imagen != null && !imagen.isEmpty()) {
        //     try {
        //         byte[] imagenBytes = imagen.getBytes();
        //         Blob blob = new javax.sql.rowset.serial.SerialBlob(imagenBytes);
        //         comida.setImagen(blob);
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //         throw new RuntimeException("Error al guardar la imagen", e);
        //     }
        // }

        return comidaRepository.save(comida);
    }

    public Comida crear(Comida nuevoRegistro){
        Categoria categoria = categoriaRepository.findById(nuevoRegistro.getCategoria().getId())
                .orElseThrow(() -> new EntityNotFoundException());       
        nuevoRegistro.setCategoria(categoria);
        // if (imagen != null && !imagen.isEmpty()) {
        //     try {
        //         byte[] imagenBytes = imagen.getBytes();
        //         Blob blob = new javax.sql.rowset.serial.SerialBlob(imagenBytes);
        //         nuevoRegistro.setImagen(blob);
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //         throw new RuntimeException("Error al guardar la imagen", e);
        //     }
        // }
        return comidaRepository.save(nuevoRegistro);
    }

    public void eliminar(Long id) {
        Comida comida = comidaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        comidaRepository.delete(comida);
    }

    public ComidaDTO encontrar(Long id) {

        Comida comida = comidaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());


        return modelMapper.map(comida, ComidaDTO.class);
    }

    
    public List<Comida> listarTodo() {

        return comidaRepository.findAll();
    }





    public List<ComidaDTO> listar() {

        List<Comida> comidas = comidaRepository.findAll();

        List<ComidaDTO> comidasdto = comidas.stream().map(c -> modelMapper.map(c, ComidaDTO.class)).toList();

        return comidasdto;
    }

    // public List<ComidaDTO> encontrarPorTipo(String tipo) {
    //    // List<Comida> comidas = comidaRepository.findByTipo(tipo);

    //     return comidas.stream().map(c -> modelMapper.map(c, ComidaDTO.class)).toList();
    // }

    public void guardarImagen(Long id, MultipartFile imagen) throws SerialException, SQLException {

        
        Comida comida = comidaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        if (imagen != null && !imagen.isEmpty()) {
            try {

                byte[] imagenBytes = imagen.getBytes();
                Blob blob = new javax.sql.rowset.serial.SerialBlob(imagenBytes);
                comida.setImagen(blob);
                
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Error al guardar la imagen", e);
            }
        }

        comidaRepository.save(comida);
    }



    








}
