package comercioElectronico.compras.Decorador;

import comercioElectronico.adquiribles.Cupon;
import comercioElectronico.adquiribles.Envio;
import comercioElectronico.adquiribles.Producto;
import comercioElectronico.compras.Compra;

public class DecoradorEnvio extends Decorador {

    private Envio envio_;

    public DecoradorEnvio(Compra compra) {
        super(compra);
        envio_ = new Envio();
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

        if(precio <= envio_.getValorDeBonificacion())
            return precio + agregarEnvio();
        return precio;
    }

    private double agregarEnvio(){
        return envio_.getCostoDeEnvio();
    }

    @Override
    public double aplicarCupon(double precio) {
        return compra_.aplicarCupon(precio);
    }
}
