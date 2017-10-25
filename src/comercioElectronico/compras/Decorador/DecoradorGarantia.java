package comercioElectronico.compras.Decorador;

import comercioElectronico.adquiribles.Cupon;
import comercioElectronico.adquiribles.Garantia;
import comercioElectronico.adquiribles.Producto;
import comercioElectronico.compras.Compra;

public class DecoradorGarantia extends Decorador {

    private Garantia garantia_;

    public DecoradorGarantia(Compra compra) {
        super(compra);
        garantia_ = new Garantia();
    }

    @Override
    public void setCupon(Cupon cupon) {
        compra_.setCupon(cupon);
    }

    @Override
    public Cupon getCupon() {
        return compra_.getCupon();
    }

    @Override
    public void agregarProducto(Producto producto) {
        compra_.agregarProducto(producto);
    }

    @Override
    public int cantidadDeProductos() {
        return compra_.cantidadDeProductos();
    }

    @Override
    public double precioDeCompra() {
        double precio = compra_.precioDeCompra();
        return precio * agregarGarantia();
    }

    private double agregarGarantia() {
        return garantia_.getModificadorDeGarantia();
    }

    @Override
    public double aplicarCupon(double precio) {
        return compra_.aplicarCupon(precio);
    }
}
