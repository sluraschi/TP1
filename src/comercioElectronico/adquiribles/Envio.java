package comercioElectronico.adquiribles;

public class Envio {

    private static int costoDeEnvio;
    private static int valorDeBonificacion;

    public Envio(){
        costoDeEnvio = 100;
        valorDeBonificacion = 5000;
    }

    public int getCostoDeEnvio() {
        return costoDeEnvio;
    }

    public int getValorDeBonificacion() {
        return valorDeBonificacion;
    }
}
