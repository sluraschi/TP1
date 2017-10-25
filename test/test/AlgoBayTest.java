package test;

import comercioElectronico.*;
import org.junit.Assert;
import org.junit.Test;

public class AlgoBayTest {

    @Test
    public void crearComercioYEstaVacio() {
        AlgoBay comercio = new AlgoBay();

        Assert.assertEquals(comercio.getCantidadDeProductos(), 0);
    }

    @Test
    public void agregarProductoAlComercio() {
        AlgoBay comercio = new AlgoBay();

        comercio.agregarProductoConPrecio("zapato", 25);
        Assert.assertTrue(comercio.getCantidadDeProductos() == 1);
        Assert.assertTrue(comercio.getProductos().containsKey("zapato"));
    }
}
