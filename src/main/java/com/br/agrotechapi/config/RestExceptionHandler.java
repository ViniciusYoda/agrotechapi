package com.br.agrotechapi.config;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.br.agrotechapi.models.RestValidationError;

@RestControllerAdvice
public class RestExceptionHandler {
   
   Logger log = LoggerFactory.getLogger(getClass());

   @ExceptionHandler(MethodArgumentNotValidException.class)
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   public ResponseEntity<List<RestValidationError>> handler(MethodArgumentNotValidException e){
      log.error("erro de validação");
      List<RestValidationError> errors = new ArrayList<>();
      e.getFieldErrors().forEach(v -> errors.add(new RestValidationError(v.getField(), v.getDefaultMessage())));
      return ResponseEntity.badRequest().body(errors);
   }
}