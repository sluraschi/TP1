package comercioElectronico.adquiribles;

public class Envio {

    private int costoDeEnvio;
    private int valorDeBonificacion;

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
