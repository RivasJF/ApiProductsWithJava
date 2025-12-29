package dev.rivasjf.ServicioProductos.exeption;

public class NotFoundException extends RuntimeException {

    public NotFoundException (String mgs) {
        super(mgs);
    }
}
