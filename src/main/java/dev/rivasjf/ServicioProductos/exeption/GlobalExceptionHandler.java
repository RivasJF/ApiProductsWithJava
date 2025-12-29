package dev.rivasjf.ServicioProductos.exeption;

import dev.rivasjf.ServicioProductos.dto.ErrorResponse;
import dev.rivasjf.ServicioProductos.dto.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundExcepton(NotFoundException ex){
        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class) 
    public ResponseEntity<ValidationErrorResponse> handlValidation(MethodArgumentNotValidException ex) {
        Map<String,String> errors = new HashMap<>();
        
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), 
                error.getDefaultMessage())        
                );
        return ResponseEntity.badRequest().body(new ValidationErrorResponse(400,errors, LocalDateTime.now()));
    }
}
