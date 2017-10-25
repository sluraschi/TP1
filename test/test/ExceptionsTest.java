package test;

import comercioElectronico.adquiribles.Cupon;
import comercioElectronico.excepciones.PrecioDeProdctoInvalidoException;
import comercioElectronico.adquiribles.Producto;
import comercioElectronico.excepciones.ValorDeCuponInvalidoException;
import org.junit.Test;

public class ExceptionsTest {

    @Test(expected = PrecioDeProdctoInvalidoException.class)
    public void crearUnProductoConUnPrecioNegativoDebeLevantarPrecioDeProductoInvalidoException(){
        new Producto("pis", -10);
    }

    @Test(expected = ValorDeCuponInvalidoException.class)
    public void crearUnCuponConUnDescuentoIvalidoDebeLevantarValorDeCuponInvalidoException(){
        new Cupon(150);
    }
}
