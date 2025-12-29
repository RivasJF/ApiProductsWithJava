package dev.rivasjf.ServicioProductos.mapper;

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

    public static Producto toModel (ProductoDto productoDto) {
        if (productoDto == null) return null;
        return Producto.builder()
                .nombre(productoDto.getNombre())
                .precio(productoDto.getPrecio())
                .cantidad(productoDto.getCantidad())
                .build();
    }
}
