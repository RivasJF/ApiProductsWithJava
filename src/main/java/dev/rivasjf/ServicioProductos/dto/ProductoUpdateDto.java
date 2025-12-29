package dev.rivasjf.ServicioProductos.dto;

import dev.rivasjf.ServicioProductos.model.Producto;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class ProductoUpdateDto {
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;
    @DecimalMin(value = "0.01", inclusive = true, message = "El precio debe ser mayor a 0")
    private Double precio;
    @Min(value = 0, message = "La cantidad debe ser mayor o igual a 0")
    private Integer cantidad;

    public void applyPatch(Producto producto){
        if (nombre != null) producto.setNombre(nombre);
        if (precio != null) producto.setPrecio(precio);
        if (cantidad != null) producto.setCantidad(cantidad);
    }
}

