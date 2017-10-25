package comercioElectronico.compras.Decorador;

import comercioElectronico.compras.Compra;

public abstract class Decorador implements Compra {
    protected Compra compra_;

    public Decorador(Compra compra){
        this.compra_ = compra;
    }
}
