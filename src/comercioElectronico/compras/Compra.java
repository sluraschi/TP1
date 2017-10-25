package comercioElectronico.compras;

import comercioElectronico.adquiribles.Cupon;
import comercioElectronico.adquiribles.Producto;

public interface Compra {

    void setCupon(Cupon cupon);
    Cupon getCupon();
    void agregarProducto(Producto producto);
    int cantidadDeProductos();
    double precioDeCompra();
    double aplicarCupon(double precio);
}
