package comercioElectronico.adquiribles;

import comercioElectronico.excepciones.ValorDeCuponInvalidoException;

public class Cupon {

    private int porcentajeDeDescuento;

    public Cupon(){
        porcentajeDeDescuento = 0;
    }

    public Cupon(int descuento) throws ValorDeCuponInvalidoException {
        if(descuento < 0 || descuento > 100)
            throw new ValorDeCuponInvalidoException();
        porcentajeDeDescuento = descuento;
    }

    public int getPorcentajeDeDescuento() {
        return porcentajeDeDescuento;
    }
}

