package dev.rivasjf.ServicioProductos.mapper;

import dev.rivasjf.ServicioProductos.dto.ProductoCreateDto;
import dev.rivasjf.ServicioProductos.dto.ProductoDto;
import dev.rivasjf.ServicioProductos.model.Producto;

public class mapper {

    public static ProductoDto toDto (Producto producto) {
        if (producto == null) return null;
        return ProductoDto.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .precio(producto.getPrecio())
                .cantidad(producto.getCantidad())
                .build();
    }

    public static Producto toModel (ProductoCreateDto productoCreateDto) {
        if (productoCreateDto == null) return null;
        return Producto.builder()
                .nombre(productoCreateDto.getNombre())
                .precio(productoCreateDto.getPrecio())
                .cantidad(productoCreateDto.getCantidad())
                .build();
    }
}
