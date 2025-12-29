package dev.rivasjf.ServicioProductos.service;

import dev.rivasjf.ServicioProductos.dto.ProductoCreateDto;
import dev.rivasjf.ServicioProductos.dto.ProductoDto;
import dev.rivasjf.ServicioProductos.dto.ProductoUpdateDto;

import java.util.List;
import java.util.UUID;

public interface IProductoService {

    List<ProductoDto> traerProdcutos();
    ProductoDto crearProducto(ProductoCreateDto productoCreateDto);
    ProductoDto actualizarProducto(UUID id, ProductoUpdateDto productoUpdateDto);
    void eliminarProducto(UUID id);
}
