package dev.rivasjf.ServicioProductos.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidationErrorResponse {
    private int status;
    private Map<String, String> errors;
    private LocalDateTime timestamp;
}
