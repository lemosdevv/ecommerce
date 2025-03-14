package br.mateus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import br.mateus.dto.ErrorDTO;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleResourceNotFound(ResourceNotFoundException ex) {
        ErrorDTO errorDTO = new ErrorDTO(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorDTO> handleInvalidInput(InvalidInputException ex) {
        ErrorDTO errorDTO = new ErrorDTO(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);

    }

}
