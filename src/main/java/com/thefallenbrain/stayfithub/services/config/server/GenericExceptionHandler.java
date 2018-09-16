package com.thefallenbrain.stayfithub.services.config.server;

import org.springframework.context.MessageSource;
import org.springframework.data.rest.webmvc.RepositoryRestExceptionHandler;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ControllerAdvice(basePackageClasses = RepositoryRestExceptionHandler.class)
public class GenericExceptionHandler{

    @ExceptionHandler
    ResponseEntity<?> handleNotFound(ResourceNotFoundException o_O) {
        return new ResponseEntity("Some message", new HttpHeaders(), HttpStatus.BAD_REQUEST);    }
}
