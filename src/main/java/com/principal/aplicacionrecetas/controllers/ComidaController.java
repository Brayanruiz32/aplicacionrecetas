package com.principal.aplicacionrecetas.controllers;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.principal.aplicacionrecetas.dtos.comida.ComidaDTO;
import com.principal.aplicacionrecetas.dtos.comida.ComidaImagenDTO;
import com.principal.aplicacionrecetas.dtos.comida.ComidaRequestDTO;
import com.principal.aplicacionrecetas.entities.Categoria;
import com.principal.aplicacionrecetas.entities.Comida;
import com.principal.aplicacionrecetas.entities.Tipo;
import com.principal.aplicacionrecetas.entities.Usuario;
import com.principal.aplicacionrecetas.repositories.ComidaRepository;
import com.principal.aplicacionrecetas.repositories.UsuarioRepository;
import com.principal.aplicacionrecetas.services.ComidaService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/comida")
public class ComidaController {

    @Autowired
    private ComidaService comidaServicio;

    @Autowired
    private ComidaRepository comidaRepository;
    // private ModelMapper modelMapper= new ModelMapper();

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/create")
    public ResponseEntity<Comida> crear(@RequestBody ComidaRequestDTO nuevoRegistro) {
        Comida comida = Comida.builder()
                .calificacion(0)
                .categoria(new Categoria(Long.parseLong(nuevoRegistro.getCategoria()), null))
                .nombre(nuevoRegistro.getNombre())
                .tipo(Tipo.valueOf(nuevoRegistro.getTipo()))
                .ingredientes(nuevoRegistro.getIngredientes())
                .preparacion(nuevoRegistro.getPreparacion())
                .build();
        return ResponseEntity.ok(comidaServicio.crear(comida));
    }

    // , @RequestParam(required = false) MultipartFile imagen
    @PutMapping("/update/{id}")
    public ResponseEntity<Comida> editar(@PathVariable Long id, @RequestBody ComidaRequestDTO nuevoRegistro) {
        Comida comida = Comida.builder()
                .calificacion(0)
                .categoria(new Categoria(Long.parseLong(nuevoRegistro.getCategoria()), null))
                .nombre(nuevoRegistro.getNombre())
                .tipo(Tipo.valueOf(nuevoRegistro.getTipo()))
                .ingredientes(nuevoRegistro.getIngredientes())
                .preparacion(nuevoRegistro.getPreparacion())
                .build();

        return ResponseEntity.ok(comidaServicio.actualizar(id, comida));
    }

    @DeleteMapping("/delete/{id}")
    public void eliminar(@PathVariable Long id) {
        comidaServicio.eliminar(id);
    }

    @GetMapping("/find/{id}")
    public ComidaDTO encontrar(@PathVariable Long id) {
        return comidaServicio.encontrar(id);
    }

    @GetMapping("/find/all")
    public List<ComidaDTO> listar() {
        return comidaServicio.listar();
    }

    // @GetMapping("/comidas/tipo/{tipo}")
    // public List<ComidaDTO> encontrarPorTipo(@PathVariable String tipo) {
    // return comidaServicio.encontrarPorTipo(tipo);

    // }

    @PostMapping("/image/upload/{id}")
    public ResponseEntity uploadImage(@PathVariable Long id, @RequestParam("image") MultipartFile imagen)
            throws SerialException, SQLException {
        comidaServicio.guardarImagen(id, imagen);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/listar")
    public List<ComidaImagenDTO> listarTodo() {
        return comidaRepository.findAll().stream()
                .map(comida -> {
                    ComidaImagenDTO dto = new ComidaImagenDTO();
                    dto.setId(comida.getId());
                    dto.setNombre(comida.getNombre());
                    dto.setCalificacion(comida.getCalificacion());
                    dto.setTipo(comida.getTipo());
                    dto.setPreparacion(comida.getPreparacion());
                    dto.setIngredientes(comida.getIngredientes());
                    dto.setCategoria(comida.getCategoria());
                    if (comida.getImagen() != null) {
                        try {
                            Blob imagenBlob = comida.getImagen();
                            int blobLength = (int) imagenBlob.length();
                            byte[] blobAsBytes = imagenBlob.getBytes(1, blobLength);
                            dto.setImagen(Base64.getEncoder().encodeToString(blobAsBytes));
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    return dto;
                })
                .collect(Collectors.toList());
    }

    // comida/listar/tipo
    @GetMapping("/listar/{tipo}")
    public List<ComidaImagenDTO> listarPorTipo(@PathVariable String tipo) {
        Tipo tipoConsulta = Tipo.valueOf(tipo.toUpperCase());
        return comidaRepository.findByTipo(tipoConsulta).stream()
                .map(comida -> {
                    ComidaImagenDTO dto = new ComidaImagenDTO();
                    dto.setId(comida.getId());
                    dto.setNombre(comida.getNombre());
                    dto.setCalificacion(comida.getCalificacion());
                    dto.setTipo(comida.getTipo());
                    dto.setPreparacion(comida.getPreparacion());
                    dto.setIngredientes(comida.getIngredientes());
                    dto.setCategoria(comida.getCategoria());
                    if (comida.getImagen() != null) {
                        try {
                            Blob imagenBlob = comida.getImagen();
                            int blobLength = (int) imagenBlob.length();
                            byte[] blobAsBytes = imagenBlob.getBytes(1, blobLength);
                            dto.setImagen(Base64.getEncoder().encodeToString(blobAsBytes));
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    return dto;
                })
                .collect(Collectors.toList());
    }

    // comida/listar/categoria
    @GetMapping("/listar/categoria/{categoria}")
    public List<ComidaImagenDTO> listarPorCategoria(@PathVariable String categoria) {
        // Tipo tipoConsulta = Tipo.valueOf(tipo.toUpperCase());

        return comidaRepository.encontrarPorNombreCategoria(categoria).stream()
                .map(comida -> {
                    ComidaImagenDTO dto = new ComidaImagenDTO();
                    dto.setId(comida.getId());
                    dto.setNombre(comida.getNombre());
                    dto.setCalificacion(comida.getCalificacion());
                    dto.setTipo(comida.getTipo());
                    dto.setPreparacion(comida.getPreparacion());
                    dto.setIngredientes(comida.getIngredientes());
                    dto.setCategoria(comida.getCategoria());
                    if (comida.getImagen() != null) {
                        try {
                            Blob imagenBlob = comida.getImagen();
                            int blobLength = (int) imagenBlob.length();
                            byte[] blobAsBytes = imagenBlob.getBytes(1, blobLength);
                            dto.setImagen(Base64.getEncoder().encodeToString(blobAsBytes));
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    return dto;
                })
                .collect(Collectors.toList());
    }

    // comida/encontrar/{id}
    @GetMapping("/encontrar/{id}")
    public ComidaImagenDTO encontrarPorId(@PathVariable Long id) {
        // Tipo tipoConsulta = Tipo.valueOf(tipo.toUpperCase());

        Comida comida = comidaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        ComidaImagenDTO dto = new ComidaImagenDTO();
        dto.setId(comida.getId());
        dto.setNombre(comida.getNombre());
        dto.setCalificacion(comida.getCalificacion());
        dto.setTipo(comida.getTipo());
        dto.setPreparacion(comida.getPreparacion());
        dto.setIngredientes(comida.getIngredientes());
        dto.setCategoria(comida.getCategoria());
        if (comida.getImagen() != null) {
            try {
                Blob imagenBlob = comida.getImagen();
                int blobLength = (int) imagenBlob.length();
                byte[] blobAsBytes = imagenBlob.getBytes(1, blobLength);
                dto.setImagen(Base64.getEncoder().encodeToString(blobAsBytes));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dto;
    }


    @PostMapping("/puntuar/{id}")
    public ResponseEntity puntuar(@PathVariable Long id, @RequestBody Map<String, Integer> request){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String nombre = authentication.getName();//extraigo el usuario

        System.out.println(nombre);

        Usuario usuario = usuarioRepository.findByUsuario(nombre).orElseThrow(() -> new EntityNotFoundException());

        for (Long idReceta : usuario.getRecetasPuntuadas()) {
            if (idReceta.equals(id) ) {
                return ResponseEntity.badRequest().build();   
            }
        }

        int puntuacion = request.get("puntuacion");
        Comida comida = comidaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        int calificacion = comida.getCalificacion() + puntuacion;
        comida.setCalificacion(calificacion);
        comidaRepository.save(comida);
        
        usuario.getRecetasPuntuadas().add(id);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok().build();
    }


}
