package com.users.users.infrastructure.exceptionHandler;

import com.users.users.application.dto.response.Response;
import com.users.users.application.dto.response.ResponseEntityBuilder;
import com.users.users.infrastructure.exception.InternalServerErrorException;
import com.users.users.infrastructure.exception.NoDataFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> details;
        details = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> /*error.getObjectName()+" " + */ error.getField() + ": " + error.getDefaultMessage()
                        + " [" + error.getRejectedValue() + "]")
                .collect(Collectors.toList());

        Response<Object> err = new Response<>();
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage("Parámetros incorrectos");
        err.setData(details);

        return ResponseEntityBuilder.build(err);
    }

    @ExceptionHandler(NoDataFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> notFoundException(NoDataFoundException ex){
        List<String> details= new ArrayList<>();
        details.add(ex.getMessage());

        Response<Object> err = new Response<>();
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage("Datos no encontrados");
        return ResponseEntityBuilder.build(err);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> userInternalServerErrorException(InternalServerErrorException ex){
        List<String> details= new ArrayList<>();
        details.add(ex.getMessage());

        Response<Object> err = new Response<>();
        err.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        err.setMessage("Mensaje de error");
        return ResponseEntityBuilder.build(err);
    }

    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> dataAccessException(DataAccessException ex){
        List<String> details= new ArrayList<>();
        details.add(ex.getMessage());

        Response<Object> err = new Response<>();
        err.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        err.setMessage("Error interno");
        return ResponseEntityBuilder.build(err);
    }




    /*
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handlerGlobalException(Exception exception, WebRequest webRequest){
            ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(),webRequest.getDescription(false), LocalDateTime.now());
            return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ExceptionResponse> handlerDomainException(DomainException exception, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(),webRequest.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    //revisar más a proifundidad el método
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String message = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(" "));

        ExceptionResponse res = new ExceptionResponse(message, request.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }*/
}
