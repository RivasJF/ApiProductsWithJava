package dev.rivasjf.ServicioProductos.exeption;

import dev.rivasjf.ServicioProductos.exeption.dto.ErrorResponse;
import dev.rivasjf.ServicioProductos.exeption.dto.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tools.jackson.databind.exc.InvalidFormatException;
import tools.jackson.databind.exc.UnrecognizedPropertyException;

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

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleUnknowField(HttpMessageNotReadableException ex) {
        if (ex.getCause() instanceof UnrecognizedPropertyException cause){
            String field = cause.getPropertyName();
            return ResponseEntity.badRequest().body(new ErrorResponse(400,
                    "Unknown field: " + field,
                    LocalDateTime.now())
            );
        }
        if (ex.getCause() instanceof InvalidFormatException cause) {
            String field = cause.getPath().get(0).getPropertyName();
            String message = "El campo "+ field + "tiene un formato invalido";
            return ResponseEntity.badRequest().body(new ErrorResponse(400,
                    "El campo '"+ field + "' tiene un formato invalido",
                    LocalDateTime.now()));
        }
        return ResponseEntity.badRequest().body(new ErrorResponse(400,
                "Invalid request body",
                LocalDateTime.now()
        ));
    }
}
