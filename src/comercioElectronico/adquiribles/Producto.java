package comercioElectronico.adquiribles;

import comercioElectronico.excepciones.PrecioDeProdctoInvalidoException;

public class Producto {

    private String nombre_;
    private double precio_;

    public Producto(String nombre, double precio) throws PrecioDeProdctoInvalidoException {
        if(precio <= 0)
            throw new PrecioDeProdctoInvalidoException();
        this.nombre_ = nombre;
        this.precio_ = precio;
    }

    public String getNombre() {
        return nombre_;
    }

    public double getPrecio() {
        return precio_;
    }
}
