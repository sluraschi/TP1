package comercioElectronico.adquiribles;

public class Garantia {

    private static double modificadorDeGarantia;

    public Garantia() {
        modificadorDeGarantia = 1.1; // se agrega el 10%
    }

    public double getModificadorDeGarantia() {
        return modificadorDeGarantia;
    }
}
