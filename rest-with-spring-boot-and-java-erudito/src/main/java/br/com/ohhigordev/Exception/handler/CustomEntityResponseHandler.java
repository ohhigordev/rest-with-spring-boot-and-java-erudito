package br.com.ohhigordev.Exception.handler;

import br.com.ohhigordev.Exception.ExceptionResponse;
import br.com.ohhigordev.Exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice // Usaremos sempre que precisarmos concentrar um tratamento que seria espalhado
/*
@ControllerAdvice - faz um tratamento global de exceptions, sendo assim, quando não tiver um
tratamento mais adequado para uma exception ele e quem faz a captura e trata da mesma.
 */
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class) // Trata os erros/exceptions genericas do servidor.
    public final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); // Error: 500;
    }

    @ExceptionHandler(ResourceNotFoundException.class) // Trata os erros/exceptions genericas do servidor.
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(Exception ex, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); // Error: 400;
    }
}
