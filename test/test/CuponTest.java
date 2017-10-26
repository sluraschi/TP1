package test;

import comercioElectronico.AlgoBay;
import comercioElectronico.compras.Compra;
import comercioElectronico.adquiribles.Cupon;
import comercioElectronico.adquiribles.Producto;
import org.junit.Assert;
import org.junit.Test;

public class CuponTest {

    private static final double DELTA = 1e-12;

    @Test
    public void crearCuponDeDescuento(){
        AlgoBay comercio = new AlgoBay();
        Cupon cupon = comercio.crearCuponConPorcentaje(50);

        Assert.assertTrue(cupon.getPorcentajeDeDescuento() == 50);
    }
    @Test
    public void actualizarElCuponDeUnaCompraSimpleConUnoMayorYSeQuedaElMayor(){
        AlgoBay comercio = new AlgoBay();
        Compra compra = comercio.crearNuevaCompra();
        Producto prod = comercio.agregarProductoConPrecio("pis", 100);
        Cupon cuponDe10Porciento = comercio.crearCuponConPorcentaje(10);
        Cupon cuponDe20Porciento = comercio.crearCuponConPorcentaje(20);

        comercio.agregarProductoEnCompra(prod, compra);
        comercio.agregarCuponEnCompra(cuponDe10Porciento, compra);
        comercio.agregarCuponEnCompra(cuponDe20Porciento, compra);

        Assert.assertTrue(compra.getCupon() == cuponDe20Porciento);
    }

    @Test
    public void actualizarElCuponDeUnaCompraSimpleConUnoMenorYDebeMantenerseElAnterior(){
        AlgoBay comercio = new AlgoBay();
        Compra compra = comercio.crearNuevaCompra();
        Producto prod = comercio.agregarProductoConPrecio("pis", 100);
        Cupon cuponDe10Porciento = comercio.crearCuponConPorcentaje(10);
        Cupon cuponDe20Porciento = comercio.crearCuponConPorcentaje(20);

        comercio.agregarProductoEnCompra(prod, compra);
        comercio.agregarCuponEnCompra(cuponDe20Porciento, compra);
        comercio.agregarCuponEnCompra(cuponDe10Porciento, compra);

        Assert.assertTrue(compra.getCupon() == cuponDe20Porciento);
    }


    @Test
    public void aplicarCuponDeDescuentoACompraSimple(){
        AlgoBay comercio = new AlgoBay();
        Cupon cupon = comercio.crearCuponConPorcentaje(10);
        Compra compra = comercio.crearNuevaCompra();
        Producto producto = comercio.agregarProductoConPrecio("caca", 100);

        comercio.agregarProductoEnCompra(producto, compra);
        comercio.agregarCuponEnCompra(cupon, compra);

        Assert.assertTrue(comercio.getPrecioTotalDe(compra) == 90);
    }

    @Test
    public void aplicarCuponDeDescuentoACompraConEnvio(){
        AlgoBay comercio = new AlgoBay();
        Compra compra = comercio.crearNuevaCompraConEnvio();
        Producto prod = comercio.agregarProductoConPrecio("pis", 150);
        Cupon cuponDe10Porciento = comercio.crearCuponConPorcentaje(10);

        comercio.agregarProductoEnCompra(prod, compra);
        comercio.agregarCuponEnCompra(cuponDe10Porciento, compra);

        Assert.assertTrue(comercio.getPrecioTotalDe(compra) == 225);
    }

    @Test
    public void aplicarCuponDeDescuentoACompraConGarantia(){
        AlgoBay comercio = new AlgoBay();
        Compra compra = comercio.crearNuevaCompraConGarantia();
        Producto prod = comercio.agregarProductoConPrecio("zapato", 100);
        Cupon cuponDe20porciento = comercio.crearCuponConPorcentaje(20);

        comercio.agregarProductoEnCompra(prod, compra);
        comercio.agregarCuponEnCompra(cuponDe20porciento, compra);

        Assert.assertEquals(comercio.getPrecioTotalDe(compra), 88, DELTA);
    }

    @Test
    public void aplicarCuponDeDescuentoACompraConEnvioYGarantia(){
        AlgoBay comercio = new AlgoBay();
        Compra compra = comercio.crearNuevaCompraConEnvioYGarantia();
        Producto prod = comercio.agregarProductoConPrecio("pis", 150);
        Cupon cuponDe10Porciento = comercio.crearCuponConPorcentaje(10);

        comercio.agregarProductoEnCompra(prod, compra);
        comercio.agregarCuponEnCompra(cuponDe10Porciento, compra);

        Assert.assertEquals(238.5, comercio.getPrecioTotalDe(compra), DELTA);
    }
}
