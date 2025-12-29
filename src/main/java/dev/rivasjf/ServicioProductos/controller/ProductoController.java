package dev.rivasjf.ServicioProductos.controller;

import dev.rivasjf.ServicioProductos.dto.ProductoDto;
import dev.rivasjf.ServicioProductos.service.IProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private IProductoService productoService;

    public ProductoController(IProductoService productoService) { this.productoService = productoService; }

    @GetMapping()
    public ResponseEntity<List<ProductoDto>> traerProductos() {
        return ResponseEntity.ok(productoService.traerProdcutos());
    }

    @PostMapping()
    public ResponseEntity<ProductoDto> crearProducto(@RequestBody ProductoDto productoDto) {
        ProductoDto nuevoProducto = productoService.crearProducto(productoDto);
        return ResponseEntity.created(URI.create("/api/productos/"+nuevoProducto.getId())).body(nuevoProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> actualizarProducto(@PathVariable("id") UUID id, @RequestBody ProductoDto productoDto) {
        return ResponseEntity.ok(productoService.actualizarProducto(id, productoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable("id") UUID id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }


}
