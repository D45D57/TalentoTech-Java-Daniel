package com.talentotechjava.tienda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> manejarResourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
        ErrorDetalles detalles = new ErrorDetalles(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(detalles, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> manejarIllegalArgumentException(IllegalArgumentException exception, WebRequest request) {
        ErrorDetalles detalles = new ErrorDetalles(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(detalles, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> manejarGlobalException(Exception exception, WebRequest request) {
        ErrorDetalles detalles = new ErrorDetalles(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(detalles, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}