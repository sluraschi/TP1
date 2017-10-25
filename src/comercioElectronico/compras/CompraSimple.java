package comercioElectronico.compras;

import comercioElectronico.adquiribles.Cupon;
import comercioElectronico.adquiribles.Producto;

import java.util.LinkedList;
import java.util.ListIterator;

public class CompraSimple implements Compra {

    private LinkedList<Producto> productos;
    private Cupon cupon;

    public CompraSimple(){
        this.productos = new LinkedList<>();
        this.cupon = null;
    }

    @Override
    public void setCupon(Cupon cupon) {
        this.cupon = cupon;
    }

    @Override
    public Cupon getCupon() {
        return cupon;
    }

    @Override
    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    @Override
    public int cantidadDeProductos(){
        return this.productos.size();
    }

    @Override
    public double precioDeCompra() {
        double total = 0;
        for(ListIterator<Producto> it = this.productos.listIterator(); it.hasNext(); )
            total = (total + it.next().getPrecio());
        return total;
    }

    @Override
    public double aplicarCupon(double precio) {
        if(this.cupon != null)
            return precio - (precio * this.cupon.getPorcentajeDeDescuento() / 100);
        return precio;
    }
}