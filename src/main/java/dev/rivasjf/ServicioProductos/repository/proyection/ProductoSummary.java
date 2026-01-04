package dev.rivasjf.ServicioProductos.repository.proyection;

import java.util.UUID;

public interface ProductoSummary {
    UUID getId();
    String getNombre();
    int getCantidad();
}
