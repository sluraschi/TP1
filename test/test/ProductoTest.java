package test;

import comercioElectronico.AlgoBay;
import comercioElectronico.adquiribles.Producto;
import org.junit.Assert;
import org.junit.Test;

public class ProductoTest {

    @Test
    public void crearProductoConNombreYPrecio(){
        Producto productoDePrueba = new Producto("zapato", 150);

        Assert.assertNotNull(productoDePrueba);
    }

    @Test
    public void actualizarPrecioDeProductoYaIngresado(){
        AlgoBay comercio = new AlgoBay();

        comercio.agregarProductoConPrecio("pis",10);
        comercio.agregarProductoConPrecio("caca", 25);
        comercio.agregarProductoConPrecio("pis", 30);

        Assert.assertTrue(comercio.getCantidadDeProductos() == 2);
        Assert.assertTrue(comercio.getProducto("pis").getPrecio() == 30);
    }

    @Test
    public void buscarUnProductoYaIngrsado(){
        AlgoBay comercio = new AlgoBay();
        Producto prod1 = comercio.agregarProductoConPrecio("zapato", 25);
        comercio.agregarProductoConPrecio("mesa", 10);

        Assert.assertEquals(comercio.getProducto("zapato"), prod1);
    }

    @Test
    public void buscarUnProductoNoIngrsadoYDebeSerNull(){
        AlgoBay comercio = new AlgoBay();
        comercio.agregarProductoConPrecio("zapato", 25);
        comercio.agregarProductoConPrecio("mesa", 10);

        Assert.assertNull(comercio.getProducto("guante"));
    }
}
