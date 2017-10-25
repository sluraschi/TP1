package test.compraTest;

import comercioElectronico.AlgoBay;
import comercioElectronico.compras.Compra;
import comercioElectronico.compras.CompraSimple;
import comercioElectronico.adquiribles.Producto;
import org.junit.Assert;
import org.junit.Test;

public class CompraSimpleTest {

    @Test
    public void crearCompraSimpleSinProductos(){
        Compra compraSimple = new CompraSimple();
        Assert.assertEquals(compraSimple.cantidadDeProductos(), 0);
    }

    @Test
    public void agergarProductoACompraSimple(){
        AlgoBay comercio = new AlgoBay();
        Compra compraSimple = comercio.crearNuevaCompra();
        Producto prod = comercio.agregarProductoConPrecio("zapato", 10);

        comercio.agregarProductoEnCompra(prod, compraSimple);
        Assert.assertEquals(compraSimple.cantidadDeProductos(), 1);
    }

    @Test
    public void obtenerElPrecioDeUnaCompraSimple(){
        AlgoBay comercio = new AlgoBay();
        Compra compraSimple = comercio.crearNuevaCompra();
        Producto producto1 = comercio.agregarProductoConPrecio("zapato", 100);
        Producto producto2 = comercio.agregarProductoConPrecio("caca", 12);
        Producto producto3 = comercio.agregarProductoConPrecio("pis", 15);

        comercio.agregarProductoEnCompra(producto1, compraSimple);
        comercio.agregarProductoEnCompra(producto2, compraSimple);
        comercio.agregarProductoEnCompra(producto3, compraSimple);

        Assert.assertTrue(comercio.getPrecioTotalDe(compraSimple) == 127);
    }
}
