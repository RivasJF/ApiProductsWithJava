package dev.rivasjf.ServicioProductos.controller;

import dev.rivasjf.ServicioProductos.dto.ProductoCreateDto;
import dev.rivasjf.ServicioProductos.dto.ProductoDto;
import dev.rivasjf.ServicioProductos.dto.ProductoResponseDto;
import dev.rivasjf.ServicioProductos.dto.ProductoUpdateDto;
import dev.rivasjf.ServicioProductos.service.IProductoService;
import jakarta.validation.Valid;
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

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDto> traerProducto(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(productoService.traerProducto(id));
    }

    @PostMapping()
    public ResponseEntity<ProductoDto> crearProducto(@Valid @RequestBody ProductoCreateDto productoCreateDto) {
        ProductoDto nuevoProducto = productoService.crearProducto(productoCreateDto);
        return ResponseEntity.created(URI.create("/api/productos/"+nuevoProducto.getId())).body(nuevoProducto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductoDto> actualizarParcialProducto(@PathVariable("id") UUID id, @Valid @RequestBody ProductoUpdateDto productoUpdateDto) {
        return ResponseEntity.ok(productoService.actualizarProducto(id, productoUpdateDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable("id") UUID id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }


}
