package dev.rivasjf.ServicioProductos.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class ProductoCreateDto {
    @NotBlank(message = "El nombre es requerido")
    private String nombre;
    @NotNull(message = "El precio es requerido")
    @Min(value = 0, message = "El precio debe ser mayor o igual a 0")
    private Double precio;
    @NotNull(message = "La cantidad es requerida")
    @Min(value = 0, message = "La cantidad debe ser mayor o igual a 0")
    private Integer cantidad;
}
