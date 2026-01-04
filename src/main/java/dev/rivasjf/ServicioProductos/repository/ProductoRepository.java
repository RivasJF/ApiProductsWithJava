package dev.rivasjf.ServicioProductos.repository;

import dev.rivasjf.ServicioProductos.model.Producto;
import dev.rivasjf.ServicioProductos.repository.proyection.ProductoSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, UUID> {

    @Query("SELECT p.id AS id, p.nombre AS nombre, p.cantidad AS cantidad FROM Producto p WHERE p.id = :id")
    Optional<ProductoSummary> findUniqueById(@Param("id") UUID id);

}
