package dev.rivasjf.ServicioProductos.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoResponseDto {
    private UUID id;
    private String nombre;
    private int cantidad;
}
