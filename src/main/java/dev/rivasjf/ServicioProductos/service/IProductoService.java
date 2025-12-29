package dev.rivasjf.ServicioProductos.service;

import dev.rivasjf.ServicioProductos.dto.ProductoCreateDto;
import dev.rivasjf.ServicioProductos.dto.ProductoDto;

import java.util.List;
import java.util.UUID;

public interface IProductoService {

    List<ProductoDto> traerProdcutos();
    ProductoDto crearProducto(ProductoCreateDto productoCreateDto);
    ProductoDto actualizarProducto(UUID id, ProductoDto productoDto);
    void eliminarProducto(UUID id);
}
