package test;

import comercioElectronico.AlgoBay;
import comercioElectronico.adquiribles.Producto;
import comercioElectronico.compras.Compra;
import org.junit.Assert;
import org.junit.Test;

public class GarantiaTest {

    private static final double DELTA = 1e-12;

    @Test
    public void aplicarGarantiaAUnaCompra(){
        AlgoBay comercio = new AlgoBay();
        Compra compraConGarantia = comercio.crearNuevaCompraConGarantia();

        Producto prod = comercio.agregarProductoConPrecio("caca", 100);
        comercio.agregarProductoEnCompra(prod, compraConGarantia);

        Assert.assertEquals(110, comercio.getPrecioTotalDe(compraConGarantia), DELTA);
    }
}
