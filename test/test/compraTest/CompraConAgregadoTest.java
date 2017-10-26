package test.compraTest;

import comercioElectronico.AlgoBay;
import comercioElectronico.adquiribles.Producto;
import comercioElectronico.compras.Compra;
import org.junit.Assert;
import org.junit.Test;

public class CompraConAgregadoTest {

    private static final double DELTA = 1e-12;

    @Test
    public void crearCompraConEnvioSinProductos(){
        AlgoBay comercio = new AlgoBay();
        Compra compraConEnvio = comercio.crearNuevaCompraConEnvio();

        Assert.assertTrue(compraConEnvio.cantidadDeProductos() == 0);
    }

    @Test
    public void obtenerElPrecioDeUnaCompraConEnvioNoBonificado(){
        AlgoBay comercio = new AlgoBay();
        Compra compraConEnvio = comercio.crearNuevaCompraConEnvio();
        Producto prod = comercio.agregarProductoConPrecio("caca", 250);

        comercio.agregarProductoEnCompra(prod, compraConEnvio);

        Assert.assertTrue(comercio.getPrecioTotalDe(compraConEnvio) == 350);
    }

    @Test
    public void obtenerElPrecioDeUnaCompraConEnvioBonificado(){
        AlgoBay comercio = new AlgoBay();
        Compra compraConEnvio = comercio.crearNuevaCompraConEnvio();
        Producto prod = comercio.agregarProductoConPrecio("caca", 5100);

        comercio.agregarProductoEnCompra(prod, compraConEnvio);

        Assert.assertTrue(comercio.getPrecioTotalDe(compraConEnvio) == 5100);
    }

    @Test
    public void crearCompraConGarantiaSinProductos(){
        AlgoBay comercio = new AlgoBay();
        Compra compraConGarantia = comercio.crearNuevaCompraConGarantia();

        Assert.assertTrue(compraConGarantia.cantidadDeProductos() == 0);
    }

    @Test
    public void obtenerPrecioDeCompraConGarantia(){
        AlgoBay comercio = new AlgoBay();
        Compra compraConGarnatia = comercio.crearNuevaCompraConGarantia();
        Producto prod = comercio.agregarProductoConPrecio("zapato", 100);

        comercio.agregarProductoEnCompra(prod, compraConGarnatia);

        Assert.assertEquals(comercio.getPrecioTotalDe(compraConGarnatia), 110, DELTA);
    }

    @Test
    public void obtenerElPrecioDeUnaCompraConEnvioNoBonificadoYGarantia(){
        AlgoBay comercio = new AlgoBay();
        Compra compraConEYG = comercio.crearNuevaCompraConEnvioYGarantia();

        Producto prod = comercio.agregarProductoConPrecio("caca", 150);
        comercio.agregarProductoEnCompra(prod, compraConEYG);

        Assert.assertTrue(comercio.getPrecioTotalDe(compraConEYG) == 265);
    }

    @Test
    public void obtenerPrecioDeCompraConEnvioBonificadoYGarantia(){
        AlgoBay comercio = new AlgoBay();
        Compra compraConEYG = comercio.crearNuevaCompraConEnvioYGarantia();

        Producto prod = comercio.agregarProductoConPrecio("caca", 5200);
        comercio.agregarProductoEnCompra(prod, compraConEYG);

        Assert.assertEquals(5720, comercio.getPrecioTotalDe(compraConEYG), DELTA);
    }
}
