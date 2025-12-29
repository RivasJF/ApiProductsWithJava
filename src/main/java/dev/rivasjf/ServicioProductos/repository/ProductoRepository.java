package dev.rivasjf.ServicioProductos.repository;

import dev.rivasjf.ServicioProductos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductoRepository extends JpaRepository<Producto, UUID> {

}
