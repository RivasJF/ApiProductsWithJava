package dev.rivasjf.ServicioProductos.service;

import dev.rivasjf.ServicioProductos.dto.ProductoCreateDto;
import dev.rivasjf.ServicioProductos.dto.ProductoDto;
import dev.rivasjf.ServicioProductos.dto.ProductoResponseDto;
import dev.rivasjf.ServicioProductos.dto.ProductoUpdateDto;
import dev.rivasjf.ServicioProductos.exeption.NotFoundException;
import dev.rivasjf.ServicioProductos.mapper.mapper;
import dev.rivasjf.ServicioProductos.model.Producto;
import dev.rivasjf.ServicioProductos.repository.ProductoRepository;
import dev.rivasjf.ServicioProductos.repository.proyection.ProductoSummary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductoService implements IProductoService{

    private ProductoRepository repo;

    public ProductoService(ProductoRepository repo) { this.repo = repo; }

    @Override
    public List<ProductoDto> traerProdcutos() {
        return repo.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoResponseDto traerProducto(UUID id) {
        ProductoSummary producto = repo.findUniqueById(id)
                .orElseThrow(() -> new NotFoundException("No se encontro el producto con id " + id));
        return mapper.toResponseDto(producto);
    }

    @Override
    public ProductoDto crearProducto(ProductoCreateDto productoCreateDto) {
        Producto nuevoProducto = mapper.toModel(productoCreateDto);
        return mapper.toDto(repo.save(nuevoProducto));
    }

    @Override
    public ProductoDto actualizarProducto(UUID id, ProductoUpdateDto productoUpdateDto) {
        Producto changeProducto = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontro el producto con id " + id));

        productoUpdateDto.applyPatch(changeProducto);
        return mapper.toDto(repo.save(changeProducto));
    }

    @Override
    public void eliminarProducto(UUID id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("No se encontro el producto con id " + id);
        }
        repo.deleteById(id);
    }
}
