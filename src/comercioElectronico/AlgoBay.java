package comercioElectronico;

import comercioElectronico.adquiribles.Cupon;
import comercioElectronico.adquiribles.Producto;
import comercioElectronico.compras.Compra;
import comercioElectronico.compras.CompraSimple;
import comercioElectronico.compras.Decorador.DecoradorEnvio;
import comercioElectronico.compras.Decorador.DecoradorGarantia;
import comercioElectronico.excepciones.PrecioDeProdctoInvalidoException;
import comercioElectronico.excepciones.ValorDeCuponInvalidoException;

import java.util.HashMap;
import java.util.Map;

public class AlgoBay {

    private Map<String, Producto> productos;

    public AlgoBay(){
        this.productos = new HashMap<String, Producto>();
    }

    public Map<String, Producto> getProductos() {
        return productos;
    }

    public int getCantidadDeProductos() {
        return this.productos.size();
    }

    public Producto agregarProductoConPrecio(String nombre, int precio) {
        Producto producto = null;
        try {
            producto = new Producto(nombre, precio);
            this.productos.put(nombre, producto);

        } catch (PrecioDeProdctoInvalidoException e){
            System.err.println("el precio del producto debe ser mayor a 0!");
        }

        return producto;
    }
    public Producto getProducto(String nombre) {
        return this.productos.get(nombre);
    }

    public void agregarProductoEnCompra(Producto prod, Compra compra) {
        compra.agregarProducto(prod);
    }

    public Compra crearNuevaCompra() {
        return new CompraSimple();
    }

    public Compra crearNuevaCompraConEnvio(){
        return new DecoradorEnvio(crearNuevaCompra());
    }

    public Compra crearNuevaCompraConGarantia(){
        return new DecoradorGarantia(crearNuevaCompra());
    }

    public Compra crearNuevaCompraConEnvioYGarantia(){
        return new DecoradorEnvio(crearNuevaCompraConGarantia());
    }

    public double getPrecioTotalDe(Compra compra) {
        double precio = compra.precioDeCompra();
        return compra.aplicarCupon(precio);
    }

    public Cupon crearCuponConPorcentaje(int descuento) {
        Cupon cupon = null;
        try{
            cupon = new Cupon(descuento);
        } catch(ValorDeCuponInvalidoException e) {
            System.err.println("El descuento debe ser entre 0 y 100%!");
        }
        return cupon;
    }

    public void agregarCuponEnCompra(Cupon cupon, Compra compra) {
        if(compra.getCupon() == null || cupon.getPorcentajeDeDescuento() > compra.getCupon().getPorcentajeDeDescuento())
            compra.setCupon(cupon);
    }
}