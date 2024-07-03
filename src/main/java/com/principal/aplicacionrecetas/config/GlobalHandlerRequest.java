package com.principal.aplicacionrecetas.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalHandlerRequest {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handlerEntityNotFoundException(Exception ex){
            return new ResponseEntity<>("No se encuentra el registro en la Base de datos",HttpStatus.BAD_REQUEST);
    }


}
